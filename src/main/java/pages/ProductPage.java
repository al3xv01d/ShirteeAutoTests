package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools.Wait;

import java.util.List;



public class ProductPage extends AbstractShirteePage {

    @FindBy(id = "addition_size")
    private WebElement sizeSelect;

    @FindAll({@FindBy(xpath="//*[@id=\"color-swatches\"]//span")})
    private List<WebElement> allColors;

    @FindBy(xpath = "//span[@class='regular-price']/span") // there is 6 elements, but actual price is olways first
    public WebElement price;

    @FindBy(xpath = "//form//div[@class=\"add-to-cart-buttons\"]")
    public WebElement addToCartBtn;

    @FindBy(id = "go_to_checkout")
    private WebElement gotoCheckoutBtn;

    @FindBy(id = "size-validation-error")
    public WebElement sizeValidationMessage;


    public void addToCart() {
        this.setRandomSize();
        this.setRandomColor();

        addToCartBtn.click();

        Wait.visible(gotoCheckoutBtn);
        gotoCheckoutBtn.click();
    }

    public String getPrice() {
        return price.getText();
    }

    public void setRandomSize() {
        sizeSelect.isDisplayed();
        Select size = new Select(sizeSelect);
        List<WebElement> sizeOptions = size.getOptions();

        int sizeIndex = 0 + (int)(Math.random() * ((sizeOptions.size() - 1) + 1));
        if(sizeIndex == 0) {sizeIndex++;}
        size.selectByIndex(sizeIndex);
    }

    public void setRandomColor() {
        allColors.get(0 + (int)(Math.random() * ((allColors.size() - 1) + 1))).click();
    }
}
