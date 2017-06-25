package pages_elements.checkout;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;


public class ValidationElements extends AbstractPageElement{

    // ***************** BILLING FORM LOCATORS ******************** //

    protected final String emptyEmailMsg_lo = "//div[@id=\"advice-required-entry-billing_email\"]/div";
    protected final String incorrectEmailMsg_lo = "//div[@id=\"advice-validate-email-billing_email\"]/div";
    protected final String emptyBillingFirstNameMsg_lo = "//*[@id='advice-required-entry-billing_firstname']/div";
    protected final String emptyBillingLastNameMsg_lo = "//*[@id='advice-required-entry-billing_lastname']/div";
    protected final String emptyBillingAdressMsg_lo = "//*[@id='advice-required-entry-billing_street1']/div";
    protected final String emptyBillingZipCodeMsg_lo = "//*[@id='advice-required-entry-billing_postcode']/div";
    protected final String emptyBillingCityMsg_lo = "//*[@id='advice-required-entry-billing_city']/div";

    // ***************** SHIPPING FORM LOCATORS ******************** //


    // ***************** BILLING FORM ELEMENTS******************** //

    @FindBy(xpath = emptyEmailMsg_lo)
    private WebElement emptyEmailMsg;

    @FindBy(xpath = incorrectEmailMsg_lo)
    private WebElement incorrectEmailMsg;

    @FindBy(xpath = emptyBillingFirstNameMsg_lo)
    public WebElement emptyBillingFirstNameMsg;

    @FindBy(xpath = emptyBillingLastNameMsg_lo)
    private WebElement emptyBillingLastNameMsg;

    @FindBy(xpath = emptyBillingAdressMsg_lo)
    public WebElement emptyBillingAdressMsg;

    @FindBy(xpath = emptyBillingZipCodeMsg_lo)
    private WebElement emptyBillingZipCodeMsg;

    @FindBy(xpath = emptyBillingCityMsg_lo)
    private WebElement emptyBillingCityMsg;

    // ***************** SHIPPING FORM ELEMENTS******************** //

    @FindBy(xpath = "//*[@id='advice-required-entry-shipping_firstname']/div")
    private WebElement emptyShippingFirstNameMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-shipping_lastname']/div")
    private WebElement emptyShippingLastNameMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-shipping_street1']/div")
    private WebElement emptyShippingAdressMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-shipping_postcode']/div")
    private WebElement emptyShippingZipCodeMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-shipping_city']/div")
    private WebElement emptyShippingCityMsg;

    // ***************** BILLING FORM ACTIONS ******************** //

    public boolean isEmptyEmailMsgVisible() {
        return isElementExistAndIsElementVisible(emptyEmailMsg);
    }

    public boolean isIncorrectEmailMsgVisible() {
        return isElementExistAndIsElementVisible(incorrectEmailMsg);
    }

    public boolean isEmptyBillingFirstNameMsgVisible() {
        return isElementExistAndIsElementVisible(emptyBillingFirstNameMsg);
    }

    public boolean isEmptyBillingLastNameMsgVisible() {
        return isElementExistAndIsElementVisible(emptyBillingLastNameMsg);
    }

    public boolean isEmptyBillingAdressMsgVisible() {
        return isElementExistAndIsElementVisible(emptyBillingAdressMsg);
    }

    public boolean isEmptyBillingZipCodeMsgVisible() {
        return isElementExistAndIsElementVisible(emptyBillingZipCodeMsg);
    }

    public boolean isEmptyBillingCityMsgVisible() {
        return isElementExistAndIsElementVisible(emptyBillingCityMsg);
    }
}
