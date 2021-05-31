package service;

public interface ClientService {
    String showCards(long id);
    void makeCardByAccount(long id);
    void incBalance(long id, double money);
    String showBalance(long id);
}
