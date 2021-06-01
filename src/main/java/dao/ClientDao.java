package dao;

import entity.Card;

import java.util.List;

public interface ClientDao {
    String showCards(long id);
    void makeCardByAccount(String cardNumber, long id);
    void incBalance(long id, double money);
    String showBalance(long id);

}
