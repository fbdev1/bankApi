
import dao.ClientDao;
import dao.ClientDaoImp;
import entity.Client;


public class Main {

    public static void main(String[] args) {
        ClientDaoImp cd = new ClientDaoImp();
        Client cl = cd.showCards(1);
        System.out.println(cl);

        System.out.println();
        System.out.println(cl);

    }
}
