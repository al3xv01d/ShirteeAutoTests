import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DesignerPage;
import pages_elements.designer.StepTwoAddedProduct;
import tools.PageBuilder;
import tools.Wait;

import java.util.List;

public class DesignerTest extends AbstractTest {

    @Test
    public void step1() {

        DesignerPage dp = PageBuilder.buildDesignerPage();
        dp.open("http://dev.shirtee.com/designer/?id=1140/");
        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();

        dp.step2.addAllProducts();
        List<StepTwoAddedProduct> allProducts = dp.step2.getAllAddedProducts();

        System.out.println(allProducts.size());

        allProducts.get(13).selectAllColors();



//        String contents = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", allProducts.get(0).productColorBlock);
//        System.out.println(contents);

//        dp.gotoNextStep();
//        dp.step3.setCampaignName("javatest");
//        dp.step3.setCampaignUrl("javatest222");
//        dp.step3.publishCampaign();
//        dp.step3.loginForm.login();
    }
}

