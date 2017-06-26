package pages_elements.designer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;
import tools.Wait;


public class DesignerStepTwoProductsBlock extends AbstractPageElement {

    //*******************  LOCATORS ********************//

    private final String addProductSelector_lo = "//div[@class=\"product-dropdown-placeholder\"]";


    //*******************  ELEMENTS ********************//

    @FindBy(xpath = addProductSelector_lo)
    private WebElement addProductSelector;

    //*******************  ACTIONS ********************//

    public void addAnotherProduct() {
        Wait.visibility(addProductSelector);
        addProductSelector.click();
    }

    public DesignerStepTwoProduct getProduct(int productNumber) {
        return new DesignerStepTwoProduct(productNumber);
    }
}
