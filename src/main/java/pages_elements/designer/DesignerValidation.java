package pages_elements.designer;


import abstraction.AbstractPageElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.Wait;

public class DesignerValidation extends AbstractPageElement {

    //*******************  LOCATORS ********************//

    private final String s1ErrorPopup_lo = "//div[@class=\"canvas-error-in\"]";
    private final String s1ErrorPopupCloseBtn_lo = "//div[@class=\"canvas-error-in\"]/*[@class=\"canvas-error-close\"]";

    private final String s3TitleLengthErrorMsg_lo = "//*[@id=\"title-lenght-error\"]";
    private final String s3EmptyTitleMsg_lo = "//*[@id=\"advice-required-entry-sales_name\"]";

    private final String s3EmptyUrlMsg_lo = "//*[@id=\"advice-required-entry-sales_url\"]";
    private final String s3ErrorUrlMsg_lo = "//*[@id=\"advice-validate-code-pd-sales_url\"]";
    private final String s3UnavailableMsg_lo = "//*[@id=\"advice-pd-url-sales_url\"]";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(xpath = s1ErrorPopup_lo)
    private WebElement stepOneErrorPopup;

    @FindBy(xpath = s1ErrorPopupCloseBtn_lo)
    private WebElement s1ErrorPopupCloseBtn;

    @FindBy(xpath = s3EmptyTitleMsg_lo)
    private WebElement s3EmptyTitleMsg;

    @FindBy(xpath = s3TitleLengthErrorMsg_lo)
    private WebElement s3TitleLengthErrorMsg;

    @FindBy(xpath = s3EmptyUrlMsg_lo)
    private WebElement s3EmptyUrlMsg;

    @FindBy(xpath = s3ErrorUrlMsg_lo)
    private WebElement s3ErrorUrlMsg;

    @FindBy(xpath = s3UnavailableMsg_lo)
    private WebElement s3UnavailableMsg;

    //******************* STEP ONE ACTIONS ********************//
    public boolean isS1ErrorPopupVisible() {
        return isExistsAndVisible(stepOneErrorPopup);
    }

    public void s1CloseErrorPopup() {
        s1ErrorPopupCloseBtn.click();
        Wait.invisibility(s1ErrorPopup_lo);
    }

    //******************* STEP THREE ACTIONS ********************//

    public boolean isS3TitleLengthErrorMsgVisible() {
        return isExistsAndVisible(s3TitleLengthErrorMsg);
    }

    public boolean isS3EmptyTitleMsgVisible() {
        return isExistsAndVisible(s3EmptyTitleMsg);
    }



    public boolean isS3EmptyUrlMsgVisible() {
        return isExistsAndVisible(s3EmptyUrlMsg);
    }

    public boolean isS3UnavailableMsgVisible() {
        return isExistsAndVisible(s3UnavailableMsg);
    }

    public boolean isS3ErrorUrlMsgVisible() {
        return isExistsAndVisible(s3ErrorUrlMsg);
    }
}
