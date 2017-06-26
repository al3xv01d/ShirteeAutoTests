package pages_elements.designer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;

public class DesignerStepTwoProduct extends AbstractPageElement {

    private WebElement productPriceBlock;
    private WebElement productColorBlock;

    //*******************  LOCATORS ********************//

    private final String product_lo = "//table[@class=\"pd-items\"]/tbody/tr[\"%d\"]";

    private final String salesPrice_lo = ".//*[@id=\"sales_price\"]";

    private final String profit_lo = ".//*[@id=\"profit\"]/span[1]";

    //*******************  WEBDRIVER ELEMENTS ********************//


    //*******************  CONSTRUCTOR ********************//

    public DesignerStepTwoProduct(int productNumber) {

        productPriceBlock = driver.findElement(By.xpath(String.format(product_lo, productNumber)));

        // productNumber + 1 because one product is located in two <tr> tags without any unique id or style
        productColorBlock = driver.findElement(By.xpath(String.format(product_lo, productNumber + 1)));
    }

    //*******************  ACTIONS ********************//

    public void setSalesPrice(String price) {
        fillInputField(productPriceBlock.findElement(By.xpath(salesPrice_lo)), price);
    }

    public String getProfit() {
        return productPriceBlock.findElement(By.xpath(profit_lo)).getText();
    }

}
