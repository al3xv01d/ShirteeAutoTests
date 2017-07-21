package pages.dashboard;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages_elements.checkout.OrderedItem;
import pages_elements.dashboard_promo.PromoCode;
import tools.Wait;

import java.util.ArrayList;
import java.util.List;

public class DashboardPromotionPage extends AbstractDashboardPage{

    //*******************  LOCATORS ********************//

    private final String discountCodeField_lo = "promo_code";
    private final String generateCodeBtn_lo = "generate";
    private final String discountTypeSelector_lo = "discount_type";
    private final String discountAmountField_lo = "discount_amount";
    private final String addCodeBtn_lo = "add_code";

    private final String promoCodeLine_lo = "//*[@id='coupons_list']/tr";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = discountCodeField_lo)
    private WebElement promoCodeField;

    @FindBy(id = generateCodeBtn_lo)
    private WebElement generateCodeBtn;

    @FindBy(id = discountTypeSelector_lo)
    private WebElement discountTypeSelector;

    @FindBy(id = discountAmountField_lo)
    private WebElement discountAmountField;

    @FindBy(id = addCodeBtn_lo)
    private WebElement addCodeBtn;

    //****************** Other ************************//

    public List<PromoCode> allPromoCodes = new ArrayList<PromoCode>();

    //*******************  ACTIONS ********************//


    public List<PromoCode> getAllPromoCodes() {

        int allPromoQty = driver.findElements(By.xpath(this.promoCodeLine_lo)).size();

        if(null == allPromoCodes || allPromoQty != allPromoCodes.size() ) {

            for(int i=1; i <= allPromoQty ;i++) {
                this.allPromoCodes.add( new PromoCode(i) );
            }
        }
        return allPromoCodes;
    }

    //*******************  ACTIONS - PROMO CODE CREATION ********************//

    public void setPromoCodeId(String yourPromoCodeId) {
        fillInputField(promoCodeField, yourPromoCodeId);
    }

    public void generateRandomPromoCodeId() {
        Wait.visibility(generateCodeBtn);
        Wait.clickable(generateCodeBtn);
        generateCodeBtn.click();
    }

    public void selectPromoCodeType(String type) {

        if(isExistsAndVisible(discountTypeSelector)) {

            Select selector = new Select(discountTypeSelector);

            if(type == "amount") {
                selector.selectByIndex(0);
            } else if(type == "percent") {
                selector.selectByIndex(1);
            }
        }
    }

    public void setDiscountAmount(double discountAmount) {
        fillInputField(discountAmountField, Double.toString(discountAmount));
    }

    public void pushAddCodeBtn() {
        addCodeBtn.click();
    }

}
