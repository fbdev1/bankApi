package dao;
import com.google.gson.Gson;
import entity.Card;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp {

    public String showCards(long id) throws SQLException {
        List<Card> list = new ArrayList<>();

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:~/bank", "sa", "")) {
            PreparedStatement prepSt = conn.prepareStatement("SELECT * from CARDS where CL_ACCOUNT_ID=?");
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
        Gson gson = new Gson();
        String s= gson.toJson(list);
        return s;
    }
}
