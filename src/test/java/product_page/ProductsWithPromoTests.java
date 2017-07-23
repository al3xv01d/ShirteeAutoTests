package product_page;


import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import tools.Config;
import tools.PageBuilder;

public class ProductsWithPromoTests extends AbstractTest {
    
    


    @Test
    public void promoPopupIsPossibleToClose() {
        ProductPage productPage = PageBuilder.buildProductPage();
        productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);

        productPage.closePromoPopUp();

        Assert.assertFalse(productPage.isPromoPopUpVisible());

    }

    @Test
    public void amountPromoPopupAppearsEveryTime() {

        ProductPage productPage = PageBuilder.buildProductPage();
        productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);

        softAssert.assertTrue(productPage.isPromoPopUpAppeared());

        driver.navigate().refresh();

        softAssert.assertTrue(productPage.isPromoPopUpAppeared());

        driver.navigate().refresh();

        softAssert.assertTrue(productPage.isPromoPopUpAppeared());

        softAssert.assertAll();
    }

    @Test
    public void percentPromoPopupAppearsEveryTime() {

        ProductPage productPage = PageBuilder.buildProductPage();
        productPage.openUrl(Config.testProductUrl_1 + Config.percentPromoCode);

        softAssert.assertTrue(productPage.isPromoPopUpAppeared());

        driver.navigate().refresh();

        softAssert.assertTrue(productPage.isPromoPopUpAppeared());

        driver.navigate().refresh();

        softAssert.assertTrue(productPage.isPromoPopUpAppeared());

        softAssert.assertAll();
    }

    @Test
    public void amountPromoValueInPopup() {
        ProductPage productPage = PageBuilder.buildProductPage();
        productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);

        Assert.assertEquals(productPage.getDiscountFromPopUp(), Config.amountPromoValue, "Wrong amount discount in Promo PopUp");
    }

    @Test
    public void percentPromoValueInPopup() {
        ProductPage productPage = PageBuilder.buildProductPage();
        productPage.openUrl(Config.testProductUrl_1 + Config.percentPromoCode);

        Assert.assertEquals(Config.percentPromoValue, productPage.getDiscountFromPopUp(), "Wrong percent discount in Promo PopUp");
    }

}
