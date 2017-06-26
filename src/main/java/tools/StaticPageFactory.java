package tools;

import pages.IndexPage;
import pages.ProductPage;
import pages.ShopPage;
import pages.CheckoutPage;

/**
 * Created by User on 20.06.2017.
 */
public class StaticPageFactory {

    public static IndexPage createIndexPage() {
        return new IndexPage();
    }
    public static ShopPage createShopPage() {
        return new ShopPage();
    }
    public static ProductPage createProductPage() {
        return new ProductPage();
    }

}
