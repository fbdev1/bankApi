package config;
import entity.Account;
import entity.Card;
import entity.Client;
import org.h2.Driver;
import org.h2.server.web.DbStarter;
import org.h2.tools.Server;
import org.h2.util.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.sql.DriverManager;
import java.util.Properties;

public class HibernateAnnotationUtil{
    private static SessionFactory sessionFactory;
    private static String driver =  "org.h2.Driver";
    private static String userName = "sa";
    private static String password = "";
    private static String connectionURL = "jdbc:h2:file:./src/bank;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
    private static String dialect = "org.hibernate.dialect.H2Dialect";

//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, driver);
//                settings.put(Environment.URL, connectionURL);
//                settings.put(Environment.USER, userName);
//                settings.put(Environment.PASS, password);
//                settings.put(Environment.DIALECT, dialect);
//                configuration.setProperties(settings);
//                configuration.addAnnotatedClass(Card.class);
//                configuration.addAnnotatedClass(Client.class);
//                configuration.addAnnotatedClass(Account.class);
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties()).build();
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }
}