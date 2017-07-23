package dashboard_promo;

import abstraction.AbstractTestNoConfig;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.dashboard.DashboardFacade;
import tools.Config;
import tools.PageBuilder;


public class PromotionsTests extends AbstractTestNoConfig{

   @Test
    public void createNewPromoCode() {

       IndexPage index = PageBuilder.buildIndexPage();
       DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

       index.openUrl(Config.indexShirteeUrl);
       index.setLocale("de");
       index.login(false);


       dashboard.openUrl(Config.dashboardPromoPageUrl);

       dashboard.promoPage.generateRandomPromoCodeId();
       dashboard.promoPage.selectPromoCodeType("percent");
       dashboard.promoPage.setDiscountAmount(5);
     //  dashboard.promoPage.pushAddCodeBtn();

       System.out.println(       dashboard.promoPage.getAllPromoCodes().size() );

      dashboard.promoPage.getAllPromoCodes().get(2).deletePromoCode();
   }

   @Test
   public void deletePromo() {
      IndexPage index = PageBuilder.buildIndexPage();
      DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

      index.openUrl(Config.indexShirteeUrl);
      index.setLocale("de");
      index.login(false);


      dashboard.openUrl(Config.dashboardPromoPageUrl);

      dashboard.promoPage.generateRandomPromoCodeId();
      dashboard.promoPage.selectPromoCodeType("percent");
      dashboard.promoPage.setDiscountAmount(5);
      dashboard.promoPage.pushAddCodeBtn();

      softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 1);

      dashboard.promoPage.getAllPromoCodes().get(0).deletePromoCode();

      softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 0);
   }

}
