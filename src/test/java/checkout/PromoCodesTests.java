package checkout;


import abstraction.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import pages_elements.checkout.OrderedItem;
import tools.Config;
import tools.PageBuilder;
import tools.PriceHelper;

public class PromoCodesTests extends AbstractTest {

    @Test
    public void  addToCartProductWithPercentDiscount(){

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkout = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1 + Config.percentPromoCode);
        productPage.closePromoPopUp();
        productPage.setRandomSizeAndGetSelected();
        productPage.setRandomColor();

        double productPrice = productPage.getOldPrice();
        double exceptedDiscountValue = PriceHelper.getFormattedDouble( productPrice / 100 * Config.percentPromoValue );
        double expectedTotalPrice = productPrice - exceptedDiscountValue  + Config.shippingPrice;

        productPage.addToCartAndGoToCheckout();

        double discount = checkout.orderReviewBlock.getDiscountValue();
        double totalPrice = checkout.orderReviewBlock.getGrandTotalPrice();

        softAssert.assertEquals(discount, exceptedDiscountValue, "Discount from product page and from checkout are not equal");
        softAssert.assertEquals(totalPrice, expectedTotalPrice, "WRONG TOTAL PRICE" );

        softAssert.assertAll();
    }

    @Test
    public void  addToCartProductWithAmountDiscount(){

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkout = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);
        productPage.closePromoPopUp();
        productPage.setRandomSizeAndGetSelected();
        productPage.setRandomColor();

        double productPrice = productPage.getOldPrice();
        double expectedTotalPrice = productPrice + Config.shippingPrice - Config.amountPromoValue;

        productPage.addToCartAndGoToCheckout();

        double discount = checkout.orderReviewBlock.getDiscountValue();
        double totalPrice = checkout.orderReviewBlock.getGrandTotalPrice();

        softAssert.assertEquals(discount, Config.amountPromoValue, "Discount from product page and from checkout are not equal");
        softAssert.assertEquals(totalPrice, expectedTotalPrice, "WRONG TOTAL PRICE" );

        softAssert.assertAll();
    }

    @Test
    public void increaseProductsWithAmountDiscountQty() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkout = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1 + Config.amountPromoCode);
        productPage.closePromoPopUp();
        productPage.setRandomSizeAndGetSelected();
        productPage.setRandomColor();

        double productPrice = productPage.getOldPrice();

        productPage.addToCartAndGoToCheckout();

        OrderedItem orderedItem = checkout.orderReviewBlock.getAllOrderedItems().get(0);

        orderedItem.increaseQty();
        double exceptedTotalPrice = PriceHelper.getFormattedDouble(productPrice * 2 - checkout.orderReviewBlock.getDiscountValue() + Config.shippingPrice);


        softAssert.assertEquals(checkout.orderReviewBlock.getDiscountValue(),Config.amountPromoValue * 2, "Wrong discount value");
        softAssert.assertEquals(checkout.orderReviewBlock.getGrandTotalPrice(), exceptedTotalPrice, "Wrong total price");

        orderedItem.increaseQty();
        exceptedTotalPrice = PriceHelper.getFormattedDouble(productPrice * 3 - checkout.orderReviewBlock.getDiscountValue() + Config.shippingPrice);

        softAssert.assertEquals(checkout.orderReviewBlock.getDiscountValue(),Config.amountPromoValue * 3, "Wrong discount value");
        softAssert.assertEquals(checkout.orderReviewBlock.getGrandTotalPrice(), exceptedTotalPrice, "Wrong total price");

        softAssert.assertAll();
    }

    @Test
    public void increaseProductsWithPercentDiscountQty() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkout = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1 + Config.percentPromoCode);
        productPage.closePromoPopUp();
        productPage.setRandomSizeAndGetSelected();
        productPage.setRandomColor();

        double productPrice = productPage.getOldPrice();

        productPage.addToCartAndGoToCheckout();

        OrderedItem orderedItem = checkout.orderReviewBlock.getAllOrderedItems().get(0);

        orderedItem.increaseQty();

        double exceptedTotalPrice = PriceHelper.getFormattedDouble(productPrice * 2 - checkout.orderReviewBlock.getDiscountValue() + Config.shippingPrice);
        double exceptedDiscountValue = PriceHelper.getFormattedDouble((productPrice / 100 * Config.percentPromoValue) * 2);

        softAssert.assertEquals(checkout.orderReviewBlock.getDiscountValue(),exceptedDiscountValue, "Wrong discount value");
        softAssert.assertEquals(checkout.orderReviewBlock.getGrandTotalPrice(), exceptedTotalPrice);

        orderedItem.increaseQty();

        exceptedTotalPrice = PriceHelper.getFormattedDouble(productPrice * 3 - checkout.orderReviewBlock.getDiscountValue() + Config.shippingPrice);
        exceptedDiscountValue = PriceHelper.getFormattedDouble((productPrice / 100 * Config.percentPromoValue) * 3);

        softAssert.assertEquals(checkout.orderReviewBlock.getDiscountValue(),exceptedDiscountValue, "Wrong discount value");
        softAssert.assertEquals(checkout.orderReviewBlock.getGrandTotalPrice(), exceptedTotalPrice);



        softAssert.assertAll();
    }



}
