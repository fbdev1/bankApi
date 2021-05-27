import config.HibernateAnnotationUtil;
import entity.Account;
import entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Session created");

        Transaction tx = session.beginTransaction();


        List<Account> list =new ArrayList<>();

        Client c1 = new Client("test", "test", "test",list);
        list.add(new Account("123123",c1));
        c1.setAccountList(list);
        session.save(c1);
        tx.commit();
    }
}
