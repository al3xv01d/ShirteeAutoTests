package tools;


import pages.CheckoutPage;
import pages.DesignerPage;
import pages_elements.checkout.BillingBlock;
import pages_elements.checkout.OrderReviewBlock;
import pages_elements.checkout.PaymentBlock;
import pages_elements.checkout.ValidationElements;
import pages_elements.designer.*;

public class PageBuilder {

    public static DesignerPage buildDesignerPage() {

        DesignerStepThreeLoginForm loginForm = new DesignerStepThreeLoginForm();

        DesignerStepTwoProductsBlock allProducts = new DesignerStepTwoProductsBlock();

        StepOneBlock step1 = new StepOneBlock();
        StepTwoBlock step2 = new StepTwoBlock(allProducts);
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
