package entity;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "card_Number")
    private String cardNumber;


    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public Card(int id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;

    }

    public void setId(long id) {
        this.id = id;
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
}

