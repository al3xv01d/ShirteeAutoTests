package pages_elements.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by User on 24.06.2017.
 */
public class CheckoutValidationElements {

    @FindBy(xpath = "//div[@id=\"advice-required-entry-billing_email\"]/div")
    public WebElement emptyEmailMsg;

    @FindBy(xpath = "//div[@id=\"advice-validate-email-billing_email\"]/div")
    public WebElement incorrectEmailMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-billing_firstname']/div")
    public WebElement emptyBillingFirstNameMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-billing_lastname']/div")
    public WebElement emptyBillingLastNameMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-billing_street1']/div")
    public WebElement emptyBillingAdressMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-billing_postcode']/div")
    public WebElement emptyBillingZipCodeMsg;

    @FindBy(xpath = "//*[@id='advice-required-entry-billing_city']/div")
    public WebElement emptyBillingCityMsg;

}
