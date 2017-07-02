import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.OrderSuccessPage;
import pages.ProductPage;
import pages.magento_admin.AdminFacade;
import pages_elements.admin.OrderLine;
import tools.Config;
import tools.PageBuilder;
import tools.PriceHelper;
import tools.StaticPageFactory;

public class OrderTests extends AbstractTest {

    @Test
    public void guestOrder() {

        ProductPage productPage = StaticPageFactory.createProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();
        OrderSuccessPage orderSuccessPage = PageBuilder.buildOrderSuccessPage();
        AdminFacade adminFacade = PageBuilder.buildAdminFacade();

        productPage.open(Config.testProductUrl_1);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        double realTotalPrice = PriceHelper.getRealPrice(checkoutPage.orderReviewBlock.getGrandTotalPrice());

        System.out.println(realTotalPrice);

        checkoutPage.billingBlock.fillEmailField();
        checkoutPage.billingBlock.selectGender("man", "billing");
        checkoutPage.billingBlock.fillBillingForm();

        checkoutPage.billingBlock.openShippingAdressForm();
        checkoutPage.billingBlock.selectGender("man", "shipping");
        checkoutPage.billingBlock.fillShippingForm();


        checkoutPage.paymentBlock.selectBankMethod();
        checkoutPage.order();

        String savedOrderIdFromCheckoutPage = orderSuccessPage.getOrderId();

        adminFacade.open(Config.adminLoginPage);
        adminFacade.loginPage.login();
        adminFacade.openOrdersPage();

        OrderLine order = adminFacade.ordersPage.findAndGetOrder(savedOrderIdFromCheckoutPage);

        softAssert.assertEquals( savedOrderIdFromCheckoutPage, order.getOrderId() );
        softAssert.assertEquals(realTotalPrice, order.getRealOrderPrice());

        softAssert.assertAll();

    }

    @Test
    public void authorizedUserOrder(){

        ProductPage productPage = StaticPageFactory.createProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();
        OrderSuccessPage orderSuccessPage = PageBuilder.buildOrderSuccessPage();
        AdminFacade adminFacade = PageBuilder.buildAdminFacade();

    }
}
