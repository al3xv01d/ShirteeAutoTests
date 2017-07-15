package test;

import abstraction.AbstractTest;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.dashboard.DashboardCampaignsPage;
import tools.Config;

public class TestForTest extends AbstractTest {

    @Test
    public void firstTest() {

        IndexPage pp = new IndexPage();
        pp.open(Config.indexShirteeUrl);
        pp.login(false);

        DashboardCampaignsPage dpc = new DashboardCampaignsPage();

        dpc.closePopUp();

        dpc.setLocale("eng");
        dpc.logout();


    }

    @Test
    public void secondTest() {

//        AdminLoginPage alp = PageBuilder.buildAdminLoginPage();
//        AdminFacade af = PageBuilder.buildAdminFacade();
//
//        alp.open("https://dev.shirtee.de/index.php/ffadmin");
//        alp.login();
//
//        af.openOrdersPage();
//        OrderLine pushOrderBtn = af.ordersPage.findAndGetOrder("12");
//
//        System.out.println(pushOrderBtn.getOrderId());


    }
}
