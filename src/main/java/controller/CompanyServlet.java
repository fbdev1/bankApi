package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Company;
import service.CompanyService;
import service.CompanyServiceImp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "CompanyServlet", value = "/company")
public class CompanyServlet extends HttpServlet {
    private static final CompanyService csi = new CompanyServiceImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String jsonText = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            Gson gson = new GsonBuilder().create();
            Company company = gson.fromJson(jsonText, Company.class);
            csi.addCompany(company.getName(), company.getCompAccount().getBalance());
            out.print(csi.showCompanies());
            out.flush();
        } catch (IOException | NumberFormatException e) {
            out.print("Incorrect parameter"+ e.getMessage());
            out.flush();
        }
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    }
}
