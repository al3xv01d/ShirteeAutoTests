package pages_elements.checkout;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstraction.AbstractPageElement;
import tools.PriceHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderReviewBlock extends AbstractPageElement {

    //******************* PAGE ELEMENTS ********************//

    private List<OrderedItem> allOrderedItems = new ArrayList<OrderedItem>();

    //******************* LOCATORS ********************//

    private final String orderedItem_lo = "//div[@class=\"checkout-product\"]";

    private final String grandTotalPrice_lo = "//tr[@class=\"last\"]//span[@class=\"price\"]";
    private final String couponField_lo =  "coupon_code";
    private final String applyCouponButton_lo =  "//div[@class=\"discount-btn-wrap\"]/button";

    private final String shippingPrice_lo =  "//*[@id=\"checkout-review-table\"]/tfoot/tr[2]//span";
    private final String discountValue_lo = "//span[@class=\"discount-value\"]/span";


    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(xpath = grandTotalPrice_lo)
    private WebElement grandTotalPrice;

    @FindBy(id = couponField_lo)
    private WebElement couponField;

    @FindBy(xpath = applyCouponButton_lo)
    private WebElement applyCouponButton;

    @FindBy(xpath = shippingPrice_lo)
    private WebElement shippingPrice;

    @FindBy(xpath = discountValue_lo)
    private WebElement discountValue;

    //******************* ACTIONS ********************//

    public List<OrderedItem> getAllOrderedItems() {

        int itemsInCart = driver.findElements(By.xpath(this.orderedItem_lo)).size();

        if(itemsInCart != allOrderedItems.size() ) {
            for(int i=1; i <= itemsInCart ;i++) {
                this.allOrderedItems.add(new OrderedItem(i));
            }
        }
        return allOrderedItems;
    }

    public void deleteAllItems() {
        Iterator<OrderedItem> iterator = this.getAllOrderedItems().iterator();

        while(iterator.hasNext()) {
            OrderedItem currentItem = iterator.next();
            currentItem.deleteItemFromCart();
        }
    }

    public double getShippingPrice() {
        return PriceHelper.getRealPrice(this.shippingPrice.getText());
    }

    public double getGrandTotalPrice() {
        return PriceHelper.getRealPrice( this.grandTotalPrice.getText() );
    }

    public double getTotalItemsQty() {

        Iterator<OrderedItem> iterator = this.getAllOrderedItems().iterator();

        double totalQty = 0;

        while(iterator.hasNext()) {
            OrderedItem currentItem = iterator.next();
            totalQty = totalQty + currentItem.getQty();
        }

        return totalQty;
    }

    public double getDiscountValue() {
        return PriceHelper.getRealPrice(discountValue.getText());
    }

    public void applyCouponCode(String coupon) {
        this.couponField.clear();
        this.couponField.sendKeys(coupon);
        this.applyCouponButton.click();
    }

}
