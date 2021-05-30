package dao;

import com.google.gson.Gson;
import entity.Card;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp {
    static final String JDBC_DRIVER = "org.hibernate.dialect.H2Dialect";
    static final String DATABASE_URL = "jdbc:h2:~/bank;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
    static final String USER = "sa";
    static final String PASSWORD = "";


    public String showCards(long id) throws SQLException {
        List<Card> list = new ArrayList<>();
        String SQL = "SELECT * from CARDS where CL_ACCOUNT_ID=?";
        try (Connection conn = DriverManager.
                getConnection(DATABASE_URL, USER, PASSWORD)) {
            PreparedStatement prepSt = conn.prepareStatement(SQL);
            prepSt.setLong(1, id);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                Card card = new Card();
                card.setId(rs.getLong("ID"));
                card.setCardNumber(rs.getString("CARD_NUMBER"));
                list.add(card);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return new Gson().toJson(list);
    }

    public void makeCardByAccount(String cardNumber, long id) {
        String SQL = "INSERT INTO PUBLIC.CARDS (CARD_NUMBER, CL_ACCOUNT_ID) VALUES (?,?);";
        try (Connection conn = DriverManager.
                getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement prepSt = conn.prepareStatement(SQL)) {
            prepSt.setString(1, cardNumber);
            prepSt.setLong(2, id);
            prepSt.execute();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void incBalance(long id, double money) {
        String SQL = "UPDATE PUBLIC.CL_ACCOUNTS t SET t.BALANCE = t.BALANCE + ? WHERE t.ID = ?;";
        try (Connection conn = DriverManager.
                getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement prepSt = conn.prepareStatement(SQL)) {
            prepSt.setDouble(1, money);
            prepSt.setLong(2, id);
            prepSt.execute();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public String showBalance(long id) {
        String SQL = "SELECT BALANCE FROM CL_ACCOUNTS WHERE CLIENT_ID = ?;";
        double balance = 0;
        List<String> listOfBalance = new ArrayList<>();
        ResultSet rs;
        try (Connection conn = DriverManager.
                getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement prepSt = conn.prepareStatement(SQL)) {
            prepSt.setLong(1, id);
            rs = prepSt.executeQuery();
            rs.last();
            balance = rs.getDouble("BALANCE");
            listOfBalance.add("id: "+id);
            listOfBalance.add(String.valueOf(balance));
        } catch (SQLException e) {
            e.getMessage();
        }
        return new Gson().toJson(listOfBalance);
    }

}
