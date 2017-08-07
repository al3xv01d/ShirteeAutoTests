package designer;

import abstraction.AbstractTestNoLogin;
import org.testng.annotations.Test;
import pages.DesignerPage;
import pages.ProductPage;
import pages_elements.designer.StepTwoAddedProduct;
import tools.*;

import java.util.List;

public class DesignerTest extends AbstractTestNoLogin {

    @Test
    public void step1() {

        DesignerPage dp = PageBuilder.buildDesignerPage();
       // dp.openUrl("https://dev.shirtee.de");
        //dp.login(true);

        //dp.setLocale("de");
        dp.openUrl("https://dev.shirtee.de/designer/?id=1140/");

//https://dev.shirtee.de/designer/?id=1140/
 //https://stage.shirtee.de/designer/?id=1140/
        //https://www.shirtee.com/designer/?id=1140/

        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();

        dp.step2.addAllProducts();
        List<StepTwoAddedProduct> allProducts = dp.step2.getAllAddedProducts();

        System.out.println(allProducts.size());
        dp.step2.addAllColorsToEachProduct();


//        allProducts.get(0).selectAllColors();



//        String contents = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", allProducts.get(0).productColorBlock);
//        System.out.println(contents);

//        dp.gotoNextStep();
//        dp.step3.setCampaignName("javatest");
//        dp.step3.setCampaignUrl("javatest222");
//        dp.step3.publishCampaign();
//        dp.step3.loginForm.login();
    }
    
    @Test
    public void test2() {
        DesignerPage dp = PageBuilder.buildDesignerPage();
       
        dp.openUrl("https://dev.shirtee.de/designer/?id=1140/");
        

        dp.step1.fillProductText("TEST");
        dp.gotoNextStep();

        dp.step2.addAllProducts();
        List<StepTwoAddedProduct> allProducts = dp.step2.getAllAddedProducts();

        for (StepTwoAddedProduct item : allProducts) {
//            System.out.println(
//                    "Name: " + item.getProductName() + ";"
//                    + " Price: " + item.getSalesPrice() + ";"
//                    + " Total Profit: " + item.getProfit() + ";"
//                    + " Designer's profit: " + PriceHelper.getFormattedDouble( item.getProfit() / 100 * 30 ) + ";"
//                    + " Partner's profit: " + PriceHelper.getFormattedDouble( item.getProfit() / 100 * 70 )
//            );

            System.out.println(
                     item.getProductName() + ";"
                            + item.getSalesPrice() + ";"
                            + item.getProfit() + ";"
                            + PriceHelper.getFormattedDouble(item.getProfit() * 100 / item.getSalesPrice() ) + ";"
                            +  PriceHelper.getFormattedDouble( item.getProfit() / 100 * 30 ) + ";"
                            +  PriceHelper.getFormattedDouble( item.getProfit() / 100 * 70 )
            );
        }
       
    }

    @Test
    public void test3(){
        ProductPage productPage = PageBuilder.buildProductPage();
        productPage.openUrl("https://stage.shirtee.de/ffffffffffuuuuuuullllllll");

        for(int i = 1; i < productPage.getOtherProducts().size(); i++) {
            productPage.getOtherProducts().get(i).click();
            PopupHelper.waitProductPagePopupLoading();
            Wait.seconds(2);
            productPage.setRandomSizeAndGetSelected();
            productPage.addToCartAndStay();
        }



    }
}

