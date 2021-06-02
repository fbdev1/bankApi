package dao;

import entity.Card;

import java.util.List;

public interface ClientDao {
    List<Card> showCardsByAccId(long id);
    void makeCardByAccId(String cardNumber, long id);
    void incBalanceByAccId(long id, double money);
    String showBalanceByAccId(long id);

}
