package tools;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 20.06.2017.
 */
public class Wait {

    private static WebDriver driver = Driver.getDriver();

    public static void visible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 35);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Element not found, not visible!");
        }
    }
}
