package tools;


import abstraction.AbstractPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupHelper {

    private static WebDriver driver = Driver.getDriver();

    private static String productPageLoadingPopup_lo = "//div[@id=\"designer-load-info\"]";


    public static void waitProductPagePopupLoading() {
        WebElement popup = driver.findElement(By.xpath(productPageLoadingPopup_lo));
        Wait.invisibility(productPageLoadingPopup_lo);
    }

    public static void waitLoadingPromoPopup() {
        Wait.invisibility("//*[@id=\"promo_loading-loading\"]");

    }
}
