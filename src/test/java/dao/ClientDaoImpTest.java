package dao;

import config.ConnectionUtil;
import entity.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class ClientDaoImpTest {

    static ClientDaoImp clientDaoImp = new ClientDaoImp();
    List<Card> cardList = new ArrayList<>();

    @Before
    public void setUp() {
        cardList.add(new Card(1, "9999 9999"));
        cardList.add(new Card(2, "0000 0000"));
        Connection connectionUtil = ConnectionUtil.getConnection("jdbc:h2:~/bankTest;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE"
                , "sa", "");
    }

    @Test
    public void showCardsByAccId() {
        Assert.assertEquals(cardList, clientDaoImp.showCardsByAccId(1));
    }

    @Test
    public void showBalanceByAccId() {
        Assert.assertEquals(clientDaoImp.showBalanceByAccId(1), "1243.0");
    }

}