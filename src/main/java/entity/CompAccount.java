package entity;

import javax.persistence.*;

//@Entity
//@Table(name = "comp_accounts")
public class CompAccount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    long id;
//    @Column(name="ac_number")
    String ac_number;
//    @Column(name="balance")
    double balance;

    public String getAc_number() {
        return ac_number;
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

    public CompAccount(String ac_number, double balance) {
        this.ac_number = ac_number;
        this.balance = balance;
    }

    public CompAccount() {
    }
}
