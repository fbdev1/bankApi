package entity;

import javax.persistence.*;

@Entity
@Table(name = "user")

public class User {

    @Column(name = "name")
    String name;
    @Id
    @Column
    int id;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }
}
