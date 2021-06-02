package service;

import com.google.gson.Gson;
import dao.CompanyDao;
import dao.CompanyDaoImp;
import entity.Company;

import java.util.List;
import java.util.Random;

public class CompanyServiceImp implements CompanyService {
    private static final CompanyDao cdi = new CompanyDaoImp();

   public void addCompany(String name, double balance) {
        StringBuilder accNumber = new StringBuilder();
        int min = 1000;
        int max = 10000;
        int diff = max - min;

        accNumber.append(new Random().nextInt(diff + 1) + min + "")
                .append(new Random().nextInt(diff + 1) + min + "")
                .append(new Random().nextInt(diff + 1) + min + "")
                .append(new Random().nextInt(diff + 1) + min+"")
                .append(new Random().nextInt(diff + 1) + min);

        cdi.addCompany(name, accNumber.toString(), balance);

    }
    public String showCompanies(){
       List<Company> s = cdi.showCompanies();
        if(s.isEmpty()){
            return "Companies did not found";
        }
       return new Gson().toJson(s);
    }
}
