import com.gargoylesoftware.htmlunit.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.dashboard.DashboardCampaignsPage;
import pages.magento_admin.AdminFacade;
import pages.magento_admin.AdminLoginPage;
import pages_elements.admin.OrderLine;
import tools.Config;
import tools.PageBuilder;

public class TestFuck extends AbstractTest{

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
//        OrderLine order = af.ordersPage.findAndGetOrder("12");
//
//        System.out.println(order.getOrderId());


    }
}
