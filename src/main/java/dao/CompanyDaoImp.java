package dao;
import java.sql.*;

public class CompanyDaoImp implements CompanyDao {

    static final String DATABASE_URL = "jdbc:h2:~/bank;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
    static final String USER = "sa";
    static final String PASSWORD = "";

    public void addCompany(String name,double balance){
//        String SQL = "INSERT INTO PUBLIC.COMPANIES (NAME) VALUES (?);" +
//                "SELECT ID FROM PUBLIC.COMPANIES WHERE ID = MAX();"+
//                "INSERT INTO PUBLIC.COMP_ACCOUNTS (AC_NUMBER, BALANCE, COMP_ID) VALUES ( ?, ?,) ";
        try (Connection conn = DriverManager.
                getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement prepSt = conn.prepareStatement("INSERT INTO PUBLIC.COMPANIES (NAME) VALUES (?);")) {
            prepSt.setString(1, name);
            prepSt.execute();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT max(ID) FROM PUBLIC.COMPANIES;");
                    rs.last();
            long id_company = rs.getLong("ID");
            prepSt.execute("INSERT INTO PUBLIC.COMP_ACCOUNTS (AC_NUMBER, BALANCE, COMP_ID) VALUES ( ?, ?, ?);");
            prepSt.setString(1, "1234112341234132412342");
            prepSt.setDouble(2,balance);
            prepSt.setDouble(3,id_company);
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }

    }



}
