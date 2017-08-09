package pages_elements.dashboard_promo;


import abstraction.AbstractPageElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromoValidation extends AbstractPageElement{

    private final String lengthErrorMsg_lo = "//*[@class=\"input-group-input __has_error\"]/div[@class=\"error-message promo_code-error-length-validation\"]";
    private final String regexErrorMsg_lo = "//*[@class=\"input-group-input __has_error\"]/div[@class=\"error-message promo_code-error-validation\"]";

    private final String emptyDiscountMsg_lo ="//*[@class=\"input-group input-group-discount-amount\"]//div[@class=\"profit-empty-validation error-message\"]";
    private final String invalidDiscountMsg_lo = "//*[@class=\"input-group input-group-discount-amount\"]//div[@class=\"error-message profit-error-validation\"]";
    private final String regexErrorDiscountMsg_lo = "//div[@class=\"input-group input-group-discount-amount\"]//div[@class=\"profit-regex-validation error-message\"]";

    @FindBy(xpath = lengthErrorMsg_lo)
    private WebElement lengthErrorMsg;

    @FindBy(xpath = regexErrorMsg_lo)
    private WebElement regexErrorMsg;

    @FindBy(xpath = emptyDiscountMsg_lo)
    private WebElement emptyDiscountMsg;

    @FindBy(xpath = invalidDiscountMsg_lo)
    private WebElement invalidDiscountMsg;

    @FindBy(xpath = regexErrorDiscountMsg_lo)
    private WebElement regexErrorDiscountMsg;

    public boolean isLengthErrorMsgVisible() {
        return isExistsAndVisible(lengthErrorMsg);
    }

    public boolean isRegexErrorMsgVisible() {
        return isExistsAndVisible(regexErrorMsg);
    }

    public boolean isEmptyDiscountMsgVisible() {
        return isExistsAndVisible(emptyDiscountMsg);
    }

    public boolean isInvalidDiscountMsgVisible() {
        return isExistsAndVisible(invalidDiscountMsg);
    }

    public boolean isRegexErrorDiscountMsgVisible() {
        return isExistsAndVisible(regexErrorDiscountMsg);
    }

}
