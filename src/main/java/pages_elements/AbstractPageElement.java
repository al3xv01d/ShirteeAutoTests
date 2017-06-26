package pages_elements;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public boolean isExistsAndVisible(WebElement element) {

        boolean result;

        try {
            result = element.isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }

        return result;
    }

    public boolean isExist(WebElement element) {
        return null != element;
    }

}
