package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages_elements.AbstractPageElement;
import tools.Driver;

public abstract class AbstractPage extends AbstractPageElement {

    public void open(String url) {
        driver.get(url);
    }



}
