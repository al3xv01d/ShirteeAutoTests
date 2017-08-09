package pages_elements.dashboard_promo;


import abstraction.AbstractPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.PriceHelper;
import tools.Wait;

public class PromoCode extends AbstractPageElement{

    private final String promoCodeLine_lo = "//*[@id='coupons_list']/tr[%d]";

    private final String Id_lo = "./td[1]";
    private final String Type_lo = "./td[2]";
    private final String discountValue_lo = "./td[3]";
    private final String deleteButton_Lo = "./td[5]/button[1]";


    private WebElement promoLine;

    public PromoCode(int promoCodeLine) {
        this.promoLine = driver.findElement(By.xpath(String.format(promoCodeLine_lo, promoCodeLine)));
    }


    public String getCodeId() {
        return promoLine.findElement(By.xpath(Id_lo)).getText();
    }

    public String getCodeType() {
        return promoLine.findElement(By.xpath(Type_lo)).getText();
    }

    public double getDiscountValue() {

        return PriceHelper.getRealPrice(promoLine.findElement(By.xpath(discountValue_lo)).getText());
    }

    public void deletePromoCode() {
        promoLine.findElement(By.xpath(deleteButton_Lo)).click();
        Wait.stalenessOf( promoLine.findElement(By.xpath(deleteButton_Lo)));
    }

}
