package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String number;
    @ManyToOne
    @JoinColumn(name = "client_id")
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
