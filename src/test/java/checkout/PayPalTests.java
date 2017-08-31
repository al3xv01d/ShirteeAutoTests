package checkout;


import abstraction.AbstractTest;
import abstraction.AbstractTestNoLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import tools.*;

public class PayPalTests extends AbstractTestNoLogin{

    public PayPalTests() {
        clearCacheAfterTest = true;
    }

    @DataProvider
    public Object[][] promoType() {
        return new Object[][] {
                {"amount"},
                {"percent"}
        };
    }

    @Test
    public void oneProduct() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        checkoutPage.billingBlock.fillEmailField();
        checkoutPage.billingBlock.fillBillingForm();
        checkoutPage.paymentBlock.selectPayPalMethod();
        PopupHelper.waitCheckoutPopup();
        double totalPrice = checkoutPage.orderReviewBlock.getGrandTotalPrice();

        checkoutPage.pushOrderBtn();
        PopupHelper.waitCheckoutPopup();

        softAssert.assertEquals(PaymentHelper.getPriceFromPayPal(), totalPrice, "WRONG price in PayPal");
        softAssert.assertAll();
    }

    @Test
    public void oneProductQty() {

        int randomQty = RandomData.getRandomInt(1,3);

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        checkoutPage.billingBlock.fillEmailField();
        checkoutPage.billingBlock.fillBillingForm();
        checkoutPage.paymentBlock.selectPayPalMethod();
        PopupHelper.waitCheckoutPopup();

        for (int i =0; i < randomQty; i++) {
            checkoutPage.orderReviewBlock.getAllOrderedItems().get(0).increaseQty();
        }

        double totalPrice = checkoutPage.orderReviewBlock.getGrandTotalPrice();

        checkoutPage.pushOrderBtn();
        PopupHelper.waitCheckoutPopup();

        softAssert.assertEquals(PaymentHelper.getPriceFromPayPal(), totalPrice, "WRONG price in PayPal");
        softAssert.assertAll();
    }

    @Test
    public void coupleProductsQty() {
        int randomQty = RandomData.getRandomInt(1,3);

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndStay();

        productPage.openUrl(Config.testProductUrl_2);
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        checkoutPage.billingBlock.fillEmailField();
        checkoutPage.billingBlock.fillBillingForm();
        checkoutPage.paymentBlock.selectPayPalMethod();
        PopupHelper.waitCheckoutPopup();

        for (int i =0; i < randomQty; i++) {
            checkoutPage.orderReviewBlock.getAllOrderedItems().get(0).increaseQty();
        }

        randomQty = RandomData.getRandomInt(1,3);

        for (int i =0; i < randomQty; i++) {
            checkoutPage.orderReviewBlock.getAllOrderedItems().get(1).increaseQty();
        }

        double totalPrice = checkoutPage.orderReviewBlock.getGrandTotalPrice();

        checkoutPage.pushOrderBtn();
        PopupHelper.waitCheckoutPopup();

        softAssert.assertEquals(PaymentHelper.getPriceFromPayPal(), totalPrice, "WRONG price in PayPal");
        softAssert.assertAll();
    }

    @Test(dataProvider = "promoType")
    public void productWithPromo(String promoType) {
        int randomQty = RandomData.getRandomInt(1,3);

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        if(promoType == "amount") {
            productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);
        }else {
            productPage.openUrl(Config.testProductUrl_1 + Config.percentPromoCode);
        }

        productPage.closePromoPopUp();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        checkoutPage.billingBlock.fillEmailField();
        checkoutPage.billingBlock.fillBillingForm();
        checkoutPage.paymentBlock.selectPayPalMethod();
        PopupHelper.waitCheckoutPopup();

        for (int i =0; i < randomQty; i++) {
            checkoutPage.orderReviewBlock.getAllOrderedItems().get(0).increaseQty();
        }

        softAssert.assertTrue(checkoutPage.orderReviewBlock.isThereAppliedPromoCodes(), "THERE IS NO APPLIED PROMO CODES!!!");
        double totalPrice = checkoutPage.orderReviewBlock.getGrandTotalPrice();

        checkoutPage.pushOrderBtn();
        PopupHelper.waitCheckoutPopup();

        softAssert.assertEquals(PaymentHelper.getPriceFromPayPal(), totalPrice, "WRONG price in PayPal");
        softAssert.assertAll();
    }


}
