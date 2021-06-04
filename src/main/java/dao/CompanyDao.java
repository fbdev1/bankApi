package dao;

import entity.Company;

import java.util.List;

public interface CompanyDao {

    Company addCompany(String name, String accNumber,double balance);
    List<Company> showCompanies();
    boolean checkCompanyPresence(Company company);

}
