package service;
import java.util.Random;
import dao.ClientDaoImp;
public class ClientServiceImp implements ClientService {
    private static final ClientDaoImp cdi = new ClientDaoImp();

    public void makeCardByAccount(long id) {
        StringBuilder cardNumber = new StringBuilder();
        int min = 1000;
        int max = 10000;
        int diff = max-min;

            cardNumber.append(new Random().nextInt(diff + 1)+min + " ")
                    .append(new Random().nextInt(diff + 1)+min + " ")
                    .append(new Random().nextInt(diff + 1)+min + " ")
                    .append(new Random().nextInt(diff + 1)+min);
            cdi.makeCardByAccount(cardNumber.toString(), id);
    }

    @Override
    public String showCards(long id) {
        String s = cdi.showCards(id);
        if(s.equals("[]")){
            return "Account not found: " + id;
        }
        return s;
    }

    @Override
    public void incBalance(long id, double money) {
        cdi.incBalance(id, money);
    }

    @Override
    public String showBalance(long id) {
        String s = cdi.showBalance(id);
        if(s.equals("[]")){
            return "Account not found: " + id;
        }
        return s;
    }
}
