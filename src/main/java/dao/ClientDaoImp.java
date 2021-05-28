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

    public List<Client> showCards() {
        List<Client> list = null;
        try (Session session = HibernateAnnotationUtil.getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("select c from entity.Client c");
            list = query.list();
        } catch (Exception e) {
            System.err.println("Не удалось получить список всех пользователей");
        }
        return list;

//        Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            Query query = session.createSQLQuery("SELECT * FROM CLIENTS WHERE ID = 1");
//            Client client = (Client) query.getSingleResult();
//            session.getTransaction().commit();
//            session.close();
//            return client;
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
