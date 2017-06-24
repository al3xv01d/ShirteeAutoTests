import org.testng.annotations.Test;
import pages.ProductPage;
import pages.CheckoutFacade;
import pages_elements.checkout.CheckoutBillingBlock;
import pages_elements.checkout.CheckoutValidationElements;
import tools.Driver;
import tools.StaticPageFactory;;

public class ProductPageTest extends AbstractTest{

    @Test
    public void testSize() {
        ProductPage pp = StaticPageFactory.createProductPage();
        Driver.getDriver().get("https://www.shirtee.de/gezeichnet");
        pp.addToCart();

        CheckoutBillingBlock ff = new CheckoutBillingBlock();
        ff.toggleShippingAdressForm();


        CheckoutValidationElements fuck = new CheckoutValidationElements();


    }

}
