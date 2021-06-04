package dao;

import config.ConnectionUtil;
import entity.CompAccount;
import entity.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImp implements CompanyDao {


    public boolean checkCompanyPresence(Company company) {
        boolean result= false;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM PUBLIC.COMPANIES WHERE ID = ?;";
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement prepSt = conn.prepareStatement(sqlSelect)) {
            prepSt.setLong(1, 1);
            rs = prepSt.executeQuery();
            rs.last();
            if (!rs.wasNull()){
                result = true;
            }
                rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public Company addCompany(String name, String accNumber, double balance) {

        String sqlInsertComp = "INSERT INTO PUBLIC.COMPANIES (NAME) VALUES (?);";
        String sqlSelect = "SELECT * FROM PUBLIC.COMPANIES WHERE ID = (SELECT max(ID) FROM PUBLIC.COMPANIES);";
        String sqlInsertAcc = "INSERT INTO PUBLIC.COMP_ACCOUNTS " +
                "(AC_NUMBER, BALANCE, COMP_ID) VALUES ( ?, ?, ?);";
        Company addedCompany = new Company();
        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement prepSt = conn.prepareStatement(sqlInsertComp);
             PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertAcc);
             Statement st = conn.createStatement()) {
            prepSt.setString(1, name);
            prepSt.executeUpdate();
            ResultSet rs = st.executeQuery(sqlSelect);
            rs.last();
            preparedStatement.setString(1, accNumber);
            preparedStatement.setDouble(2, balance);
            preparedStatement.setLong(3, rs.getLong("ID"));
            addedCompany.setId(rs.getLong("ID"));
            addedCompany.setName(rs.getString("NAME"));
            rs.close();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return addedCompany;
    }

    public List<Company> showCompanies() {

        List<Company> companyList = new ArrayList<>();
        String sql = "SELECT * FROM COMPANIES JOIN COMP_ACCOUNTS CA on COMPANIES.ID = CA.COMP_ID;";
        try (Connection conn = ConnectionUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Company company = new Company();
                company.setId(rs.getLong("ID"));
                company.setName(rs.getString("NAME"));
                company.setCompAccount(new CompAccount(
                        rs.getLong(3), rs.getString("AC_NUMBER")
                        , rs.getDouble("BALANCE")));
                companyList.add(company);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return companyList;
    }
}
