package pages;

import abstraction.AbstractShirteePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools.PriceHelper;


import java.util.List;

/**
 * Created by User on 21.06.2017.
 */
public class ShopPage extends AbstractShirteePage {

    public final int[] itemsOnPageSettings = {24, 32, 48};

    //*******************  LOCATORS ********************//

    private final String leftSidebarSearchField_lo = "//div[@class=\"col-left sidebar col-left-first\"]//input";

    private final String item_lo = "//li[@class=\"item last\"]";

    private final String itemTitle_lo = ".//h2[@class=\"product-name\"]";
    private final String itemPrice_lo = "//div[@class=\"price-box\"]//span[@class=\"price\"]";
    private final String itemsQtyOnPageSelect_lo = "//div[@class=\"toolbar-bottom\"]//div[@class=\"pager\"]//select";

    private String pagination_lo = "//div[@class=\"toolbar-bottom\"]//div[@class=\"pages\"]/ol/li[%d]";


    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindAll({@FindBy(xpath = item_lo)})
    private List<WebElement> allItems;

    @FindBy(xpath = itemsQtyOnPageSelect_lo)
    private WebElement itemsQtyOnPageSelect;

    @FindBy(xpath = leftSidebarSearchField_lo)
    private WebElement leftSidebarSearchField;

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
    public String getItemTitle(int itemNumber) {
      return allItems.get(itemNumber).findElement(By.xpath(itemTitle_lo)).getText();
    }

    /**
     * @param itemNumber
     */
    public double getItemRealPrice(int itemNumber) {
        return PriceHelper.getRealPrice(allItems.get(itemNumber).findElement(By.xpath(itemPrice_lo)).getText());
    }

    //*******************  ACTIONS ********************//

    public void leftSidebarSearch(String query) {
        fillInputField(leftSidebarSearchField, query);
        leftSidebarSearchField.submit();
    }

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

    public void gotoPage(int page) {
        driver.findElement(By.xpath(String.format(pagination_lo, page))).click();
    }

}
