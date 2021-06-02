package entity;
import java.util.List;
public class Client {

    private long client_id;
    private String name;
    private String surname;
    private String email;
    private List<Account> accountList;
    public List<Account> getAccountList() {
        return accountList;
    }
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public Client(String name, String surname, String email, List<Account> accountList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.accountList = accountList;
    }

    public Client() {
    }

    public long getId() {
        return client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
