package checkout;

import abstraction.AbstractTest;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import pages_elements.checkout.OrderedItem;
import tools.Config;
import tools.PageBuilder;
import tools.PriceHelper;

import java.util.List;


public class OrderedItemsTests extends AbstractTest{

    @Test
    public void addTwoProductsAndDeleteOne() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);
        productPage.setSize("XL");
        productPage.addToCartAndStay();
        productPage.setSize("XXL");
        productPage.addToCartAndGoToCheckout();

        softAssert.assertEquals(checkoutPage.orderReviewBlock.getAllOrderedItems().size(), 2);

        checkoutPage.orderReviewBlock.getAllOrderedItems().get(0).deleteItemFromCart();

        softAssert.assertEquals(checkoutPage.orderReviewBlock.getAllOrderedItems().size(), 1);
        softAssert.assertAll();
    }

    @Test
    public void increaseItemQty() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);
        productPage.setRandomSizeAndGetSelected();
        double price = productPage.getPrice();
        productPage.addToCartAndGoToCheckout();

        OrderedItem orderedItem = checkoutPage.orderReviewBlock.getAllOrderedItems().get(0);

        orderedItem.increaseQty();
        softAssert.assertEquals(orderedItem.getQty(), 2, "WRONG QTY");
        orderedItem.increaseQty();
        softAssert.assertEquals(orderedItem.getQty(), 3, "WRONG QTY");
        orderedItem.increaseQty();
        softAssert.assertEquals(orderedItem.getQty(), 4, "WRONG QTY");
        System.out.println(price*4);
        softAssert.assertEquals(PriceHelper.getFormattedDouble(price*4), orderedItem.getTotalPrice(), "Wrong price if there if item's qty == 4");

        softAssert.assertAll();
    }

    @Test
    public void decreaseItemQty() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.openUrl(Config.testProductUrl_1);
        productPage.setRandomSizeAndGetSelected();
        double price = productPage.getPrice();
        productPage.addToCartAndGoToCheckout();

        OrderedItem orderedItem = checkoutPage.orderReviewBlock.getAllOrderedItems().get(0);

        orderedItem.increaseQty();
        orderedItem.increaseQty();
        orderedItem.increaseQty();

        orderedItem.decreaseQty();
        softAssert.assertEquals(orderedItem.getQty(), 3, "WRONG QTY");
        orderedItem.decreaseQty();
        softAssert.assertEquals(orderedItem.getQty(), 2, "WRONG QTY");
        orderedItem.decreaseQty();
        softAssert.assertEquals(orderedItem.getQty(), 1, "WRONG QTY");

        softAssert.assertAll();
    }

}
