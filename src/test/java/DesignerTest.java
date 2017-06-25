import org.testng.annotations.Test;
import pages.DesignerPage;
import pages.IndexPage;
import pages_elements.designer.Product;

public class DesignerTest extends AbstractTest {

    @Test
    public void step1() {
        IndexPage pp = new IndexPage();
        pp.open("https://www.shirtee.com/designer/?id=4528");
        DesignerPage dp = new DesignerPage();

        dp.step1.fillProductText("FUCK");
        dp.gotoNextStep();
        dp.step2.products.addAnotherProduct();

        Product dp1 = dp.step2.products.getProduct(1);
    }
}
