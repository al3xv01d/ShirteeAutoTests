package pages_elements.designer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_elements.AbstractPageElement;

public class Product extends AbstractPageElement {

    private WebElement productPriceBlock;
    private WebElement productColorBlock;

    //*******************  LOCATORS ********************//

    private final String product_lo = "//table[@class=\"pd-items\"]/tbody/tr[\"%d\"]";

    //*******************  WEBDRIVER ELEMENT ********************//

    public Product(int productNumber) {
        productPriceBlock = driver.findElement(By.xpath(String.format(product_lo, productNumber)));
        productColorBlock = driver.findElement(By.xpath(String.format(product_lo, productNumber+1)));
    }
}
