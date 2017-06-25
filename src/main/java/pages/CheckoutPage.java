package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.checkout.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends AbstractPage{

    //******************* PAGE ELEMENTS ********************//

    public BillingBlock billingBlock = new BillingBlock();
    public PaymentBlock paymentBlock = new PaymentBlock();
    public OrderReviewBlock orderReviewBlock = new OrderReviewBlock();
    public ValidationElements validationElements = new ValidationElements();

    //******************* LOCATORS ********************//

    private final String submitOrderFormBtn_lo = "submit-btn";

    //******************* WEBDRIVER ELEMENTS ********************//

    @FindBy(id = submitOrderFormBtn_lo)
    private WebElement submitOrderFormBtn;

    //******************* ACTIONS ********************//

    public void order() {
        submitOrderFormBtn.click();
    }

}
