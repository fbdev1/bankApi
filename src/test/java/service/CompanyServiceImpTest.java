package service;

import com.google.gson.Gson;
import config.ConnectionUtil;
import dao.CompanyDao;
import dao.CompanyDaoImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
public class CompanyServiceImpTest {
    CompanyDao companyDao = new CompanyDaoImp();
    CompanyService companyService = new CompanyServiceImp(companyDao);
    String companies = "[{\"id\":1,\"name\":\"GAZPROM\",\"compAccount\":{\"id\":1,\"ac_number\":\"123456789\",\"balance\":9.99999999E8}}" +
            ",{\"id\":2,\"name\":\"LUKOIL\",\"compAccount\":{\"id\":2,\"ac_number\":\"987654321\",\"balance\":8.888888888E9}}]";

    @Before
    public void setUp() {
        Connection connectionUtil = ConnectionUtil.getConnection("jdbc:h2:~/bankTest;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE"
                , "sa", "");
    }

    @Test
    public void showCompaniesTest() {
        Assert.assertEquals(companyService.showCompanies(), companies);
    }
}