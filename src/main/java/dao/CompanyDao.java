package dao;

public interface CompanyDao {

    void addCompany(String name, String accNumber,double balance);
    String showCompanies();

}
