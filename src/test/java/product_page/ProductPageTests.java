package product_page;


import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import tools.Config;
import tools.PageBuilder;

public class ProductPageTests extends AbstractTest{

    @Test
    public void addToCartAndContinueShopping() {
        ProductPage productPage = PageBuilder.buildProductPage();

        productPage.openUrl(Config.testProductUrl_1);

        String currentUrl = driver.getCurrentUrl();

        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndStay();

        Assert.assertEquals(currentUrl, driver.getCurrentUrl() );
    }

    @Test
    public void addToCartAndCheckCartCounter() {
        ProductPage productPage = PageBuilder.buildProductPage();

        productPage.openUrl(Config.testProductUrl_1);

        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndStay();

        softAssert.assertEquals(productPage.getCartItemsCount(), 1 );

        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndStay();

        softAssert.assertEquals(productPage.getCartItemsCount(), 2 );

        softAssert.assertAll();
    }

}
