package dao;

import config.ConnectionUtil;
import entity.Card;
import entity.Company;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpTest {

    static CompanyDaoImp companyDaoImp = new CompanyDaoImp();
    List<Company> companyList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Connection conn = ConnectionUtil.getConnection("jdbc:h2:~/bankTest;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE"
                , "sa", "");
        companyList.add(new Company(1, "GAZPROM"));
        companyList.add(new Company(2, "LUKOIL"));
    }


    @Test
    public void showCompanies() {
        Assert.assertEquals(companyList, companyDaoImp.showCompanies());
    }
}