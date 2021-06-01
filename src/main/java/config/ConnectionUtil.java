package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String DATABASE_URL = "jdbc:h2:~/bank;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public Connection getConnect() {
        Connection conn = null;
       try{
           conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
       }catch(SQLException e){
           System.err.println(e.getMessage());
       }
       return conn;
    }
}