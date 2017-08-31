package dashboard_promo;

import abstraction.AbstractTestNoLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.dashboard.DashboardFacade;
import tools.Config;
import tools.PageBuilder;
import tools.PopupHelper;


public class PromotionsTests extends AbstractTestNoLogin {

    private double testDiscountValue = 5;

    @DataProvider
    public Object[][] promoType() {
        return new Object[][] {
                {"amount"},
                {"percent"}
        };
    }
    public PromotionsTests() {
        clearCacheAfterTest = true;
    }

   @Test(dataProvider = "promoType")
    public void createNewPromoCode(String promoType) {

       IndexPage index = PageBuilder.buildIndexPage();
       DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

       index.openUrl(Config.indexShirteeUrl);
       index.login(false, "auto2");

       dashboard.openUrl(Config.dashboardPromoPageUrl);

       dashboard.promoPage.generateRandomPromoCodeId();
       dashboard.promoPage.selectPromoCodeType(promoType);
       dashboard.promoPage.setDiscountAmount(testDiscountValue);
       dashboard.promoPage.pushAddCodeBtn();

       PopupHelper.waitLoadingPromoPopup();

       softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 1, "There is more than 1 promocode");

       if(promoType.contains("amount")) {
           softAssert.assertTrue( dashboard.promoPage.getAllPromoCodes().get(0).getCodeType().contains("Amount in €") ||
                   dashboard.promoPage.getAllPromoCodes().get(0).getCodeType().contains("Betrag in €"), "Wrong promo type");
       } else if(promoType.contains("percent")) {
           softAssert.assertTrue( dashboard.promoPage.getAllPromoCodes().get(0).getCodeType().contains("Percent") ||
                   dashboard.promoPage.getAllPromoCodes().get(0).getCodeType().contains("Prozent"), "Wrong promo type");
       }

       softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().get(0).getDiscountValue(), testDiscountValue, "Wrong discount value" );

       dashboard.promoPage.getAllPromoCodes().get(0).deletePromoCode();
       PopupHelper.waitLoadingPromoPopup();

       softAssert.assertAll();
   }

   @Test
   public void deletePromo() {
      IndexPage index = PageBuilder.buildIndexPage();
      DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

      index.openUrl(Config.indexShirteeUrl);
      index.login(false, "auto2");
      dashboard.openUrl(Config.dashboardPromoPageUrl);

      dashboard.promoPage.generateRandomPromoCodeId();
      dashboard.promoPage.selectPromoCodeType("percent");
      dashboard.promoPage.setDiscountAmount(testDiscountValue);
      dashboard.promoPage.pushAddCodeBtn();

      PopupHelper.waitLoadingPromoPopup();

      softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 1);
      dashboard.promoPage.getAllPromoCodes().get(0).deletePromoCode();
      PopupHelper.waitLoadingPromoPopup();
      softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 0);

      softAssert.assertAll();
   }

}
