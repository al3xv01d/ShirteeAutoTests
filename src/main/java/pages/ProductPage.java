package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools.Wait;

import java.util.List;



public class ProductPage extends AbstractShirteePage {

    //*******************  LOCATORS ********************//

    private final String sizeSelect_lo = "addition_size";
    private final String color_lo = "//*[@id=\"color-swatches\"]//span";
    private final String price_lo = "//span[@class='regular-price']/span";
    private final String addToCartBtn_lo = "//form//div[@class=\"add-to-cart-buttons\"]";
    private final String gotoCheckoutBtn_lo = "go_to_checkout";
    private final String sizeValidationMessage_lo = "size-validation-error";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = sizeSelect_lo)
    private WebElement sizeSelect;

    @FindAll({@FindBy(xpath= color_lo)})
    private List<WebElement> allColors;

    @FindBy(xpath = price_lo) // there is 6 elements, but actual price is always first
    public WebElement price;

    @FindBy(xpath = addToCartBtn_lo)
    public WebElement addToCartBtn;

    @FindBy(id = gotoCheckoutBtn_lo)
    private WebElement gotoCheckoutBtn;

    @FindBy(id = sizeValidationMessage_lo)
    public WebElement sizeValidationMessage;

    //*******************  ACTIONS ********************//

    public String getPrice() {
        return price.getText();
    }

    public void addToCart() {
        this.setRandomSize();
        this.setRandomColor();

        addToCartBtn.click();

        Wait.visible(gotoCheckoutBtn);
        gotoCheckoutBtn.click();
    }

    public void setRandomSize() {
        sizeSelect.isDisplayed();
        Select sizeSelector = new Select(sizeSelect);
        List<WebElement> sizeOptions = sizeSelector.getOptions();

        int sizeIndex = 0 + (int)(Math.random() * ((sizeOptions.size() - 1) + 1));
        if(sizeIndex == 0) {sizeIndex++;}
        sizeSelector.selectByIndex(sizeIndex);
    }

    public void setRandomColor() {
        allColors.get(0 + (int)(Math.random() * ((allColors.size() - 1) + 1))).click();
    }
}
