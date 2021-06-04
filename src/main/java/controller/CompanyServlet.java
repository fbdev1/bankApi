package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.CompanyDao;
import dao.CompanyDaoImp;
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

    private final CompanyService csi;
    public CompanyServlet(){
        CompanyDao cdi = new CompanyDaoImp();
        this.csi = new CompanyServiceImp(cdi);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            String jsonText = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            out.print(csi.addCompany(jsonText));
            out.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            out.print(csi.showCompanies());
            out.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
