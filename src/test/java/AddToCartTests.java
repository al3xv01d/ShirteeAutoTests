import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import pages_elements.checkout.OrderedItem;
import tools.Config;
import tools.PageBuilder;
import tools.StaticPageFactory;


public class AddToCartTests extends AbstractTest {

    @Test
    public void addToCart() {

        ProductPage productPage = StaticPageFactory.createProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProduct1);

        productPage.setRandomColor();
        productPage.setRandomSizeAndGetSelected();
        productPage.addToCartAndGoToCheckout();

        String orderedItemQty = checkoutPage.orderReviewBlock.getAllOrderedItems().get(0).getQty();

        softAssert.assertEquals("1", orderedItemQty);

        softAssert.assertAll();
    }

    @Test
    public void checkPriceSizeAndColor() {

        ProductPage productPage = StaticPageFactory.createProductPage();
        CheckoutPage checkoutPage = PageBuilder.buildCheckoutPage();

        productPage.open(Config.testProduct1);

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
