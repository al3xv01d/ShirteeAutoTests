import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShopPage;
import tools.Config;
import tools.StaticPageFactory;

public class ShopQtySortTests extends AbstractTest {

    @Test
    public void checkFirstQtyOnPageSetting() {
        ShopPage shopPage = StaticPageFactory.createShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.setItemsQtyOnPage(shopPage.itemsOnPageSettings[0]);

        int totalItemsOnPage = shopPage.getItemsOnPageQty();

        Assert.assertEquals(shopPage.itemsOnPageSettings[0], totalItemsOnPage);
    }

    @Test
    public void checkSecondQtyOnPageSetting() {
        ShopPage shopPage = StaticPageFactory.createShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.setItemsQtyOnPage(shopPage.itemsOnPageSettings[1]);

        int totalItemsOnPage = shopPage.getItemsOnPageQty();

        Assert.assertEquals(shopPage.itemsOnPageSettings[1], totalItemsOnPage);
    }

    @Test
    public void checkThirdQtyOnPageSetting() {
        ShopPage shopPage = StaticPageFactory.createShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.setItemsQtyOnPage(shopPage.itemsOnPageSettings[2]);

        int totalItemsOnPage = shopPage.getItemsOnPageQty();

        Assert.assertEquals(shopPage.itemsOnPageSettings[2], totalItemsOnPage);
    }
}
