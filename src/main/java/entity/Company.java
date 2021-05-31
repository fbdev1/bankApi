package entity;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "companies")

public class Company {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(name="name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List <CompAccount> compAccounts;

//    public Company(String name,List<CompAccount> compAccounts) {
//        this.compAccounts = compAccounts;
//        this.name = name;
//    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
