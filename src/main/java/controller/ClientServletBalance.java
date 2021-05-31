package controller;

import service.ClientService;
import service.ClientServiceImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClientServletBalance", value = "/account")
public class ClientServletBalance extends HttpServlet {
    private static final ClientService csi = new ClientServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()){
            out.print(csi.showBalance(Long.parseLong(request.getParameter("acc_id"))));
            out.flush();
        }catch (IOException | NumberFormatException e){
           System.err.println(e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            csi.incBalance(Long.parseLong(request.getParameter("acc_id"))
                    , Double.parseDouble(request.getParameter("balance")));
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
        }
        this.doGet(request,response);

    }
}
