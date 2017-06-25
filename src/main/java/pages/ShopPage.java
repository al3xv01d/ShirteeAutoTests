package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

/**
 * Created by User on 21.06.2017.
 */
public class ShopPage extends AbstractShirteePage {

    //*******************  LOCATORS ********************//

    private final String item_lo = "//li[@class=\"item last\"]";

    private final String itemTitle_lo = ".//h2[@class=\"product-name\"]";
    private final String itemPrice_lo = "//div[@class=\"price-box\"]//span[@class=\"price\"]";
    private final String itemsQtyOnPageSelect_lo = "//div[@class=\"toolbar-bottom\"]//div[@class=\"pager\"]//select";


    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindAll({@FindBy(xpath = item_lo)})
    private List<WebElement> allItems;

    @FindBy(xpath = itemsQtyOnPageSelect_lo)
    private WebElement itemsQtyOnPageSelect;

    //*******************  ACTIONS - SOME GETTERS ********************//

    public int getItemsOnPageQty() {
        return allItems.size();
    }

    public void openProduct(int itemNumber) {
        if(!allItems.isEmpty()) {
            allItems.get(itemNumber).click();
        }
    }

    /**
     * @param itemNumber
     */
    public void getItemTitle(int itemNumber) {
       allItems.get(itemNumber).findElement(By.xpath(itemTitle_lo));
    }

    /**
     * @param itemNumber
     */
    public void getItemPrice(int itemNumber) {
        allItems.get(itemNumber).findElement(By.xpath(itemPrice_lo));
    }

    //*******************  ACTIONS ********************//

    /**
     * @param QtyOnPage - only 24 or 32 or 48
     */
    public void setItemsQtyOnPage(int QtyOnPage) {

        Select itemsQtySelector = new Select(itemsQtyOnPageSelect);

        switch(QtyOnPage) {
            case 24:
                itemsQtySelector.selectByIndex(0);
                break;
            case 32:
                itemsQtySelector.selectByIndex(1);
                break;
            case 48:
                itemsQtySelector.selectByIndex(2);
                break;
        }

    }


}
