package tools;


import pages.*;
import pages.dashboard.DashboardFacade;
import pages.dashboard.DashboardOrdersPage;
import pages.dashboard.DashboardPromotionPage;
import pages.magento_admin.AdminFacade;
import pages.magento_admin.AdminLoginPage;
import pages.magento_admin.AdminOrdersPage;
import pages_elements.checkout.BillingBlock;
import pages_elements.checkout.OrderReviewBlock;
import pages_elements.checkout.PaymentBlock;
import pages_elements.checkout.ValidationElements;
import pages_elements.designer.*;

public class PageBuilder {

    public static IndexPage buildIndexPage() {
        return new IndexPage();
    }

    public static ShopPage buildShopPage() {
        return new ShopPage();
    }

    public static ProductPage buildProductPage() {
        return new ProductPage();
    }

    public static OrderSuccessPage buildOrderSuccessPage() {
        return new OrderSuccessPage();
    }







    public static AdminFacade buildAdminFacade() {

        AdminLoginPage loginPage = new AdminLoginPage();
        AdminOrdersPage ordersPage = new AdminOrdersPage();

        return new AdminFacade(loginPage, ordersPage);
    }

    public static DashboardFacade buildDashboardFacade() {

        DashboardOrdersPage ordersPage = new DashboardOrdersPage();
        DashboardPromotionPage promoPage = new DashboardPromotionPage();

        return new DashboardFacade(ordersPage, promoPage);
    }

    public static DesignerPage buildDesignerPage() {

        DesignerStepThreeLoginForm loginForm = new DesignerStepThreeLoginForm();

        StepOneBlock step1 = new StepOneBlock();
        StepTwoBlock step2 = new StepTwoBlock();
        StepThreeBlock step3 = new StepThreeBlock(loginForm);


        DesignerPage designerPage = new DesignerPage(step1, step2, step3);

        return designerPage;
    }

    public static CheckoutPage buildCheckoutPage() {

        BillingBlock billingBlock = new BillingBlock();
        PaymentBlock paymentBlock = new PaymentBlock();
        OrderReviewBlock orderReviewBlock = new OrderReviewBlock();
        ValidationElements validationElements = new ValidationElements();

        CheckoutPage checkoutPage = new CheckoutPage(billingBlock, paymentBlock, orderReviewBlock, validationElements );

        return checkoutPage;

    }
}
