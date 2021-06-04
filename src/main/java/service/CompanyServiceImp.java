package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.CompanyDao;
import entity.Company;

import java.util.List;
import java.util.Random;

public class CompanyServiceImp implements CompanyService {
    private final CompanyDao cdi;

    public CompanyServiceImp(CompanyDao dao) {
        this.cdi = dao;
    }

    public boolean checkCompanyPresence(Company company){
           return  cdi.checkCompanyPresence(company);
    }

    private String accNumberCreate() {
        StringBuilder accNumber = new StringBuilder();
        int min = 1000;
        int max = 10000;
        int diff = max - min;

        accNumber.append(new Random().nextInt(diff + 1) + min + "")
                .append(new Random().nextInt(diff + 1) + min + "")
                .append(new Random().nextInt(diff + 1) + min + "")
                .append(new Random().nextInt(diff + 1) + min + "")
                .append(new Random().nextInt(diff + 1) + min);
        return accNumber.toString();
    }

    public String addCompany(String jsonText) {
        Gson gson = new GsonBuilder().create();
        Company company;
        try {
            company = gson.fromJson(jsonText, Company.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Invalid input format " + e.getMessage();
        }
        String name = company.getName();
        double balance = company.getCompAccount().getBalance();
        return new Gson().toJson(cdi.addCompany(name, accNumberCreate(), balance));
    }

    public String showCompanies() {
        List<Company> s = cdi.showCompanies();
        if (s.isEmpty()) {
            return "Companies did not found";
        }
        return new Gson().toJson(s);
    }
}
