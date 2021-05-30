package controller;

import dao.ClientDaoImp;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ClientServlet", value = "/cards")
public class ClientServlet extends HttpServlet {
    private static final ClientDaoImp cdi = new ClientDaoImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if (request.getAttribute("acc_id") != null) {
            try {
                out.print(cdi.showCards(Long.parseLong(request.getParameter("acc_id"))));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            cdi.makeCardByAccount(request.getParameter("card_number"),
                    Long.parseLong(request.getParameter("acc_id")));

    }
}
