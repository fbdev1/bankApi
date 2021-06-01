import dao.ClientDaoImp;
import dao.CompanyDaoImp;
import service.CompanyService;
import service.CompanyServiceImp;

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
        CompanyService cs = new CompanyServiceImp();
//        cs.addCompany("xxxxx",1111111111);
//        cs.transferFromAccTo(long idFirst, long idSecond, double sum);

    }
}
