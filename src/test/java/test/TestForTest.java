package test;

import abstraction.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.dashboard.DashboardCampaignsPage;
import tools.Config;

public class TestForTest  {

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {"Fuck1", "Fuck2", "Fuck3"},
                {"cunt1", "cunt2", "cunt3"}
        };
    }


    public void firstTest() {


    }

    @Test(dataProvider = "data")
    public void secondTest(String ffm, String ffm2, String ffm3) {

        System.out.println(ffm);
        System.out.println(ffm2);
        System.out.println(ffm3);

    }
}

