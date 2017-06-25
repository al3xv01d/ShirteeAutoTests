import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import tools.Config;
import tools.Driver;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public static void setUp(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void setEnv(){
//        driver.get(System.getProperty("mainPageURL"));
//        MainPage mainPage = new MainPage(driver);
//        driver.manage().window().maximize();
//
//        mainPage.switchToDELocale();
    }

    @AfterTest
    public void cleanUp(){
       // Driver.getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
       // Driver.destroy();
    }
}
