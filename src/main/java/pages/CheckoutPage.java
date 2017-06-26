package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.checkout.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends AbstractPage{

    //******************* PAGE ELEMENTS ********************//

    public BillingBlock billingBlock;
    public PaymentBlock paymentBlock;
    public OrderReviewBlock orderReviewBlock;
    public ValidationElements validationElements;

    //******************* LOCATORS ********************//

    private final String submitOrderFormBtn_lo = "submit-btn";

    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(id = submitOrderFormBtn_lo)
    private WebElement submitOrderFormBtn;

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

    public void order() {
        submitOrderFormBtn.click();
    }

}
