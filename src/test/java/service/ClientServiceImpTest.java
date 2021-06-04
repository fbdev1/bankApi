package service;

import config.ConnectionUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

public class ClientServiceImpTest {

    private ClientService clientService = new ClientServiceImp();
    @Before
    public void setUp(){
        Connection connectionUtil = ConnectionUtil.getConnection("jdbc:h2:~/bankTest;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE"
                , "sa", "");
    }
    @Test
    public void showBalanceTest() {
        Assert.assertEquals(clientService.showBalance(1),"\"1243.0\"");
    }

    @Test
    public void showCardsByIDTest(){
        Assert.assertEquals(clientService.showCards(1),
                "[{\"id\":1,\"cardNumber\":\"9999 9999\"},{\"id\":2,\"cardNumber\":\"0000 0000\"}]");
    }
}