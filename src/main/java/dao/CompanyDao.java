package dao;

import entity.Company;

import java.util.List;

public interface CompanyDao {

    void addCompany(String name, String accNumber,double balance);
    List<Company> showCompanies();

}
