
import dao.ClientDao;
import dao.ClientDaoImp;
import entity.Client;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        ClientDaoImp cd = new ClientDaoImp();
        List<Client> cl = cd.showCards();
        System.out.println(cl);

        System.out.println();
        System.out.println(cl);

    }
}
