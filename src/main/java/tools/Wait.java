package tools;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private static WebDriver driver = Driver.getDriver();

    public static void visibility(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Element not found, not visibility!");
        }
    }

    public static void invisibility(String elementLocator) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementLocator)));
        } catch (TimeoutException e) {
            System.out.println("Element doesn't disappear!");
        }

    }

    public static void clickable(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("Element is ot clickable");
        }
    }

}
