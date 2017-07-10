package pages_elements.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import abstraction.AbstractPageElement;
import tools.PriceHelper;


public class OrderedItem extends AbstractPageElement {

    //******************* LOCATORS ********************//

    private final String deleteButton_lo = ".//div[@class=\"light-chechout-remove-td\"]";
    private final String price_lo = ".//span[@class=\"price\"]";
    private final String qty_lo = ".//span[@class=\"gcheckout-qty\"]";
    private final String color_lo =  ".//dl[@class=\"item-options\"]/dd[2]";
    private final String size_lo =  ".//dl[@class=\"item-options\"]/dd[1]";


    private final String increaseQtyButton_lo = "//strong[@class=\"glc-qtybtn glc-minus\"]";
    private final String decreaseQtyButton_lo = "//strong[@class=\"glc-qtybtn glc-plus\"]";

    private final String productName_lo = ".//h3[@class=\"product-name\"]/a";
    private final String productSize_lo = ".//dl[@class=\"item-options\"]/dd[1]";

    //******************* INITIALIZATION. CONSTRUCTOR ********************//

    private int itemNumber;
    private WebElement item;

    public OrderedItem(int itemNumber) {
        this.itemNumber = itemNumber;
        this.init();
    }

    private void init() {
        this.item = driver.findElement(By.xpath("//table[@id=\"checkout-review-table\"]/tbody/tr[" + this.itemNumber + "]//div[@class=\"checkout-product\"]"));
    }

    //******************* ACTIONS - Get ordered item's price, quantity, total price, etc ********************//

    public String getProductName() {
        return this.item.findElement(By.xpath(this.productName_lo)).getText();
    }

    public String getProductSize() {
        return this.item.findElement(By.xpath(this.productSize_lo)).getText();
    }

    /**
     * @return Ordered Item's price.
     * all price has the same css style so here I look for all price elements (there are only 2 price elements) and get first
     */

    public double getPrice() {
        return PriceHelper.getRealPrice(this.item.findElements(By.xpath(this.price_lo)).get(0).getText());
    }

    public double getTotalPrice() {
        return PriceHelper.getRealPrice(this.item.findElements(By.xpath(this.price_lo)).get(1).getText());
    }

    public int getQty() {
       return Integer.parseInt( this.item.findElement(By.xpath(this.qty_lo)).getText() );
    }

    public String getColor() {
        return this.item.findElement(By.xpath(this.color_lo)).getText();
    }

    public String getSize() {
        return this.item.findElement(By.xpath(this.size_lo)).getText();
    }

    //******************* ACTIONS ********************//

    public void deleteItemFromCart() {
        this.item.findElement(By.xpath(deleteButton_lo)).click();
    }

    public void increaseQty() {
        this.item.findElement(By.xpath(this.increaseQtyButton_lo)).click();
    }

    public void decreaseQty() {
        this.item.findElement(By.xpath(this.decreaseQtyButton_lo)).click();
    }
}
