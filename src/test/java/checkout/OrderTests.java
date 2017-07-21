package checkout;

import abstraction.AbstractTest;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.OrderSuccessPage;
import pages.ProductPage;
import pages.dashboard.DashboardFacade;
import pages.magento_admin.AdminFacade;
import pages_elements.admin.OrderLine;
import pages_elements.dashboard_orders.Order;
import tools.Config;
import tools.PageBuilder;
import tools.StaticPageFactory;

// Test 1 - order as a guest and check order's total price, items and ID in admin panel
// Test 2 - order as a authorized user and check order's total price, items and ID in dashboard

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

        double realTotalPrice = checkoutPage.orderReviewBlock.getGrandTotalPrice();

        checkoutPage.billingBlock.fillEmailField();
        checkoutPage.billingBlock.selectGender("man", "billing");
        checkoutPage.billingBlock.fillBillingForm();

        checkoutPage.billingBlock.openShippingAdressForm();
        checkoutPage.billingBlock.selectGender("man", "shipping");
        checkoutPage.billingBlock.fillShippingForm();


        checkoutPage.paymentBlock.selectBankMethod();
        checkoutPage.pushOrderBtn();

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
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();
        AdminFacade adminFacade = PageBuilder.buildAdminFacade();

        productPage.open(Config.testProductUrl_1);

        productPage.login(true);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        double checkoutTotalPrice = checkoutPage.orderReviewBlock.getGrandTotalPrice();
        double checkoutItemsCount = checkoutPage.orderReviewBlock.getTotalItemsQty();


        checkoutPage.paymentBlock.selectBankMethod();
        checkoutPage.pushOrderBtn();

        String savedOrderIdFromSuccessPage = orderSuccessPage.getOrderId();

        dashboard.ordersPage.openPage();
        Order lastOrder = dashboard.ordersPage.getLastOrder();

        softAssert.assertEquals(lastOrder.getItemsQty(), checkoutItemsCount);
        softAssert.assertEquals(lastOrder.getOrderId(), savedOrderIdFromSuccessPage);
        softAssert.assertEquals(lastOrder.getTotalPrice(), checkoutTotalPrice);


        System.out.println(lastOrder.getItemsQty());
        System.out.println(lastOrder.getOrderId());
        System.out.println(lastOrder.getTotalPrice());

        softAssert.assertAll();

    }
}
