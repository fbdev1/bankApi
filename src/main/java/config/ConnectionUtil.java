package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static String url = "jdbc:h2:~/bank;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
    private static String user = "sa";
    private static String password = "";
    private static Connection conn = null;

    public static Connection getConnection() {
            createConnection();
        return conn;
    }

    public static Connection getConnection(String url, String user, String pass) {
        if (conn == null) {
            ConnectionUtil.url = url;
            ConnectionUtil.user = user;
            ConnectionUtil.password = pass;
            createConnection();
        }
        return conn;
    }

    private static void createConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}