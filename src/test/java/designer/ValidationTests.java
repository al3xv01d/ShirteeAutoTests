package designer;


import abstraction.AbstractTest;
import abstraction.AbstractTestNoLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DesignerPage;
import tools.Config;
import tools.PageBuilder;

public class ValidationTests extends AbstractTestNoLogin {

    @DataProvider
    public Object[][] wrongUrl() {
        return new Object[][] {
                {"2222222kjjg"},
                {"   www"},
                {"тест"},
                {"тtestру"}

        };
    }


    @Test
    public void stepOneEmptyTextField() {
        DesignerPage dp = PageBuilder.buildDesignerPage();

        dp.openUrl(Config.designerUrl);
        dp.gotoNextStep();

        softAssert.assertTrue( dp.validation.isS1ErrorPopupVisible() );
        dp.validation.s1CloseErrorPopup();
        softAssert.assertFalse( dp.validation.isS1ErrorPopupVisible() );

        softAssert.assertFalse( dp.isLoginFormVisible() );

        softAssert.assertAll();
    }

    @Test
    public void stepThreeCampaignNameMaxLength() {
        DesignerPage dp = PageBuilder.buildDesignerPage();

        dp.openUrl(Config.designerUrl);
        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();
        dp.gotoNextStep();

        dp.step3.setCampaignName("12345678901234567890123456789012345678901"); // 41 symbol
        System.out.println(dp.step3.getCampaignName());
        softAssert.assertTrue(dp.validation.isS3TitleLengthErrorMsgVisible());

        softAssert.assertFalse( dp.isLoginFormVisible() );

        softAssert.assertAll();
    }

    @Test
    public void s3EmptyUrlAndTitle() {
        DesignerPage dp = PageBuilder.buildDesignerPage();

        dp.openUrl(Config.designerUrl);
        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();
        dp.gotoNextStep();

        dp.step3.publishCampaign();

        softAssert.assertTrue(dp.validation.isS3EmptyTitleMsgVisible());
        softAssert.assertTrue(dp.validation.isS3EmptyUrlMsgVisible());
        softAssert.assertFalse( dp.isLoginFormVisible() );
        softAssert.assertAll();
    }

    @Test
    public void s3TryToCreateCampaignWithExistingUrl() {
        DesignerPage dp = PageBuilder.buildDesignerPage();

        dp.openUrl(Config.designerUrl);
        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();
        dp.gotoNextStep();
        dp.step3.setCampaignUrl("auto-test-company-1");
        dp.step3.setCampaignName("Just test");
        dp.step3.publishCampaign();

        softAssert.assertTrue(dp.validation.isS3UnavailableMsgVisible());
        softAssert.assertFalse( dp.isLoginFormVisible() );
        softAssert.assertAll();
    }

    @Test(dataProvider = "wrongUrl")
    public void s3UrlValidation(String wrongUrl) {
        DesignerPage dp = PageBuilder.buildDesignerPage();

        //dp.openUrl(Config.designerUrl);
        dp.openUrl("https://dev.shirtee.com/de/designer/?id=1140/");

        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();
        dp.gotoNextStep();
        dp.step3.setCampaignName("Just test");

        dp.step3.setCampaignUrl(wrongUrl);
        dp.step3.publishCampaign();

        softAssert.assertTrue(dp.validation.isS3ErrorUrlMsgVisible());
        softAssert.assertFalse( dp.isLoginFormVisible() );
        softAssert.assertAll();
    }




}
