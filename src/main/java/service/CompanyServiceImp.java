package service;

import dao.ClientDaoImp;
import dao.CompanyDao;
import dao.CompanyDaoImp;

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
       String s = cdi.showCompanies();
        if(s.equals("[]")){
            return "Companies did not found";
        }
       return s;
    }
}
