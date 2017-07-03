package pages_elements.designer;


import abstraction.AbstractPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.Wait;

import java.util.Iterator;
import java.util.List;

public class StepTwoAddedProduct extends AbstractPageElement {

    private WebElement productPriceBlock;
    public WebElement productColorBlock;

    //*******************  LOCATORS ********************//

    private final String colorsSelector_lo = ".//div[@class=\"pd-items-color\"]//a";
    private final String color_lo = ".//div[@class=\"pd-items-color\"]//span[contains(@class, \"color-btn\")]";


    private String product_lo = "//table[@class=\"pd-items\"]/tbody/tr[%d]";
    private final String salesPrice_lo = ".//*[@id=\"sales_price\"]";
    private final String profit_lo = ".//*[@id=\"profit\"]/span[1]";


    //*******************  CONSTRUCTOR ********************//

    public StepTwoAddedProduct(int productNumber) {
        System.out.println((String.format(product_lo, productNumber)));
        productPriceBlock = driver.findElement(By.xpath(String.format(product_lo, productNumber)));

        // productNumber + 1 because one product is located in two <tr> tags without any unique id or style
        System.out.println((String.format(product_lo, productNumber+1)));
        productColorBlock = driver.findElement(By.xpath(String.format(product_lo, (productNumber + 1) )));
    }

    //*******************  ACTIONS ********************//

    public void setSalesPrice(String price) {
        fillInputField(productPriceBlock.findElement(By.xpath(salesPrice_lo)), price);
    }

    public String getProfit() {
        return productPriceBlock.findElement(By.xpath(profit_lo)).getText();
    }

    public void openColorsSelector() {
        scrollToElement(productColorBlock.findElement(By.xpath(colorsSelector_lo)));
        productColorBlock.findElement(By.xpath(colorsSelector_lo)).click();
        //Wait.visibility(productColorBlock.findElement(By.xpath(".//div[@class=\"colors-container\"] ")));
    }

    public void selectAllColors() {
        System.out.println("StartColor selection");

        openColorsSelector();
        List<WebElement> allColors = productColorBlock.findElements(By.xpath(color_lo));
        System.out.println(allColors.size());
        Iterator<WebElement> iterator = allColors.iterator();

        while(iterator.hasNext()) {
            WebElement currentColor = iterator.next();

            if(currentColor.isDisplayed()) {
                Wait.clickable(currentColor);
                currentColor.click();
            }
        }

    }

}