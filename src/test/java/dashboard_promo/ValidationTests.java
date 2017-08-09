package dashboard_promo;

import abstraction.AbstractTestNoLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.dashboard.DashboardFacade;
import tools.Config;
import tools.PageBuilder;
import tools.Wait;

public class ValidationTests extends AbstractTestNoLogin {

    @DataProvider
    public Object[][] wrongLengthPromoCodes() {
        return new Object[][] {
                {"1"},
                {"1234567"},
                {"12345678"},
                {"123456789"},
                {"a"},
                {"abcdfgq"},
                {"abcdfgqw"},
                {"abcdfgqww"}
        };
    }

    @DataProvider
    public Object[][] wrongRegexPromoCodes() {
        return new Object[][] {
                {"тесттест"},
                {"1тест234"},
                {"111**11"},
                {"/*-+~!@"},
                {"ÄÖÜẞäöüß"}
        };
    }

    @DataProvider
    public Object[][] wrongRegexDiscount() {
        return new Object[][] {
                {"те"},
                {"1т"},
                {"1!"},
                {"/*-+~!@"},
                {"ab"},
                {"ÄÖÜẞäöüß"}
        };
    }

    @DataProvider
    public Object[][] tooBigAmountDiscount() { // max = 13.94
        return new Object[][] {
                {13.95},
                {13.94},
                {13.93},
                {1},
                {50},
                {14}
        };
    }

    @DataProvider
    public Object[][] tooBigPercentDiscount() { // max = 60.74
        return new Object[][] {
                {60.74},
                {60.75},
                {60.73},
                {1},
                {99}
        };
    }

    @Test(dataProvider = "tooBigPercentDiscount")
    public void checkDiscountPercentValueValidation(double code) {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);
        dashboard.promoPage.selectPromoCodeType("percent");
        dashboard.promoPage.setDiscountAmount(code);
        dashboard.promoPage.pushAddCodeBtn();

        if(code < 60.75) {
            softAssert.assertFalse( dashboard.promoPage.validation.isInvalidDiscountMsgVisible() );
        } else {
            softAssert.assertTrue( dashboard.promoPage.validation.isInvalidDiscountMsgVisible() );
        }

        softAssert.assertAll();
    }

    @Test(dataProvider = "tooBigAmountDiscount")
    public void checkDiscountAmountValueValidation(double code) {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.setDiscountAmount(code);
        dashboard.promoPage.pushAddCodeBtn();

        if(code < 13.95) {
            softAssert.assertFalse( dashboard.promoPage.validation.isInvalidDiscountMsgVisible() );
        } else {
            softAssert.assertTrue( dashboard.promoPage.validation.isInvalidDiscountMsgVisible() );
        }

        softAssert.assertAll();
    }

    @Test(dataProvider = "wrongRegexDiscount")
    public void checkDiscountRegexValidation(String code) {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.setDiscountAmount(code);
        dashboard.promoPage.pushAddCodeBtn();

        softAssert.assertTrue( dashboard.promoPage.validation.isRegexErrorDiscountMsgVisible() );
        softAssert.assertAll();
    }


    @Test(dataProvider = "wrongRegexPromoCodes")
    public void checkPromoCodeRegexValidation(String code) {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.setPromoCodeId(code);
        dashboard.promoPage.pushAddCodeBtn();

        softAssert.assertTrue( dashboard.promoPage.validation.isRegexErrorMsgVisible() );
        softAssert.assertAll();
    }

    @Test(dataProvider = "wrongLengthPromoCodes")
    public void checkPromoCodeLengthValidation(String code) {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.setPromoCodeId(code);
        dashboard.promoPage.pushAddCodeBtn();

        if(code.length() == 8) {
            softAssert.assertFalse( dashboard.promoPage.validation.isLengthErrorMsgVisible() );
        } else {
            softAssert.assertTrue( dashboard.promoPage.validation.isLengthErrorMsgVisible() );
        }

        softAssert.assertAll();
    }

    @Test
    public void tryToCreatePromoWithExistingCode() {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false);

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.setPromoCodeId("11amount");
        dashboard.promoPage.selectPromoCodeType("amount");
        dashboard.promoPage.setDiscountAmount(5);
        dashboard.promoPage.pushAddCodeBtn();

        softAssert.assertTrue( dashboard.promoPage.isCreationErrorPopupVisible() );
        softAssert.assertAll();
    }

    @Test
    public void tryToAddPromoWithoutCodeAndDiscountValue() {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.pushAddCodeBtn();

        softAssert.assertTrue( dashboard.promoPage.validation.isEmptyDiscountMsgVisible() );
        softAssert.assertTrue( dashboard.promoPage.validation.isRegexErrorMsgVisible() );
        Wait.seconds(3);
        softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 0, "Promo validation doesn't work");

        softAssert.assertAll();
    }

    @Test
    public void tryToAddPromoWithoutCode() {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.setDiscountAmount(5);
        dashboard.promoPage.pushAddCodeBtn();

        softAssert.assertFalse( dashboard.promoPage.validation.isEmptyDiscountMsgVisible() );
        softAssert.assertTrue( dashboard.promoPage.validation.isRegexErrorMsgVisible() );
        Wait.seconds(3);
        softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 0, "Promo validation doesn't work");

        softAssert.assertAll();
    }

    @Test
    public void tryToAddPromoWithoutDiscountValue() {
        IndexPage index = PageBuilder.buildIndexPage();
        DashboardFacade dashboard = PageBuilder.buildDashboardFacade();

        index.openUrl(Config.indexShirteeUrl);
        index.login(false, "auto2");

        dashboard.openUrl(Config.dashboardPromoPageUrl);

        dashboard.promoPage.setPromoCodeId("12345678");
        dashboard.promoPage.pushAddCodeBtn();

        softAssert.assertTrue( dashboard.promoPage.validation.isEmptyDiscountMsgVisible() );
        softAssert.assertFalse( dashboard.promoPage.validation.isRegexErrorMsgVisible() );
        Wait.seconds(3);
        softAssert.assertEquals(dashboard.promoPage.getAllPromoCodes().size(), 0, "Promo validation doesn't work");

        softAssert.assertAll();
    }
}
