package pages_elements.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import abstraction.AbstractPageElement;
import tools.PriceHelper;


public class OrderedItem extends AbstractPageElement {

    //******************* LOCATORS ********************//

    private String item_lo = "//table[@id=\"checkout-review-table\"]/tbody/tr[%d]//div[@class=\"checkout-product\"]";

    private final String deleteButton_lo = ".//div[@class=\"light-chechout-remove-td\"]";
    private final String price_lo = ".//span[@class=\"price\"]";
    private final String qty_lo = ".//span[@class=\"gcheckout-qty\"]";
    private final String color_lo =  ".//dl[@class=\"item-options\"]/dd[2]";
    private final String size_lo =  ".//dl[@class=\"item-options\"]/dd[1]";


    private final String decreaseQtyButton_lo = ".//strong[@class=\"glc-qtybtn glc-minus\"]";
    private final String increaseQtyButton_lo = ".//strong[@class=\"glc-qtybtn glc-plus\"]";

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
        this.item = driver.findElement(By.xpath( String.format(item_lo, this.itemNumber)) );
    }

    //******************* ACTIONS - Get ordered item's price, quantity, total price, etc ********************//

    public String getProductName() {
        this.init();
        return this.item.findElement(By.xpath(this.productName_lo)).getText();
    }

    public String getProductSize() {
        this.init();
        return this.item.findElement(By.xpath(this.productSize_lo)).getText();
    }

    /**
     * @return Ordered Item's price.
     * all price has the same css style so here I look for all price elements (there are only 2 price elements) and get first
     */

    public double getPrice() {
        this.init();
        return PriceHelper.getRealPrice(this.item.findElements(By.xpath(this.price_lo)).get(0).getText());
    }

    public double getTotalPrice() {
        this.init();
        return PriceHelper.getRealPrice(this.item.findElements(By.xpath(this.price_lo)).get(1).getText());
    }

    public int getQty() {
        this.init();
       return Integer.parseInt( this.item.findElement(By.xpath(this.qty_lo)).getText() );
    }

    public String getColor() {
        this.init();
        return this.item.findElement(By.xpath(this.color_lo)).getText();
    }

    public String getSize() {
        this.init();
        return this.item.findElement(By.xpath(this.size_lo)).getText();
    }

    //******************* ACTIONS ********************//

    public void deleteItemFromCart() {
        init();
        WebElement deleteBtn = this.item.findElement(By.xpath(deleteButton_lo));
        deleteBtn.click();
        waitLoadingPopUp();
    }

    public void increaseQty() {
        init();
        WebElement increaseButton = this.item.findElement(By.xpath(this.increaseQtyButton_lo));
        increaseButton.click();
        waitLoadingPopUp();
    }

    public void decreaseQty() {
        this.init();
        this.item.findElement(By.xpath(this.decreaseQtyButton_lo)).click();
        waitLoadingPopUp();
    }
}
