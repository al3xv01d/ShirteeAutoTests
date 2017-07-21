package abstraction;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import tools.Config;
import tools.Driver;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    protected WebDriver driver = Driver.getDriver();
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public static void setUp(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Config.init("chrome","com", "live", false );
    }

    @BeforeMethod
    public void setEnv(){

    }

    @AfterMethod
    public void cleanUp(){
       Driver.getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
       // Driver.destroy();
    }
}
