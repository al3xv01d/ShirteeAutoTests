package abstraction;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import tools.Driver;
import tools.Wait;

public abstract class AbstractPageElement {

    protected WebDriver driver;



    public AbstractPageElement(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

//        if (isAlertPresent())
//        {
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//        }
    }

    protected void fillInputField(WebElement inputField, String data) {
        Wait.visibility(inputField);
        inputField.clear();
        inputField.sendKeys(data);
    }

    protected boolean isExistsAndVisible(WebElement element) {

        boolean result;

        try {
            result = element.isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }

        return result;
    }

    protected boolean isExist(WebElement element) {
        return null != element;
    }

    // UNIVERSAL POPUP WAIT

    private final String orderPageUpdateDataPopUp_lo = "//div[@class=\"loadinfo\"]";
    public void waitLoadingPopUp() {

        WebElement updatePopUp2 = driver.findElement(By.xpath(orderPageUpdateDataPopUp_lo));

        //TimeUnit.SECONDS.sleep(1);

        Wait.stalenessOf(updatePopUp2);

        System.out.println("POPUP HIDES");

    }

    protected void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0,0);");
    }
}
