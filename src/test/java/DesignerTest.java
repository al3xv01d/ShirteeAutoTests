import org.testng.annotations.Test;
import pages.DesignerPage;
import pages.IndexPage;
import pages_elements.designer.DesignerStepTwoProduct;
import tools.PageBuilder;

public class DesignerTest extends AbstractTest {

    @Test
    public void step1() {

        DesignerPage dp = PageBuilder.buildDesignerPage();
        dp.open("http://dev.shirtee.com/designer/?id=1140/");
        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();
        dp.gotoNextStep();
        dp.step3.setCampaignName("javatest");
        dp.step3.setCampaignUrl("javatest222");
        dp.step3.publishCampaign();
        dp.step3.loginForm.login();
    }
}
