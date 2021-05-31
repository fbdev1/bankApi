import dao.ClientDaoImp;
import dao.CompanyDaoImp;

import javax.naming.NamingException;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws NamingException, SQLException {
//       ClientDaoImp cd = new ClientDaoImp();
//        String cl = cd.showCards(1);
//        System.out.println(cl);
//        cd.makeCardByAccount("testNumber",2);
//        cd.incBalance(1,9999999);
//        System.out.println( cd.showBalance(1));
        CompanyDaoImp cdi = new CompanyDaoImp();
        cdi.addCompany("test test test test",11111111);

    }
}
