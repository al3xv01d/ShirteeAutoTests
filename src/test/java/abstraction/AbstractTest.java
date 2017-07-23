package abstraction;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.IndexPage;
import tools.Config;
import tools.Driver;
import tools.PageBuilder;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    protected WebDriver driver = Driver.getDriver();
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public static void setUp(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setEnv(){

        IndexPage index = PageBuilder.buildIndexPage();

        Config.init("chrome","com", "live", false );

        index.open(Config.indexShirteeUrl);

        if(Config.domain == "de") {
            index.setLocale("de");
        } else if(Config.domain == "com") {
            index.setLocale("eng");
        }

        if(Config.isLogged) {
            index.login(true);
        }

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
