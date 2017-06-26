import org.testng.annotations.Test;
import pages.ProductPage;
import tools.Config;
import tools.StaticPageFactory;

public class ProductPageValidationTests extends AbstractTest {

    @Test
    public void productSizeValidation() {

        ProductPage productPage = StaticPageFactory.createProductPage();

        productPage.open(Config.testProduct1);

        productPage.addToCart();

        softAssert.assertTrue(productPage.isSizeValidationMsgVisible());

        softAssert.assertAll();
    }
}
