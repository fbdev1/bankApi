package controller;

import org.apache.ibatis.jdbc.ScriptRunner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "OnStartServlet", value = "/")
public class OnStartServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String url = "jdbc:h2:~/bank;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
            String user = "sa";
            String password = "";
            Connection conn = DriverManager.getConnection(url, user, password);
            ScriptRunner sr = new ScriptRunner(conn);
            Reader reader = new BufferedReader(new FileReader("/Users/u19215176/IdeaProjects/bankApi/src/main/resources/data.sql"));
            sr.runScript(reader);

        } catch (SQLException | IOException e) {
            System.err.println(e.getMessage());
        }
    }
    }
