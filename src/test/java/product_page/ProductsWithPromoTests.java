package product_page;


import abstraction.AbstractTest;
import org.testng.annotations.Test;
import pages.ProductPage;
import tools.Config;
import tools.PageBuilder;

public class ProductsWithPromoTests extends AbstractTest {

    private String productWithAmountPromoCode = Config.testProductUrl_1 + "?gs=11amount";


    @Test
    public void amountPromoPopupAppearsEveryTime() {

        ProductPage productPage = PageBuilder.buildProductPage();
        productPage.open();
    }

    @Test
    public void percentPromoPopupAppearsEveryTime() {

    }

    @Test
    public void amountPromoValueInPopup() {

    }

    @Test
    public void percentPromoValueInPopup() {

    }

}
