package entity;

import java.util.Objects;

public class Card {
    private long id;
    private String cardNumber;

    public Card( String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Card(long id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id && Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber);
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

