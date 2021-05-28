//package controller;
//
//import dao.ClientDao;
//import dao.ClientDaoImp;
//import entity.Card;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("/cards")
//public class UserController extends HttpServlet {
//
//    public UserController(){}
//
//
//
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        resp.setContentType("text/html");
//
//
//        req.setAttribute("card",  ClientDaoImp.showCards(1).getCardNumber());
//        req.getRequestDispatcher("showValue.jsp").forward(req, resp);
////        PrintWriter printWriter = resp.getWriter();
////        printWriter.write();
////        printWriter.close();
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        this.doGet(request, response);
//    }
//}