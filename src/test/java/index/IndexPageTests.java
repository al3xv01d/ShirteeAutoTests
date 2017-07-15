package index;

import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.ShopPage;
import tools.Config;
import tools.PageBuilder;

// Test 1 - login and return to index page
// Test 2 - login and redirect to dashboard
// Test 3 - logout from index page
// test 4 - search from index page

public class IndexPageTests extends AbstractTest {

    @Test
    public void loginAndReturnToLoginPage() {
        IndexPage indexPage = PageBuilder.buildIndexPage();

        indexPage.open(Config.indexShirteeUrl);
        String loginUrl = driver.getCurrentUrl();
        indexPage.login(true);

        Assert.assertEquals(loginUrl, driver.getCurrentUrl());
    }

    @Test
    public void loginAndRedirectToDashboardPage() {
        IndexPage indexPage = PageBuilder.buildIndexPage();

        indexPage.open(Config.indexShirteeUrl);
        indexPage.login(false);

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index/"));
    }

    @Test
    public void logout() {
        IndexPage indexPage = PageBuilder.buildIndexPage();

        indexPage.open(Config.indexShirteeUrl);

        indexPage.login(true);
        indexPage.logout();
    }

    @Test
    public void searchFromIndexPage() {
        IndexPage indexPage = PageBuilder.buildIndexPage();
        ShopPage shopPage = PageBuilder.buildShopPage();

        indexPage.open(Config.indexShirteeUrl);

        indexPage.search("test");
        Assert.assertTrue(shopPage.getItemsOnPageQty() > 0);
    }

}


