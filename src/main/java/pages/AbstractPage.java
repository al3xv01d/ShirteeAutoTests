package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tools.Driver;

public abstract class AbstractPage {

    protected WebDriver driver;


    public AbstractPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

//        if (isAlertPresent())
//        {
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//        }
    }

    public void open(String url) {
        driver.get(url);
    }

}
