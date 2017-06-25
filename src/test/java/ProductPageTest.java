import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import pages_elements.checkout.BillingBlock;
import pages_elements.checkout.OrderReviewBlock;
import tools.Driver;
import tools.StaticPageFactory;;

public class ProductPageTest extends AbstractTest{


//    @DataProvider(name="fuckData")
//    public Object[][] fuckData()
//    {
//        return new Object[][] {
//                new Object[] {"111111"},
//                new Object[] {"22222"}
//        };
//    }
//
    @Test
    public void testSize() {
        ProductPage pp = StaticPageFactory.createProductPage();
        Driver.getDriver().get("https://www.shirtee.com/gezeichnet");
        pp.logIn(true);
        //Driver.getDriver().get("https://www.shirtee.com/gezeichnet");
        pp.addToCart();

        CheckoutPage cp = new CheckoutPage();
        cp.paymentBlock.selectBankMethod();






    }

}
