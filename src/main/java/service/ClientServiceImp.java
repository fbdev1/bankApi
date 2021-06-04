package service;

import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import dao.ClientDao;
import dao.ClientDaoImp;
import entity.Card;

public class ClientServiceImp implements ClientService {

private static final ClientDao cdi = new ClientDaoImp();

    public void makeCardByAccount(long id) {
        StringBuilder cardNumber = new StringBuilder();
        int min = 1000;
        int max = 10000;
        int diff = max - min;

        cardNumber.append(new Random().nextInt(diff + 1) + min + " ")
                .append(new Random().nextInt(diff + 1) + min + " ")
                .append(new Random().nextInt(diff + 1) + min + " ")
                .append(new Random().nextInt(diff + 1) + min);
        cdi.makeCardByAccId(cardNumber.toString(), id);
    }

    @Override
    public String showCards(long id) {
        List<Card> list = cdi.showCardsByAccId(id);
        if (list.isEmpty()) {
            return "Account not found: " + id;
        }
        return new Gson().toJson(list);
    }

    @Override
    public void incBalance(long id, double money) {
        cdi.incBalanceByAccId(id, money);
    }

    @Override
    public String showBalance(long id) {
        String s = cdi.showBalanceByAccId(id);
        if (s.equals("")) {
            return "Account not found: " + id;
        }
        return new Gson().toJson(s);
    }
}
