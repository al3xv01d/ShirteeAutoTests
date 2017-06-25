package pages_elements;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tools.Driver;

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

    public void fillInputField(WebElement inputField, String data) {
        inputField.clear();
        inputField.sendKeys(data);
    }

    protected boolean isElementExistAndIsElementVisible(WebElement element) {

        boolean result;

        try {
            result = element.isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }

        return result;
    }

}
