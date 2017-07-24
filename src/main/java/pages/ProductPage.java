package pages;

import abstraction.AbstractShirteePage;
import org.openqa.selenium.WebDriverException;
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
    private final String specialPrice_lo = "//span[@class=\"special-price\"]/span";
    private final String oldPrice_lo = "//span[@class=\"old-price\"]/span";

    private final String addToCartBtn_lo = "//form//div[@class=\"add-to-cart-buttons\"]";
    private final String gotoCheckoutBtn_lo = "go_to_checkout";
    private final String continueShoppingBtn_lo ="continue_shopping";

    private final String sizeValidationMsg_lo = "size-validation-error";

    private final String discountFromPromoPopUp_lo = "//div[@class=\"event-popup-in\"]//strong";
    private final String promoPopUpCloseBtn_lo = "//div[@class=\"event-popup-in\"]//button";

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
    private WebElement price;

    @FindBy(xpath = specialPrice_lo)
    private WebElement specialPrice;

    @FindBy(xpath = oldPrice_lo)
    private WebElement oldPrice;

    @FindBy(xpath = addToCartBtn_lo)
    private WebElement addToCartBtn;

    @FindBy(id = gotoCheckoutBtn_lo)
    private WebElement gotoCheckoutBtn;

    @FindBy(id = continueShoppingBtn_lo)
    private WebElement continueShoppingBtn;

    @FindBy(id = sizeValidationMsg_lo)
    private WebElement sizeValidationMsg;

    @FindBy(xpath = discountFromPromoPopUp_lo)
    private WebElement discountFromPromoPopUp;

    @FindBy(xpath = promoPopUpCloseBtn_lo)
    private WebElement promoPopUpCloseBtn;


    //*******************  ACTIONS - GETTERS ********************//

    public String getProductName() {
        return productName.getText();
    }

    public double getPrice() {
        return PriceHelper.getRealPrice(price.getText());
    }

    public double getSpecialPrice() {
        return PriceHelper.getRealPrice(specialPrice.getText());
    }

    public double getOldPrice() {
        return PriceHelper.getRealPrice(oldPrice.getText());
    }

    public String getSelectedColor() {
        return selectedColor.getText();
    }

    public boolean isSizeValidationMsgVisible () {
        return isExistsAndVisible(sizeValidationMsg);
    }

    //*******************  ACTIONS  ********************//

    public void pressAddToCartBtn() {
        addToCartBtn.click();
    }

    public void addToCartAndGoToCheckout() {
        addToCartBtn.click();
        Wait.visibility(gotoCheckoutBtn);
        Wait.clickable(gotoCheckoutBtn);
        gotoCheckoutBtn.click();
    }

    public void addToCartAndStay() {
        addToCartBtn.click();
        Wait.visibility(continueShoppingBtn);
        Wait.clickable(continueShoppingBtn);
        continueShoppingBtn.click();
        Wait.invisibility(continueShoppingBtn_lo);
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

    public void setSize(String size) {

        if(isExistsAndVisible(sizeSelect)) {

            Select sizeSelector = new Select(sizeSelect);

            int sizeOptionsNumber = sizeSelector.getOptions().size();
            int selectedSizeIndex = RandomData.getRandomInt(1, sizeOptionsNumber - 1);

            sizeSelector.selectByVisibleText(size);

        }

    }

    public void setRandomColor() {
        try {
            allColors.get( RandomData.getRandomInt(1, allColors.size() - 1) ).click();
        } catch (WebDriverException e) {
            Wait.seconds(2);
            allColors.get( RandomData.getRandomInt(1, allColors.size() - 1) ).click();
        }

    }

    public void setColor(int colorNumber) {

        try {
            allColors.get(colorNumber).click();
        } catch (IndexOutOfBoundsException e) {
            System.out.println();
            allColors.get(0).click();
        }
    }

    public double getDiscountFromPopUp() {
        Wait.visibility(discountFromPromoPopUp);
        return PriceHelper.getRealPrice(discountFromPromoPopUp.getText());
    }

    public void closePromoPopUp() {

        try {
            Wait.visibility(promoPopUpCloseBtn);
            promoPopUpCloseBtn.click();
        } catch (WebDriverException e) {
            Wait.seconds(1);
            promoPopUpCloseBtn.click();
        }

        if(isExistsAndVisible(discountFromPromoPopUp)) {
            Wait.seconds(1);
        }

    }

    public boolean isPromoPopUpVisible() {
        return isExistsAndVisible(discountFromPromoPopUp);
    }


    public boolean isPromoPopUpAppeared() {

        Wait.visibility(discountFromPromoPopUp);
        return isExistsAndVisible(discountFromPromoPopUp);
    }

}
