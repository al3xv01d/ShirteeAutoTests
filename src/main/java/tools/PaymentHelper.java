package tools;

import org.openqa.selenium.By;
//import static com.codeborne.selenide.Selenide.$;




public class PaymentHelper {

    public static double getPriceFromPayPal() {

       double price = PriceHelper.getRealPrice( Driver.getDriver().findElement(By.xpath("//cart-wrapper//format-currency/span")).getText() ) ;
       return price;
    }

}
