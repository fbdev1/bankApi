package entity;

public class Account {

    private long id;
    private String number;
    Client client;

    public Account(String number, Client client) {
        this.number = number;
        this.client = client;
    }

    public Account() {
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
