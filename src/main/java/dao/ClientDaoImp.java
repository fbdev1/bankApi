package dao;

import com.google.gson.Gson;
import config.ConnectionUtil;
import entity.Card;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp implements ClientDao{

    public static final ConnectionUtil connUtil= new ConnectionUtil();

    public String showCards(long id) {
        List<Card> list = new ArrayList<>();
        String SQL = "SELECT * from CARDS where CL_ACCOUNT_ID=?";
        try (Connection conn = connUtil.getConnect()) {
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
            System.err.println(e.getMessage());
        }
        return new Gson().toJson(list);
    }

    public void makeCardByAccount(String cardNumber, long id) {
        String SQL = "INSERT INTO PUBLIC.CARDS (CARD_NUMBER, CL_ACCOUNT_ID) VALUES (?,?);";
        try (Connection conn = connUtil.getConnect();
             PreparedStatement prepSt = conn.prepareStatement(SQL)) {
            prepSt.setString(1, cardNumber);
            prepSt.setLong(2, id);
            prepSt.execute();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void incBalance(long id, double money) {
        String SQL = "UPDATE PUBLIC.CL_ACCOUNTS t SET t.BALANCE = t.BALANCE + ? WHERE t.ID = ?;";
        try (Connection conn = connUtil.getConnect();
             PreparedStatement prepSt = conn.prepareStatement(SQL)) {
            prepSt.setDouble(1, money);
            prepSt.setLong(2, id);
            prepSt.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public String showBalance(long id) {
        String SQL = "SELECT BALANCE FROM CL_ACCOUNTS WHERE ID = ?;";
        double balance = 0;
        List<String> listOfBalance = new ArrayList<>();
        ResultSet rs;
        try (Connection conn = connUtil.getConnect();
             PreparedStatement prepSt = conn.prepareStatement(SQL)) {
            prepSt.setLong(1, id);
            rs = prepSt.executeQuery();
            rs.last();
            balance = rs.getDouble("BALANCE");
            listOfBalance.add("acc_id: " + id);
            listOfBalance.add("Balance: " + balance);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return new Gson().toJson(listOfBalance);
    }

}
