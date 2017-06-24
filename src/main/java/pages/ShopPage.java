package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

/**
 * Created by User on 21.06.2017.
 */
public class ShopPage extends AbstractShirteePage {

    @FindAll({@FindBy(xpath="//li[@class=\"item last\"]")})
    private List<WebElement> Items;

    private Select itemsQtyOnPageSelect;

    public int getItemsOnPageQty() {
        return Items.size();
    }

    public void openProduct(int itemNumber) {
        if(!Items.isEmpty()) {
            Items.get(itemNumber).click();
        }
    }

    public void getItemTitle(int itemNumber) {
       Items.get(itemNumber).findElement(By.xpath(".//h2[@class=\"product-name\"]"));
    }

    public void getItemPrice(int itemNumber) {
        Items.get(itemNumber).findElement(By.xpath("//div[@class=\"price-box\"]//span[@class=\"price\"]"));
    }

    /**
     *
     * @param QtyOnPage - only 24 or 32 or 48
     */
    public void setItemsQtyOnPage(int QtyOnPage) {

        itemsQtyOnPageSelect = new Select(driver.findElement(By.xpath("//div[@class=\"toolbar-bottom\"]//div[@class=\"pager\"]//select")));

        switch(QtyOnPage) {
            case 24:
                itemsQtyOnPageSelect.selectByIndex(0);
                break;
            case 32:
                itemsQtyOnPageSelect.selectByIndex(1);
                break;
            case 48:
                itemsQtyOnPageSelect.selectByIndex(2);
                break;
        }

    }


}
