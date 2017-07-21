package product_page;

import abstraction.AbstractTest;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import pages_elements.checkout.OrderedItem;
import tools.Config;
import tools.PageBuilder;

// Test 1 - add one product to cart and assert that in cart is only one product
// test 2 - add one product in cart and assert that product's color, price and size are the same on checkout page
// Test 3 - add one product twice and assert that in cart is only one product and check that total price == price * 2
// Test 4 - add one product to cart twice, with different sizes and check that in cart are 2 products
// Test 5 - add one product to cart twice, with different colors and check that in cart are 2 products

public class AddToCartTests extends AbstractTest {

    @Test
    public void addToCart() {

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        int orderedItemQty = checkoutPage.orderReviewBlock.getAllOrderedItems().get(0).getQty();

        softAssert.assertEquals(1, orderedItemQty);

        softAssert.assertAll();
    }

    @Test
    public void checkPriceSizeAndColor() {

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        double productPrice = productPage.getPrice(); // Saved product price from Product page
        String productSize = productPage.setRandomSizeAndGetSelected();

        productPage.setRandomColor();

        String selectedColor = productPage.getSelectedColor();
        String selectedSize = productPage.setRandomSizeAndGetSelected();

        productPage.addToCartAndGoToCheckout();

        OrderedItem orderedItem = checkoutPage.orderReviewBlock.getAllOrderedItems().get(0);

        softAssert.assertEquals( selectedColor, orderedItem.getColor() );
        softAssert.assertEquals( selectedSize, orderedItem.getSize() );
        softAssert.assertEquals( productPrice, orderedItem.getPrice() );

        softAssert.assertAll();
    }

    @Test
    public void addProductTwiceAndCheckQtyAndPrice() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        double price = productPage.getPrice();

        productPage.setColor(0);
        productPage.setSize("XL");

        productPage.addToCartAndStay();

        productPage.setColor(0);
        productPage.setSize("XL");

        productPage.addToCartAndGoToCheckout();

        OrderedItem orderedItem = checkoutPage.orderReviewBlock.getAllOrderedItems().get(0);

        softAssert.assertEquals(checkoutPage.orderReviewBlock.getAllOrderedItems().size(), 1);
        softAssert.assertEquals(orderedItem.getTotalPrice(), price * 2);
        softAssert.assertEquals(orderedItem.getQty(), 2);

        softAssert.assertAll();

    }

    @Test
    public void addProductTwiceWithDifferentSize() {

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        productPage.setSize("XL");

        productPage.addToCartAndStay();

        productPage.setSize("XXL");

        productPage.addToCartAndGoToCheckout();

        softAssert.assertEquals(checkoutPage.orderReviewBlock.getAllOrderedItems().size(), 2);
        softAssert.assertAll();

    }

    @Test
    public void addProductTwiceWithDifferentColor() {

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        productPage.setSize("XL");
        productPage.setColor(0);

        productPage.addToCartAndStay();

        productPage.setSize("XL");
        productPage.setColor(2);

        productPage.addToCartAndGoToCheckout();

        softAssert.assertEquals(checkoutPage.orderReviewBlock.getAllOrderedItems().size(), 2);
        softAssert.assertAll();

    }

    @Test
    public void addTwoDifferentProductsWithSameSizeAndColor() {
        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);
    }

}
