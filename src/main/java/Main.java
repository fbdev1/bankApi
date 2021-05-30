import dao.ClientDaoImp;
import javax.naming.NamingException;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws NamingException, SQLException {
        ClientDaoImp cd = new ClientDaoImp();
        String cl = cd.showCards(1);

        System.out.println(cl);
    }
}
