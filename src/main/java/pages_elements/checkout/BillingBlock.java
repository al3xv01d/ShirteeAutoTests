package pages_elements.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages_elements.AbstractPageElement;
import tools.RandomData;
import tools.Wait;

public class BillingBlock extends AbstractPageElement{

    //******************* BILLING FORM LOCATORS ********************//

    protected final String billingEmailField_lo = "billing_email";
    protected final String billingHerrRadioButton_lo = "billing[prefix]_Mr.";
    protected final String billingFrauRadioButton_lo = "billing[prefix]_Ms/Mrs.";
    protected final String billingCompanyRadioButton_lo = "billing_add-company";
    protected final String billingFirstNameField_lo = "billing_firstname";
    protected final String billingLastNameField_lo = "billing_lastname";
    protected final String billingAdressField_lo = "billing_street1";
    protected final String billingZipCodeField_lo = "billing_postcode";
    protected final String billingCityField_lo = "billing_city";

    //******************* SHIPPING FORM LOCATORS ********************//

    protected final String shippingHerrRadioButton_lo = "shipping[prefix]_Mr.";
    protected final String shippingFrauRadioButton_lo = "shipping[prefix]_Ms/Mrs.";
    protected final String shippingCompanyRadioButton_lo = "shipping_add-company";
    protected final String shippingFirstNameField_lo = "shipping_firstname";
    protected final String shippingLastNameField_lo = "shipping_lastname";
    protected final String shippingAdressField_lo = "shipping_street1";
    protected final String shippingZipCodeField_lo = "shipping_postcode";
    protected final String shippingCityField_lo = "shipping_city";

    protected final String shippingAdressCheckbox_lo = "//label[@for=\"billing_use_for_shipping_yes\"]";

    //******************* BILLING FORM ********************//

    @FindBy(id = billingEmailField_lo)
    public WebElement billingEmailField;

    @FindBy(id = billingHerrRadioButton_lo)
    public WebElement billingHerrRadioButton;

    @FindBy(id = billingFrauRadioButton_lo)
    public WebElement billingFrauRadioButton;

    @FindBy(id = billingCompanyRadioButton_lo)
    public WebElement billingCompanyRadioButton;

    @FindBy(id = billingFirstNameField_lo)
    public WebElement billingFirstNameField;

    @FindBy(id = billingLastNameField_lo)
    public WebElement billingLastNameField;

    @FindBy(id = billingAdressField_lo)
    public WebElement billingAdressField;

    @FindBy(id = billingZipCodeField_lo)
    public WebElement billingZipCodeField;

    @FindBy(id = billingCityField_lo)
    public WebElement billingCityField;

    protected Select countrySelect;

    //******************* Click on this checkbox to open SHIPPING FORM ********************//

    @FindBy(xpath = shippingAdressCheckbox_lo)
    protected WebElement shippingAdressCheckbox;

    //******************* SHIPPING FORM ********************//

    @FindBy(id = shippingHerrRadioButton_lo)
    public WebElement shippingHerrRadioButton;

    @FindBy(id = shippingFrauRadioButton_lo)
    public WebElement shippingFrauRadioButton;

    @FindBy(id = shippingCompanyRadioButton_lo)
    public WebElement shippingCompanyRadioButton;

    @FindBy(id = shippingFirstNameField_lo)
    public WebElement shippingFirstNameField;

    @FindBy(id = shippingFirstNameField_lo)
    public WebElement shippingLastNameField;

    @FindBy(id = shippingAdressField_lo)
    public WebElement shippingAdressField;

    @FindBy(id = shippingZipCodeField_lo)
    public WebElement shippingZipCodeField;

    @FindBy(id = shippingCityField_lo)
    public WebElement shippingCityField;

    //******************* ACTIONS ********************//

    public void toggleShippingAdressForm() {
        Wait.visibility(shippingAdressCheckbox);
        shippingAdressCheckbox.click();
    }

    public void fillBillingForm() {
        fillInputField(billingEmailField, "dfdgfd@dsggf.com");
        fillInputField(billingFirstNameField, RandomData.getRandomName());

    }

    public void fillShippingForm() {

    }


}
