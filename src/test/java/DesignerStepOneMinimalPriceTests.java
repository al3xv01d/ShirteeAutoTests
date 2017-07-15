import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DesignerPage;
import tools.Config;
import tools.PageBuilder;

// Test 1 - check minimum price for product with one side
// Test 2 - check minimum price for product with two sides

public class DesignerStepOneMinimalPriceTests extends AbstractTest {

    private double ONE_SIDE_MINIMAL_PRICE = 9.00;
    private double TWO_SIDES_MINIMAL_PRICE = 15.50;

    @Test
    public void oneSideMinimalPrice() {
        DesignerPage designer = PageBuilder.buildDesignerPage();

        designer.open(Config.designerUrl);

        designer.step1.fillProductText("TEST");

        double pricePerPiece = designer.step1.getPricePerPiece();

        Assert.assertEquals(pricePerPiece, ONE_SIDE_MINIMAL_PRICE);
    }

    @Test
    public void twoSidesMinimalPrice() {
        DesignerPage designer = PageBuilder.buildDesignerPage();

        designer.open(Config.designerUrl);

        designer.step1.fillProductText("FRONT");
        designer.step1.showBackSide();
        designer.step1.fillProductText("BACK");

        double pricePerPiece = designer.step1.getPricePerPiece();

        Assert.assertEquals(pricePerPiece, TWO_SIDES_MINIMAL_PRICE);
    }

}
