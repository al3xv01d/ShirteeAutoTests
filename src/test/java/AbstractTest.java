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
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Config.init("chrome","de", "", false );
    }

    @BeforeTest
    public void setEnv(){

    }

    @AfterTest
    public void cleanUp(){
       // Driver.getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        //Driver.destroy();
    }
}
