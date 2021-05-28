package config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateAnnotationUtil {
        private static SessionFactory sessionFactory=buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
                try{
                        return new Configuration().configure("hibernate-annotation.cfg.xml").buildSessionFactory();
                }catch (Exception e){
                        throw new ExceptionInInitializerError(e);
                }
        }

        public static SessionFactory getSessionFactory() {
                return sessionFactory;
        }
//    public static SessionFactory sessionFactory;
//
//    public static SessionFactory buildSessionFactory() {
//
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
//                configure("hibernate-annotation.cfg.xml").build();
//        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//        return sessionFactory;
//    }
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) sessionFactory = buildSessionFactory();
//        return sessionFactory;
//    }
}