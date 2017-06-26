import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.dashboard.DashboardCampaignsPage;
import tools.Config;

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
        Assert.assertEquals(1,1);
    }
}
