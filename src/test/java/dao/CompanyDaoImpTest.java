package dao;

import config.ConnectionUtil;
import entity.Card;
import entity.CompAccount;
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
    Company company1 = new Company(1, "GAZPROM");
    Company company2 = new Company(2, "LUKOIL");


    @Before
    public void setUp(){

        Connection conn = ConnectionUtil.getConnection("jdbc:h2:~/bankTest;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE"
                , "sa", "");

        companyList.add(company1);
        companyList.add(company2);
    }


    @Test
    public void showCompanies() {
        Assert.assertEquals(companyList, companyDaoImp.showCompanies());
    }
}