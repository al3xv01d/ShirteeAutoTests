package abstraction;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import tools.Config;
import tools.Driver;
import tools.Wait;

import java.util.concurrent.TimeUnit;

public class AbstractTestNoLogin {

    protected boolean clearCacheAfterTest = false;

    protected WebDriver driver = Driver.getDriver();
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Config.init();
    }

    @AfterMethod
    public void setEnv(){

        try {
            Wait.seconds(2);
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {

        }
        if(clearCacheAfterTest) {
            Driver.getDriver().manage().deleteAllCookies();
            System.out.println("WTF!!!!");
        }

    }


    @AfterClass
    public static void tearDown(){
       // Driver.destroy();
    }
}
