package controller;

import dao.ClientDaoImp;
import entity.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/cards")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDaoImp dao = new ClientDaoImp();
        List<Client> s = dao.showCards();

        request.setAttribute("card", s.get(0));
        request.getRequestDispatcher("showValue.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
