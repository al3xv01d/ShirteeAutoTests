package tools;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;


    public static WebDriver getDriver() {


        if(null == Driver.driver ) {

            System.out.println("---------" + Config.browser);

            if(null == Config.browser) {
                Driver.driver = new ChromeDriver();
            } else if(Config.browser.equals("firefox")) {
                Driver.driver = new FirefoxDriver();
            } else if(Config.browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                Driver.driver = new ChromeDriver();
            }

            return Driver.driver;
        }

        return Driver.driver;
    }

    public static void destroy() {

        try
        {
            driver.close();
            driver.quit();
        }
        catch (Exception anException)
        {
            Driver.driver = null;
        }

    }

    public static WebElement find(String locator) {

        WebElement element;

        try {
            element = driver.findElement(By.xpath(locator));
            return element;
        } catch (NoSuchElementException e) {
            System.out.println("ERROR. CANNOT FIND ELEMENT!");
            element = driver.findElement(By.xpath("//p"));
            return element;
        }

    }

    public static boolean isExistOnPage(String xpathLocator) {

        try {
            driver.findElement(By.xpath(xpathLocator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0,0);");
    }


}
