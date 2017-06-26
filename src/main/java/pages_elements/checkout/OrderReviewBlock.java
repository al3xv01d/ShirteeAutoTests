package pages_elements.checkout;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;

import java.util.ArrayList;
import java.util.List;

public class OrderReviewBlock extends AbstractPageElement {

    //******************* PAGE ELEMENTS ********************//

    private List<OrderedItem> allOrderedItems = new ArrayList<OrderedItem>();

    //******************* LOCATORS ********************//

    private final String orderedItem_lo = "//div[@class=\"checkout-product\"]";

    private final String grandTotalPrice_lo = "//tr[@class=\"last\"]//span[@class=\"price\"]";
    private final String couponField_lo =  "coupon_code";
    private final String applyCouponButton_lo =  "//div[@class=\"discount-btn-wrap\"]/button";
    private final String shippingPrice_lo =  "//*[@id=\"checkout-review-table\"]/tfoot/tr[2]/td[2]/span";

    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(xpath = grandTotalPrice_lo)
    private WebElement grandTotalPrice;

    @FindBy(id = couponField_lo)
    private WebElement couponField;

    @FindBy(xpath = applyCouponButton_lo)
    private WebElement applyCouponButton;

    @FindBy(xpath = shippingPrice_lo)
    private WebElement shippingPrice;

    //******************* ACTIONS ********************//

    public List<OrderedItem> getAllOrderedItems() {

        int itemsInCart = driver.findElements(By.xpath(this.orderedItem_lo)).size();

        if(null == allOrderedItems || itemsInCart != allOrderedItems.size() ) {

            for(int i=0; i < itemsInCart ;i++) {
                this.allOrderedItems.add(new OrderedItem(i+1));
            }
        }
        return allOrderedItems;
    }

    public String getShippingPrice() {
        return this.shippingPrice.getText();
    }

    public String getGrandTotalPrice() {
        return this.grandTotalPrice.getText();
    }

    public void applyCouponCode(String coupon) {
        this.couponField.clear();
        this.couponField.sendKeys(coupon);
        this.applyCouponButton.click();
    }

}
