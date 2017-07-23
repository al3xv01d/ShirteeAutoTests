package index;

import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.ShopPage;
import tools.Config;
import tools.PageBuilder;

// Test 1 - login and redirect to dashboard
// Test 2 - logout from index page
// test 3 - search from index page

public class IndexPageTests extends AbstractTest {

    @Test
    public void loginAndRedirectToDashboardPage() {
        IndexPage indexPage = PageBuilder.buildIndexPage();

        indexPage.openUrl(Config.indexShirteeUrl);
        indexPage.login(false);

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index/"));
    }

    @Test
    public void logout() {
        IndexPage indexPage = PageBuilder.buildIndexPage();

        indexPage.openUrl(Config.indexShirteeUrl);

        indexPage.login(true);
        indexPage.logout();
    }

    @Test
    public void searchFromIndexPage() {
        IndexPage indexPage = PageBuilder.buildIndexPage();
        ShopPage shopPage = PageBuilder.buildShopPage();

        indexPage.openUrl(Config.indexShirteeUrl);

        indexPage.search("test");
        Assert.assertTrue(shopPage.getItemsOnPageQty() > 0);
    }

}


