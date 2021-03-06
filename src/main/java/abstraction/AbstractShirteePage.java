package abstraction;

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
    private final String cartCounter_lo = "//span[@class=\"cart-item-info-header\"]";

    private final String searchField_lo = "//div[@class=\"header-search\"]//input";

    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(xpath= shirteeLogo_lo)
    protected WebElement shirteeLogo;

    @FindBy(xpath = openLocaleButton_lo)
    protected WebElement openLocaleButton;

    @FindBy(xpath = engLocaleBtn_lo)
    protected WebElement engLocaleBtn;

    @FindBy(xpath = germanLocaleBtn_lo)
    protected WebElement germanLocaleBtn;

    @FindBy(xpath = openloginFormBtn_lo)
    protected WebElement openloginFormBtn;

    @FindBy(id = loginInputField_lo)
    protected WebElement loginInputField;

    @FindBy(id = passwordInputField_lo)
    protected WebElement passwordInputField;

    @FindBy(xpath = loginBtn_lo)
    protected WebElement loginBtn;

    @FindBy(xpath = logOutBtn_lo)
    protected WebElement logOutBtn;

    @FindBy(xpath = cartBtn_lo)
    protected WebElement cartBtn;

    @FindBy(xpath = cartCounter_lo)
    protected WebElement cartCounter;


    @FindBy(xpath = searchField_lo)
    protected WebElement searchField;

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
                if(this.driver.getCurrentUrl().contains("shirtee.com") || Config.server == "dev" ) {
                    System.out.println(this.driver.getCurrentUrl());
                    openLocaleButton.click();
                    germanLocaleBtn.click();
                }
                break;
        }
    }

    public void login(boolean returnBackFromDashboard) {

        String currentUrl = driver.getCurrentUrl();
        this.openloginFormBtn.click();

        Wait.visibility(loginInputField);
        Wait.clickable(loginInputField);

        loginInputField.clear();
        loginInputField.sendKeys(Config.tester1_email);

        passwordInputField.clear();
        passwordInputField.sendKeys(Config.tester1_pass);

        loginBtn.click();

        if(returnBackFromDashboard) {
            driver.get(currentUrl);
        }
    }


    public void login(boolean returnBackFromDashboard, String tester) {
        String login;
        String password;

        String currentUrl = driver.getCurrentUrl();
        this.openloginFormBtn.click();

        Wait.visibility(loginInputField);
        Wait.clickable(loginInputField);

        if (tester.contains("auto1")) {
            login = Config.tester1_email;
            password = Config.tester1_pass;
        } else {
            login = Config.tester2_email;
            password = Config.tester2_pass;
        }

        loginInputField.clear();
        loginInputField.sendKeys(login);

        passwordInputField.clear();
        passwordInputField.sendKeys(password);

        loginBtn.click();

        if(returnBackFromDashboard) {
            driver.get(currentUrl);
        }
    }



    public void logout() {
        try {
            logOutBtn.click();
        } catch (Exception e) {
            driver.navigate().refresh();
            logOutBtn.click();
        }


    }

    public void gotoCart() {
        cartBtn.click();
    }

    public int getCartItemsCount() {
        return Integer.parseInt(cartCounter.getText());
    }

    public void search(String query) {
        fillInputField(searchField, query);
        searchField.submit();
    }

}
