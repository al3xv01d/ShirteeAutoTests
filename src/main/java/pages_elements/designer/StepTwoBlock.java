package pages_elements.designer;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import abstraction.AbstractPageElement;
import pages_elements.checkout.OrderedItem;
import tools.Wait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StepTwoBlock extends AbstractPageElement{


    //*******************  LOCATORS ********************//

    private final String itemsQty_lo = "keypress_input";

    private final String productsSelector_lo = "//div[@class=\"product-dropdown-placeholder\"]";
    private final String productFromProductsSelector_lo = "//div[@class=\"product-dropdown-placeholder\"]//li";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = itemsQty_lo)
    private WebElement itemsQty;

    @FindBy(xpath = productsSelector_lo)
    private WebElement productsSelector;

    @FindAll({@FindBy(xpath = productFromProductsSelector_lo)})
    private List<WebElement> allProductsFromSelector;

    private List<StepTwoAddedProduct> allAddedProducts = new ArrayList<StepTwoAddedProduct>();


    //*******************  ACTIONS ********************//

    public void setItemsQty(String qty) {
        fillInputField(itemsQty, qty);
    }

    public void addAllProducts() {
        Wait.visibility(productsSelector);

        Iterator<WebElement> iterator = allProductsFromSelector.iterator();

        while(iterator.hasNext()) {
            WebElement currentProductFromSelector = iterator.next();

            productsSelector.click();

            currentProductFromSelector.click();
        }
    }

    public List<StepTwoAddedProduct> getAllAddedProducts() {

        allAddedProducts.clear();

        for (int i = 1; i <= 26; i++ ) {

            if(i % 2 == 0) {
                ++i;
            }

            allAddedProducts.add(new StepTwoAddedProduct(i));
        }

        return allAddedProducts;

    }


}
