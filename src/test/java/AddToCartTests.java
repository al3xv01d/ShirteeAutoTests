import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import pages_elements.checkout.OrderedItem;
import tools.Config;
import tools.PageBuilder;
import tools.StaticPageFactory;

// Test 1 - add one product to cart and assert that in cart is only one product
// test 2 - add one product in cart and assert that product's color, price and size are the same on checkout page

public class AddToCartTests extends AbstractTest {

    @Test
    public void addToCart() {

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        String orderedItemQty = checkoutPage.orderReviewBlock.getAllOrderedItems().get(0).getQty();

        softAssert.assertEquals("1", orderedItemQty);

        softAssert.assertAll();
    }

    @Test
    public void checkPriceSizeAndColor() {

        ProductPage productPage = PageBuilder.buildProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProductUrl_1);

        String productPrice = productPage.getPrice(); // Saved product price from Product page
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

}
