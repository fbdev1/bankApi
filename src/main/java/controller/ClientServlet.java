package controller;

import service.ClientService;
import service.ClientServiceImp;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClientServlet", value = "/cards")
public class ClientServlet extends HttpServlet {
    private static final ClientService csi = new ClientServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()){
        out.print(csi.showCards(Long.parseLong(request.getParameter("acc_id"))));
        out.flush();
    }catch (IOException | NumberFormatException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
        csi.makeCardByAccount(Long.parseLong(request.getParameter("acc_id")));
        } catch (NumberFormatException e){
            System.err.println(e.getMessage());
        }
        this.doGet(request,response);
    }


}
