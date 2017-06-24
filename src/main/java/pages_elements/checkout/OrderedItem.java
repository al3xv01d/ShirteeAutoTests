package pages_elements.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_elements.AbstractPageElement;



public class OrderedItem extends AbstractPageElement{

    private final String deleteButton_lo = ".//div[@class=\"light-chechout-remove-td\"]";
    private final String price_lo = ".//span[@class=\"price\"]";
    private final String qty_lo = ".//span[@class=\"gcheckout-qty\"]";

    private final String increaseQtyButton_lo = "//strong[@class=\"glc-qtybtn glc-minus\"]";
    private final String decreaseQtyButton_lo = "//strong[@class=\"glc-qtybtn glc-plus\"]";

    private final String productName_lo = ".//h3[@class=\"product-name\"]/a";
    private final String productSize_lo = ".//dl[@class=\"item-options\"]/dd[1]";

    private WebElement item;

    private int itemNumber;

    public OrderedItem(int itemNumber) {
        this.itemNumber = itemNumber;
        this.init();
    }

    private void init() {
        this.item = driver.findElement(By.xpath("//table[@id=\"checkout-review-table\"]/tbody/tr[" + this.itemNumber + "]//div[@class=\"checkout-product\"]"));
    }

    //GETTERS
    public String getProductName() {
        return this.item.findElement(By.xpath(this.productName_lo)).getText();
    }

    public String getPrice() {
        return this.item.findElements(By.xpath(this.price_lo)).get(0).getText();
    }

    public String getTotalPrice() {
        return this.item.findElements(By.xpath(this.price_lo)).get(1).getText();
    }

    public String getQty() {
       return this.item.findElement(By.xpath(this.qty_lo)).getText();
    }

    //ACTIONS

    public void deleteItemFromCart() {
        this.item.findElement(By.xpath(this.deleteButton_lo)).click();
    }

    public void increaseQty() {
        this.item.findElement(By.xpath(this.increaseQtyButton_lo)).click();
    }

    public void decreaseQty() {
        this.item.findElement(By.xpath(this.decreaseQtyButton_lo)).click();
    }
}
