package pages;

import abstraction.AbstractShirteePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class OrderSuccessPage extends AbstractShirteePage {

    private final String orderId_lo = "//*[@class=\"b-checkout-success-number\"]";

    @FindBy(xpath = orderId_lo)
    private WebElement orderId;

    public String getOrderId() {
        return orderId.getText();
    }

}

