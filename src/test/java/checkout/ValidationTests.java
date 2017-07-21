package checkout;

import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import tools.Config;
import tools.PageBuilder;


public class ValidationTests extends AbstractTest {

    @Test
    public void emptyEmailField() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        System.out.println(Config.testProductUrl_1);
        productPage.open(Config.testProductUrl_1);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        checkoutPage.billingBlock.billingEmailField.click();
        checkoutPage.clickOnEmptyPlace();

        Assert.assertTrue( checkoutPage.validationElements.isEmptyEmailMsgVisible() );
    }
}
