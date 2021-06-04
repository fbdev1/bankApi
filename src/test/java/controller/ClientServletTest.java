package controller;
import static org.junit.Assert.*;
import java.io.*;
import java.sql.Connection;
import javax.servlet.http.*;

import config.ConnectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;;

public class ClientServletTest  extends Mockito {

    @Before
    public void setUp(){
        Connection connectionUtil = ConnectionUtil.getConnection("jdbc:h2:~/bankTest;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE"
                , "sa", "");
    }
    @Test
    public void testServlet(){
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("acc_id")).thenReturn("1");
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
            when(response.getWriter()).thenReturn(writer);
        }catch (IOException e){
            e.getMessage();
        }
        new ClientServlet().doGet(request, response);
        writer.flush();
        assertTrue(stringWriter.toString().contains("9999 9999"));
    }
}