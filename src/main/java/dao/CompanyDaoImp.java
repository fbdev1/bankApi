package dao;

import com.google.gson.Gson;
import config.ConnectionUtil;
import entity.CompAccount;
import entity.Company;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImp implements CompanyDao {
    public void addCompany(String name, String accNumber, double balance) {

        String SQL_INSERT_COMP = "INSERT INTO PUBLIC.COMPANIES (NAME) VALUES (?);";
        String SQL_SELECT = "SELECT * FROM PUBLIC.COMPANIES WHERE ID = (SELECT max(ID) FROM PUBLIC.COMPANIES);";
        String SQL_INSERT_ACC ="INSERT INTO PUBLIC.COMP_ACCOUNTS " +
                "(AC_NUMBER, BALANCE, COMP_ID) VALUES ( ?, ?, ?);";

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement prepSt = conn.prepareStatement(SQL_INSERT_COMP);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_ACC);
             Statement st = conn.createStatement()) {
            prepSt.setString(1, name);
            prepSt.executeUpdate();
            ResultSet rs = st.executeQuery(SQL_SELECT);
            rs.last();
            preparedStatement.setString(1, accNumber);
            preparedStatement.setDouble(2, balance);
            preparedStatement.setDouble(3, rs.getLong("ID"));
            rs.close();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Company> showCompanies() {

        List<Company> companyList = new ArrayList<>();
        String SQL = "SELECT * FROM COMPANIES JOIN COMP_ACCOUNTS CA on COMPANIES.ID = CA.COMP_ID;";
        try (Connection conn = ConnectionUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SQL)){
            while(rs.next()){
                Company company = new Company();
                company.setId(rs.getLong("ID"));
                company.setName(rs.getString("NAME"));
                company.setCompAccount(new CompAccount(
                        rs.getLong(3),rs.getString("AC_NUMBER")
                        ,rs.getDouble("BALANCE")));
                companyList.add(company);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return companyList;
    }
}
