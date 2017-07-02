package pages;


import abstraction.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.checkout.*;

public class CheckoutPage extends AbstractPage {

    //******************* PAGE ELEMENTS ********************//

    public BillingBlock billingBlock;
    public PaymentBlock paymentBlock;
    public OrderReviewBlock orderReviewBlock;
    public ValidationElements validationElements;

    //******************* LOCATORS ********************//

    private final String submitOrderFormBtn_lo = "submit-btn";

    private final String billingBlockTitle_lo = "//*[@id=\"gcheckout-billing-address\"]/h2";

    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(id = submitOrderFormBtn_lo)
    private WebElement submitOrderFormBtn;

    @FindBy(xpath = billingBlockTitle_lo)
    private WebElement billingBlockTitle;


    //******************* CONSTRUCTOR ********************//

    public CheckoutPage(BillingBlock billingBlock,
                        PaymentBlock paymentBlock,
                        OrderReviewBlock orderReviewBlock,
                        ValidationElements validationElements )
    {
        this.billingBlock = billingBlock;
        this.paymentBlock = paymentBlock;
        this.orderReviewBlock = orderReviewBlock;
        this.validationElements = validationElements;
    }


    //******************* ACTIONS ********************//

    public void clickOnEmptyPlace() {
        billingBlockTitle.click();
    }

    public void order() {
        submitOrderFormBtn.click();
        waitLoadingPopUp();
    }

}
