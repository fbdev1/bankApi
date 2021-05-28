package dao;

import config.HibernateAnnotationUtil;
import entity.Card;
import entity.Client;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDaoImp {

    public Client showCards(long id) {
        Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Client where id=:id");
            query.setLong("id", id);
            Client client = (Client) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return client;
//            card = (Card) session.createQuery("select c from Card c where c.id = :id")
//                    .setParameter("id", id).getSingleResult();
//        } catch(Exception e){
//            System.err.println("Не удалось получить получить список всех пользователей");
//        }
//        return card;
    }
    public User getUserName(){
        Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where id=:id");
        query.setInteger("id", 1);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

}
