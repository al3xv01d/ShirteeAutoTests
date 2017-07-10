package tools;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {

    private static WebDriver driver = Driver.getDriver();

    public static void seconds(int seconds) {

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {}

    }

    public static void visibility(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Element not visible - " + element.getTagName());
        }
    }

    public static void invisibility(String elementLocator) {

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            if( Driver.isExistOnPage(elementLocator) ) {
                System.out.println(Driver.isExistOnPage(elementLocator));
                try {
                    WebDriverWait wait = new WebDriverWait(driver, 2);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementLocator)));
                } catch (TimeoutException e) {
                    System.out.println("Element doesn't disappear!");
                }
            } else {
                System.out.println(Driver.isExistOnPage(elementLocator));
            }

    }

    public static void clickable(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("Element is not clickable");
        }
    }

    public static void stalenessOf(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.stalenessOf((element)));
        } catch (TimeoutException e) {
            System.out.println("Element doesn't destroy!");
        }

    }

}
