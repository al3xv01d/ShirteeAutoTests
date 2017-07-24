package checkout;


import abstraction.AbstractTestNoConfig;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.OrderSuccessPage;
import pages.ProductPage;
import pages.dashboard.DashboardFacade;
import pages.magento_admin.AdminFacade;
import pages_elements.checkout.OrderedItem;
import pages_elements.dashboard_orders.Order;
import tools.Config;
import tools.PageBuilder;
import tools.PriceHelper;

public class OrderWithPromoTests extends AbstractTestNoConfig{

    @Test
    public void authorizedOrderWithAmountPromo() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkout = PageBuilder.buildCheckoutPage();
        OrderSuccessPage orderSuccessPage = PageBuilder.buildOrderSuccessPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        productPage.openUrl(Config.indexShirteeUrl);
        productPage.setLocale("de");
        productPage.login(false);

        productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);
        productPage.closePromoPopUp();
        productPage.setRandomSizeAndGetSelected();
        productPage.setRandomColor();

        double productPrice = productPage.getOldPrice();

        productPage.addToCartAndGoToCheckout();

        double exceptedTotalPrice = PriceHelper.getFormattedDouble(productPrice - Config.amountPromoValue + Config.shippingPrice);
        double checkoutItemsCount = checkout.orderReviewBlock.getTotalItemsQty();

        checkout.paymentBlock.selectBankMethod();
        checkout.pushOrderBtn();

        String savedOrderIdFromSuccessPage = orderSuccessPage.getOrderId();

        dashboard.ordersPage.openPage();
        Order lastOrder = dashboard.ordersPage.getLastOrder();

        softAssert.assertEquals(lastOrder.getItemsQty(), checkoutItemsCount);
        softAssert.assertEquals(lastOrder.getOrderId(), savedOrderIdFromSuccessPage);
        softAssert.assertEquals(lastOrder.getTotalPrice(), exceptedTotalPrice);

        softAssert.assertAll();
    }

    @Test
    public void guestOrderWithAmountPromo() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkout = PageBuilder.buildCheckoutPage();
        OrderSuccessPage orderSuccessPage = PageBuilder.buildOrderSuccessPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();
        AdminFacade adminFacade = PageBuilder.buildAdminFacade();

        productPage.openUrl(Config.indexShirteeUrl);
        productPage.setLocale("de");

        productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);
        productPage.closePromoPopUp();
        productPage.setRandomSizeAndGetSelected();
        productPage.setRandomColor();

        double productPrice = productPage.getOldPrice();

        productPage.addToCartAndGoToCheckout();

        double exceptedTotalPrice = PriceHelper.getFormattedDouble(productPrice - Config.amountPromoValue + Config.shippingPrice);
        double checkoutItemsCount = checkout.orderReviewBlock.getTotalItemsQty();

        checkout.billingBlock.fillEmailField();
        checkout.billingBlock.selectGender("man", "billing");
        checkout.billingBlock.fillBillingForm();

        checkout.billingBlock.openShippingAdressForm();
        checkout.billingBlock.selectGender("man", "shipping");
        checkout.billingBlock.fillShippingForm();

        checkout.paymentBlock.selectBankMethod();
        checkout.pushOrderBtn();

        String savedOrderIdFromSuccessPage = orderSuccessPage.getOrderId();

        adminFacade.openUrl(Config.adminLoginPage);
        adminFacade.loginPage.login();
        adminFacade.openOrdersPage();

        dashboard.ordersPage.openPage();
        Order lastOrder = dashboard.ordersPage.getLastOrder();

        softAssert.assertEquals(lastOrder.getItemsQty(), checkoutItemsCount);
        softAssert.assertEquals(lastOrder.getOrderId(), savedOrderIdFromSuccessPage);
        softAssert.assertEquals(lastOrder.getTotalPrice(), exceptedTotalPrice);

        softAssert.assertAll();
    }


}
