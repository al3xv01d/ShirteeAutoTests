package tools;


import abstraction.AbstractPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupHelper {

    private static WebDriver driver = Driver.getDriver();

    private static String productPageLoadingPopup_lo = "//div[@id=\"designer-load-info\"]";


    public static void waitProductPagePopupLoading() {

        WebElement popup = driver.findElement(By.xpath(productPageLoadingPopup_lo));

        try {
            if(popup.isDisplayed() ) {
                Wait.invisibility(productPageLoadingPopup_lo);
            } else {
                Wait.seconds(1);
                if(popup.isDisplayed() ) {
                    Wait.invisibility(productPageLoadingPopup_lo);
                }
            }
        } catch (NoSuchElementException e) {

        }

    }

    public static void waitLoadingPromoPopup() {
        Wait.invisibility("//*[@id=\"promo_loading-loading\"]");

    }

    public static void waitCheckoutPopup() {
        try {
            WebElement updatePopUp2 = driver.findElement(By.xpath("//div[@class=\"loadinfo\"]"));
            Wait.stalenessOf(updatePopUp2);
        } catch (NoSuchElementException e) {

        }

        System.out.println("POPUP HIDES");
    }
}
