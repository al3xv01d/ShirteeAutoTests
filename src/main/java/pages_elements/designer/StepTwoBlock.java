package pages_elements.designer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;
import tools.Wait;

public class StepTwoBlock extends AbstractPageElement{

    public ProductsBlock products = new ProductsBlock();

    //*******************  LOCATORS ********************//

    private final String itemsQty_lo = "keypress_input";

    //*******************  ELEMENTS ********************//

    @FindBy(id = itemsQty_lo)
    private WebElement itemsQty;


    //*******************  ACTIONS ********************//

    public void setItemsQty(String qty) {
        fillInputField(itemsQty, qty);
    }

}
