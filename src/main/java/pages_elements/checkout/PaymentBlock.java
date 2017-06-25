package pages_elements.checkout;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;
import tools.Wait;

public class PaymentBlock extends AbstractPageElement{

    protected final String creditCardMethod_lo = "//label[@for=\"p_method_payone_creditcard\"]";
    protected final String payPalMethod_lo = "//label[@for=\"p_method_paypal_express\"]";
    protected final String sofortMethod_lo = "//label[@for=\"p_method_paymentnetwork_pnsofortueberweisung\"]";
    protected final String klarnaMethod_lo = "//label[@for=\"p_method_vaimo_klarna_invoice\"]";
    protected final String bankMethod_lo = "//label[@for=\"p_method_banktransfer\"]";


    @FindBy(xpath = creditCardMethod_lo)
    private WebElement creditCardMethod;

    @FindBy(xpath = payPalMethod_lo)
    private WebElement payPalMethod;

    @FindBy(xpath = sofortMethod_lo)
    private WebElement sofortMethod;

    @FindBy(xpath = klarnaMethod_lo)
    private WebElement klarnaMethod;

    @FindBy(xpath = bankMethod_lo)
    private WebElement bankMethod;


    public void selectCreditCardMethod() {
       // Wait.visible(creditCardMethod);
        this.creditCardMethod.click();
    }

    public void selectPayPalMethod() {
        this.payPalMethod.click();
    }

    public void selectSofortMethod() {
        this.sofortMethod.click();
    }

    public void selectKlarnaMethod() {
        this.klarnaMethod.click();
    }

    public void selectBankMethod() {
        this.bankMethod.click();
    }




}
