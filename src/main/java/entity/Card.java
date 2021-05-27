package entity;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "balance")
    private double balance;

    public Card(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }
    public Card(){}

    public long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

