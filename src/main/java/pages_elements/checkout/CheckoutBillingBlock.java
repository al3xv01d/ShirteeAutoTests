package pages_elements.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPage;
import tools.Wait;

public class CheckoutBillingBlock extends AbstractPage{

    //******************* BILLING FORM ********************//

    @FindBy(id = "billing_email")
    public WebElement billingEmailField;

    @FindBy(id = "billing[prefix]_Mr.")
    public WebElement billingHerrRadioButton;

    @FindBy(id = "billing[prefix]_Ms/Mrs.")
    public WebElement billingFrauRadioButton;

    @FindBy(id = "billing_add-company")
    public WebElement billingCompanyRadioButton;

    @FindBy(id = "billing_firstname")
    public WebElement billingFirstNameField;

    @FindBy(id = "billing_lastname")
    public WebElement billingLastNameField;

    @FindBy(id = "billing_street1")
    public WebElement billingAdressField;

    @FindBy(id = "billing_postcode")
    public WebElement billingZipCodeField;

    @FindBy(id = "billing_city")
    public WebElement billingCityField;

    protected Select countrySelect;

    //******************* Click on this checkbox to open SHIPPING FORM ********************//

    @FindBy(xpath = "//label[@for=\"billing_use_for_shipping_yes\"]")
    protected WebElement shippingAdressLabel ;

    //******************* SHIPPING FORM ********************//

    @FindBy(id = "shipping[prefix]_Mr.")
    public WebElement shippingHerrRadioButton;

    @FindBy(id = "shipping[prefix]_Ms/Mrs.")
    public WebElement shippingFrauRadioButton;

    @FindBy(id = "shipping_add-company")
    public WebElement shippingCompanyRadioButton;

    @FindBy(id = "shipping_firstname")
    public WebElement shippingFirstNameField;

    @FindBy(id = "shipping_lastname")
    public WebElement shippingLastNameField;

    @FindBy(id = "shipping_street1")
    public WebElement shippingAdressField;

    @FindBy(id = "shipping_postcode")
    public WebElement shippingZipCodeField;

    @FindBy(id = "shipping_city")
    public WebElement shippingCityField;

    public void toggleShippingAdressForm() {
        Wait.visible(shippingAdressLabel);
        shippingAdressLabel.click();
    }


}
