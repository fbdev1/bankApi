package service;

import entity.Company;

public interface CompanyService {
    String addCompany(String jsonText);
    String showCompanies();
    boolean checkCompanyPresence(Company company);
}
