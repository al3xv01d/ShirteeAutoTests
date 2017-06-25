package tools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;


    public static WebDriver getDriver() {


        if(null == Driver.driver ) {

            switch(Config.browser) {
                case "firefox":
                    Driver.driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                    Driver.driver = new ChromeDriver();
                    break;
                default:
                    Driver.driver = new FirefoxDriver();
                    break;
            }
            return Driver.driver;
        }

        return Driver.driver;
    }

    public static void destroy() {
        Driver.driver.close();
        Driver.driver = null;
    }

}
