package controller;

import dao.ClientDaoImp;
import entity.Card;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/cards")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClientDaoImp cdi = new ClientDaoImp();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            out.print(cdi.showCards(Long.parseLong(request.getParameter("id"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
