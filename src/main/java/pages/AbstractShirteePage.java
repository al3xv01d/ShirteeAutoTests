package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.Wait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractShirteePage extends AbstractPage {

    @FindBy(xpath="//a[@class='logo']")
    private WebElement shirteeLogo;

    @FindBy(xpath = "//div[@class=\"lang-dd-link\"]")
    public WebElement openLocaleButton;

    @FindBy(xpath = "//a[@class=\"en-us\"]")
    public WebElement engLocaleBtn;

    @FindBy(xpath = "//a[@class=\"de-de\"]")
    public WebElement germanLocaleBtn;

    @FindBy(xpath = "//div[@class=\"bhi-link-right\"]")
    public WebElement openloginFormBtn;

    @FindBy(id = "header-login-form-email")
    public WebElement loginInputField;

    @FindBy(id = "header-login-form-password")
    public WebElement passwordInputField;

    @FindBy(xpath = "//div[@class=\"youama-login-window\"]//button")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[contains(@href,\"/account/logout/\")]")
    public WebElement logOutBtn;

    @FindBy(xpath = "//div[@class=\"header-cart\"]")
    public WebElement cartBtn;

//    @FindBy(xpath = "//nav[@id=\"nav\"]/ul/li/a[contains(@href,\"/designer/\")]")
//    public WebElement designerLink;
//
//    @FindBy(xpath = "//nav[@id=\"nav\"]/ul/li/a[contains(@href,\"/shop\")]")
//    public WebElement shopLink;


    /**
     * @param locale String - "de" or "eng"
     */
    public void setLocale(String locale) {
        switch (locale) {

            case "eng":
                if(this.driver.getCurrentUrl().contains("shirtee.de") ) {
                    System.out.println(this.driver.getCurrentUrl());
                    this.openLocaleButton.click();
                    this.engLocaleBtn.click();
                }
                break;

            case "de":
                if(this.driver.getCurrentUrl().contains("shirtee.com") ) {
                    System.out.println(this.driver.getCurrentUrl());
                    this.openLocaleButton.click();
                    this.germanLocaleBtn.click();
                }
                break;
        }
    }

    public void logIn() {
        this.openloginFormBtn.click();

        Wait.visible(loginInputField);

        this.loginInputField.clear();
        this.loginInputField.sendKeys("akh@gomage.com");

        this.passwordInputField.clear();
        this.passwordInputField.sendKeys("Testusa1");

        this.loginBtn.click();
    }

    public void logOut() {
        logOutBtn.click();
    }

    public void gotoCart() {
        cartBtn.click();
    }

}
