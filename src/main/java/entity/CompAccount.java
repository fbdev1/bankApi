package entity;


public class CompAccount {
    long id;
    String ac_number;
    double balance;

    public String getAc_number() {
        return ac_number;
    }

    public long getId() {
        return id;
    }

    public void setAc_number(String ac_number) {
        this.ac_number = ac_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CompAccount(long id, String ac_number, double balance) {
        this.id = id;
        this.ac_number = ac_number;
        this.balance = balance;
    }

    public CompAccount(double balance) {
        this.balance = balance;

    }

}
