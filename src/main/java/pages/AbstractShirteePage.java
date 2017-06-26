package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.Config;
import tools.Wait;

public abstract class AbstractShirteePage extends AbstractPage {

    //*******************  LOCATORS ********************//

    private final String shirteeLogo_lo = "//a[@class='logo']";
    private final String openLocaleButton_lo = "//div[@class=\"lang-dd-link\"]";
    private final String engLocaleBtn_lo = "//a[@class=\"en-us\"]";
    private final String germanLocaleBtn_lo = "//a[@class=\"de-de\"]";
    private final String openloginFormBtn_lo = "//div[@class=\"bhi-link-right\"]";
    private final String loginInputField_lo = "header-login-form-email";
    private final String passwordInputField_lo = "header-login-form-password";
    private final String loginBtn_lo = "//div[@class=\"youama-login-window\"]//button";
    private final String logOutBtn_lo = "//a[contains(@href,\"/account/logout/\")]";
    private final String cartBtn_lo = "//div[@class=\"header-cart\"]";

    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(xpath= shirteeLogo_lo)
    private WebElement shirteeLogo;

    @FindBy(xpath = openLocaleButton_lo)
    public WebElement openLocaleButton;

    @FindBy(xpath = engLocaleBtn_lo)
    public WebElement engLocaleBtn;

    @FindBy(xpath = germanLocaleBtn_lo)
    public WebElement germanLocaleBtn;

    @FindBy(xpath = openloginFormBtn_lo)
    public WebElement openloginFormBtn;

    @FindBy(id = loginInputField_lo)
    public WebElement loginInputField;

    @FindBy(id = passwordInputField_lo)
    public WebElement passwordInputField;

    @FindBy(xpath = loginBtn_lo)
    public WebElement loginBtn;

    @FindBy(xpath = logOutBtn_lo)
    public WebElement logOutBtn;

    @FindBy(xpath = cartBtn_lo)
    public WebElement cartBtn;

//    @FindBy(xpath = "//nav[@id=\"nav\"]/ul/li/a[contains(@href,\"/designer/\")]")
//    public WebElement designerLink;
//
//    @FindBy(xpath = "//nav[@id=\"nav\"]/ul/li/a[contains(@href,\"/shop\")]")
//    public WebElement shopLink;

    //*******************  ACTIONS ********************//

    /**
     * @param locale String - "de" or "eng"
     */
    public void setLocale(String locale) {
        switch (locale) {

            case "eng":
                if(this.driver.getCurrentUrl().contains("shirtee.de") ) {
                    System.out.println(this.driver.getCurrentUrl());
                    openLocaleButton.click();
                    engLocaleBtn.click();
                }
                break;

            case "de":
                if(this.driver.getCurrentUrl().contains("shirtee.com") ) {
                    System.out.println(this.driver.getCurrentUrl());
                    openLocaleButton.click();
                    germanLocaleBtn.click();
                }
                break;
        }
    }

    public void login(boolean returnToShirtee) {
        this.openloginFormBtn.click();

        Wait.visibility(loginInputField);

        loginInputField.clear();
        loginInputField.sendKeys("akh@gomage.com");

        passwordInputField.clear();
        passwordInputField.sendKeys("gomage777");

        loginBtn.click();

        if(returnToShirtee) {
            driver.get(Config.indexShirteeUrl);
        }
    }

    public void logout() {
        logOutBtn.click();
    }

    public void gotoCart() {
        cartBtn.click();
    }

}
