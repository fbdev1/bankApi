package entity;

public class Company {
    private long id;
    private String name;
    private CompAccount compAccount;

    public Company(String name) {
        this.name = name;
    }

    public CompAccount getCompAccount() {
        return compAccount;
    }

    public void setCompAccount(CompAccount compAccount) {
        this.compAccount = compAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
