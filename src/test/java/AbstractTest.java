import org.testng.annotations.*;
import tools.Driver;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    @BeforeClass
    public static void setUp(){
        Driver.getDriver().manage().window().maximize();
       // Driver.getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setEnv(){
//        driver.get(System.getProperty("mainPageURL"));
//        MainPage mainPage = new MainPage(driver);
//        driver.manage().window().maximize();
//
//        mainPage.switchToDELocale();
    }

    @AfterMethod
    public void cleanUp(){
        Driver.getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        //Driver.getDriver().quit();
    }
}
