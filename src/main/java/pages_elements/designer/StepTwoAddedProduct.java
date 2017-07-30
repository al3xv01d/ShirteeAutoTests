package pages_elements.designer;


import abstraction.AbstractPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import tools.PriceHelper;
import tools.Wait;

import java.util.Iterator;
import java.util.List;

public class StepTwoAddedProduct extends AbstractPageElement {

    private WebElement productPriceBlock;
    public WebElement productColorBlock;

    //*******************  LOCATORS ********************//
    private String product_lo = "//table[@class=\"pd-items\"]/tbody/tr[%d]";

    private final String colorsSelector_lo = ".//div[@class=\"pd-items-color\"]//a";
    private final String color_lo = ".//div[@class=\"pd-items-color\"]//span[contains(@class, \"color-btn\")]";

    private String productName_lo = ".//*[@class=\"pd-items-pname\"]";
    private final String salesPrice_lo = ".//*[@class=\"pd-items-price-filed\"]/input";
    private final String profit_lo = ".//*[@class=\"pd-items-price\"]/span[1]";

    //*[@id="profit"]/span[1]


    //*******************  CONSTRUCTOR ********************//

    public StepTwoAddedProduct(int productNumber) {

        try {
            productPriceBlock = driver.findElement(By.xpath(String.format(product_lo, productNumber)));
            productColorBlock = driver.findElement(By.xpath(String.format(product_lo, (productNumber + 1) )));
        } catch (Exception e) {

        }


        // productNumber + 1 because one product is located in two <tr> tags without any unique id or style
       // System.out.println((String.format(product_lo, productNumber+1)));

    }

    //*******************  ACTIONS ********************//
    public double getSalesPrice() {
        return Double.parseDouble(productPriceBlock.findElement(By.xpath(salesPrice_lo)).getAttribute("value") );
    }

    public void setSalesPrice(String price) {
        fillInputField(productColorBlock.findElement(By.xpath(salesPrice_lo)), price);
    }

    public String getProductName() {
        return productColorBlock.findElement(By.xpath(productName_lo)).getText();
    }

    public double getProfit() {
        return PriceHelper.getRealPrice( productPriceBlock.findElement(By.xpath(profit_lo)).getText() );
    }

    public void openColorsSelector() {

        productColorBlock.findElement(By.xpath(colorsSelector_lo)).click();

        //Wait.visibility(productColorBlock.findElement(By.xpath(".//div[@class=\"colors-container\"] ")));
    }

    public void selectAllColors() {

        openColorsSelector();
        List<WebElement> allColors = productColorBlock.findElements(By.xpath(color_lo));

        Iterator<WebElement> iterator = allColors.iterator();

        while(iterator.hasNext()) {
            WebElement currentColor = iterator.next();

            if(currentColor.isDisplayed()) {
                Wait.clickable(currentColor);

                try {
                    currentColor.click();
                } catch (WebDriverException e) { }


            }
        }
        openColorsSelector();
    }

}