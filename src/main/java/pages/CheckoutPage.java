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

    private final String backToStoreLink_lo = "//div[@class=\"breadcrumbs-checkout-back\"]//a";

    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(id = submitOrderFormBtn_lo)
    private WebElement submitOrderFormBtn;

    @FindBy(xpath = billingBlockTitle_lo)
    private WebElement billingBlockTitle;

    @FindBy(xpath = backToStoreLink_lo)
    private WebElement backToStoreLink;


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

    public void returnToStore() {
        backToStoreLink.click();
    }

    public void pushOrderBtn() {
        submitOrderFormBtn.click();
        waitLoadingPopUp();
    }

}
