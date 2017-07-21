package shop;

import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ShopPage;
import tools.Config;
import tools.PageBuilder;

// Test 1 - sort by qty. After sorting on page must be 24 products
// Test 2 - sort by qty. After sorting on page must be 32 products
// Test 3 - sort by qty. After sorting on page must be 48 products

// Test 4 - product's price and title are the same on shop pfge and on product page

// Test 5 - check header's search form
// Test 6 - check left sidebar's search form

// Test 7 - check pagination
// Test 8 - qty sorting saves on others pages

public class ShopPageTests extends AbstractTest {

    //*********** SORTING BY QTY TESTS *************//

    @Test
    public void checkFirstQtyOnPageSetting() {
        ShopPage shopPage = PageBuilder.buildShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.setItemsQtyOnPage(shopPage.itemsOnPageSettings[0]);

        int totalItemsOnPage = shopPage.getItemsOnPageQty();

        Assert.assertEquals(shopPage.itemsOnPageSettings[0], totalItemsOnPage);
    }

    @Test
    public void checkSecondQtyOnPageSetting() {
        ShopPage shopPage = PageBuilder.buildShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.setItemsQtyOnPage(shopPage.itemsOnPageSettings[1]);

        int totalItemsOnPage = shopPage.getItemsOnPageQty();

        Assert.assertEquals(shopPage.itemsOnPageSettings[1], totalItemsOnPage);
    }

    @Test
    public void checkThirdQtyOnPageSetting() {
        ShopPage shopPage = PageBuilder.buildShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.setItemsQtyOnPage(shopPage.itemsOnPageSettings[2]);

        int totalItemsOnPage = shopPage.getItemsOnPageQty();

        Assert.assertEquals(shopPage.itemsOnPageSettings[2], totalItemsOnPage);
    }

    //*********** SORTING BY QTY TESTS *************//

    @Test
    public void priceAreEqualOnShopPageAndOnProductsPage() {
        ShopPage shopPage = PageBuilder.buildShopPage();
        ProductPage productPage = PageBuilder.buildProductPage();

        shopPage.open(Config.shopUrl);

        String titleOnShopPage = shopPage.getItemTitle(1);
        double priceOnShopPage = shopPage.getItemRealPrice(1);

        shopPage.openProduct(1);

        softAssert.assertEquals(titleOnShopPage, productPage.getProductName() );
        softAssert.assertEquals(priceOnShopPage, productPage.getPrice() );
    }

    @Test
    public void topSearch() {
        ShopPage shopPage = PageBuilder.buildShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.search("test");

        Assert.assertTrue(shopPage.getItemsOnPageQty() > 0);
    }

    @Test
    public void leftSidebarSearch() {
        ShopPage shopPage = PageBuilder.buildShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.leftSidebarSearch("test");

        Assert.assertTrue(shopPage.getItemsOnPageQty() > 0);
    }

    @Test
    public void checkPagination() {
        ShopPage shopPage = PageBuilder.buildShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.gotoPage(2);

        softAssert.assertTrue(driver.getCurrentUrl().contains("p=2"));
        softAssert.assertTrue(shopPage.getItemsOnPageQty() > 20);

        shopPage.gotoPage(4);

        softAssert.assertTrue(driver.getCurrentUrl().contains("p=3"));
        softAssert.assertTrue(shopPage.getItemsOnPageQty() > 20);

        softAssert.assertAll();
    }

    @Test
    public void qtySortingSavesOnOthersPages() {
        ShopPage shopPage = PageBuilder.buildShopPage();

        shopPage.open(Config.shopUrl);

        shopPage.setItemsQtyOnPage(shopPage.itemsOnPageSettings[2]); // 48

        int totalItemsOnPage = shopPage.getItemsOnPageQty();

        Assert.assertEquals(shopPage.itemsOnPageSettings[2], totalItemsOnPage);

        shopPage.gotoPage(2);

        softAssert.assertTrue(driver.getCurrentUrl().contains("p=2"));
        softAssert.assertTrue(shopPage.getItemsOnPageQty() == totalItemsOnPage);

        shopPage.gotoPage(4);

        softAssert.assertTrue(driver.getCurrentUrl().contains("p=3"));
        softAssert.assertTrue(shopPage.getItemsOnPageQty() == totalItemsOnPage);

        softAssert.assertAll();
    }
}
