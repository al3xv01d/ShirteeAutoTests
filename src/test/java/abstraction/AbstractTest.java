package abstraction;

//mvn test -Dsurefire.suiteXmlFiles=general.xml -Dbrowser="chrome" -Dserver="live" -Ddomain="de" -DisLogged="no"
//mvn test -Dsurefire.suiteXmlFiles=promo_creation.xml -Dbrowser="chrome" -Dserver="live" -Ddomain="de" -DisLogged="no"
//mvn clean install -Dsurefire.suiteXmlFiles=testng.xml -Dbrowser="chrome" -Dserver="dev" -Ddomain="de" -DisLogged="no"

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CheckoutPage;
import pages.IndexPage;
import tools.Config;
import tools.Driver;
import tools.PageBuilder;

import java.util.concurrent.TimeUnit;

public class AbstractTest {


    protected WebDriver driver = Driver.getDriver();
    protected SoftAssert softAssert = new SoftAssert();
    protected IndexPage index = PageBuilder.buildIndexPage();
    protected CheckoutPage ckp = PageBuilder.buildCheckoutPage();

    @BeforeClass
    public void setUp(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Config.init();
    }

//    @BeforeMethod
//    public void setEnv(){
//
//        index.openUrl(Config.indexShirteeUrl);
//
//        if(Config.domain == "de") {
//            index.setLocale("de");
//        } else if(Config.domain == "com") {
//            index.setLocale("eng");
//        }
//
//        if(Config.isLogged == "yes") {
//            index.login(true);
//            ckp.openSelf();
//            ckp.orderReviewBlock.getAllOrderedItems();
//        }
//
//    }

    @AfterMethod
    public void cleanUp(){
        Driver.getDriver().manage().deleteAllCookies();
        System.out.println("AFTER");
    }

    @AfterClass
    public static void tearDown(){
     //  Driver.destroy();
    }
}

