package product_page;

import abstraction.AbstractTest;
import org.testng.annotations.Test;
import pages.ProductPage;
import tools.Config;
import tools.StaticPageFactory;

public class ValidationTests extends AbstractTest {

    @Test
    public void missingProductSizeValidation() {

        ProductPage productPage = StaticPageFactory.createProductPage();

        productPage.openUrl(Config.testProductUrl_1);

        productPage.pressAddToCartBtn();

        softAssert.assertTrue(productPage.isSizeValidationMsgVisible());

        softAssert.assertAll();
    }
}
