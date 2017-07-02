package pages;

import abstraction.AbstractShirteePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools.PriceHelper;
import tools.RandomData;
import tools.Wait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductPage extends AbstractShirteePage {

    //*******************  LOCATORS ********************//

    private final String productName_lo = "//div[@class=\"w-block-head\"]";

    private final String sizeSelect_lo = "addition_size";
    private final String color_lo = "//*[@id=\"color-swatches\"]//span";
    private final String selectedColor_lo = "color-label";
    private final String price_lo = "//span[@class='regular-price']/span";
    private final String addToCartBtn_lo = "//form//div[@class=\"add-to-cart-buttons\"]";
    private final String gotoCheckoutBtn_lo = "go_to_checkout";
    private final String sizeValidationMsg_lo = "size-validation-error";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(xpath = productName_lo)
    private WebElement productName;

    @FindBy(id = sizeSelect_lo)
    private WebElement sizeSelect;

    @FindAll({@FindBy(xpath= color_lo)})
    private List<WebElement> allColors;

    @FindBy(id = selectedColor_lo )
    private WebElement selectedColor;

    @FindBy(xpath = price_lo) // there is 6 elements, but actual price is always first
    public WebElement price;

    @FindBy(xpath = addToCartBtn_lo)
    public WebElement addToCartBtn;

    @FindBy(id = gotoCheckoutBtn_lo)
    private WebElement gotoCheckoutBtn;

    @FindBy(id = sizeValidationMsg_lo)
    public WebElement sizeValidationMsg;

    //*******************  ACTIONS - GETTERS ********************//

    public String getProductName() {
        return productName.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public double getRealPrice() {
        return PriceHelper.getRealPrice(this.getPrice());
    }


    public String getSelectedColor() {
        return selectedColor.getText();
    }

    public boolean isSizeValidationMsgVisible () {
        return isExistsAndVisible(sizeValidationMsg);
    }

    //*******************  ACTIONS  ********************//

    public void addToCart() {
        addToCartBtn.click();
    }

    public void addToCartAndGoToCheckout() {
        addToCartBtn.click();
        Wait.visibility(gotoCheckoutBtn);
        Wait.clickable(gotoCheckoutBtn);
        gotoCheckoutBtn.click();
    }

    public String setRandomSizeAndGetSelected() {

        if(isExistsAndVisible(sizeSelect)) {

            Select sizeSelector = new Select(sizeSelect);

            int sizeOptionsNumber = sizeSelector.getOptions().size();
            int selectedSizeIndex = RandomData.getRandomInt(1, sizeOptionsNumber - 1);

            sizeSelector.selectByIndex(selectedSizeIndex);

            return sizeSelector.getOptions().get(selectedSizeIndex).getText();
        }

        return "This product doesn't have size option";
    }

    public void setSize() {

    }


    public void setRandomColor() {
        allColors.get( RandomData.getRandomInt(1, allColors.size() - 1) ).click();
    }


}
