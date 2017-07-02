import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import tools.Config;
import tools.PageBuilder;

/**
 * Created by User on 01.07.2017.
 */
public class ProductsPriceTests extends AbstractTest {

    @Test
    public void realPrice() {

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);







    }

}
