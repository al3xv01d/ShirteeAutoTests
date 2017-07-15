import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import tools.Config;
import tools.PageBuilder;

public class CheckoutPageTests extends AbstractTest {

    private double SHIPPING_PRICE = 4.50;

    @Test
    public void checkShippingPrice() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        Assert.assertEquals(checkoutPage.orderReviewBlock.getShippingPrice(),SHIPPING_PRICE);
    }

    @Test
    public void backToStore() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);
        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();

        productPage.addToCartAndGoToCheckout();

        checkoutPage.returnToStore();

        Assert.assertEquals(  driver.getCurrentUrl(), Config.testProductUrl_1 );


    }
}
