package checkout;

import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import tools.Config;
import tools.PageBuilder;

public class CheckoutPageTests extends AbstractTest {



    @Test
    public void checkShippingPrice() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        Assert.assertEquals(checkoutPage.orderReviewBlock.getShippingPrice(), Config.shippingPrice);
    }

    @Test
    public void backToStore() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);
        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();

        productPage.addToCartAndGoToCheckout();

        checkoutPage.returnToStore();

        Assert.assertFalse(  driver.getCurrentUrl().contains("checkout"), "Error in BACK TO STOLE link on checkout page" );
    }


}
