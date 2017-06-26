package pages_elements.designer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;

public class StepTwoBlock extends AbstractPageElement{

    //*******************  BLOCK ELEMENTS ********************//

    public DesignerStepTwoProductsBlock allProducts;

    //*******************  LOCATORS ********************//

    private final String itemsQty_lo = "keypress_input";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = itemsQty_lo)
    private WebElement itemsQty;

    //*******************  CONSTRUCTOR ********************//

    public StepTwoBlock(DesignerStepTwoProductsBlock allProducts) {
        this.allProducts = allProducts;
    }

    //*******************  ACTIONS ********************//

    public void setItemsQty(String qty) {
        fillInputField(itemsQty, qty);
    }

}
