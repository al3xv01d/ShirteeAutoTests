package designer;

import abstraction.AbstractTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import pages.IndexPage;
import tools.Driver;
import tools.ImageComparer;

import java.io.File;


public class TestSikuli extends AbstractTest {

    @Test
    public void saveIMG() {
        IndexPage pp = new IndexPage();
        pp.openUrl("https://www.shirtee.com/designer/?id=4528");


        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id='pd_container']"));

        try {
            FileUtils.copyFile(ImageComparer.captureElementPicture(element), new File("src/main/resources/fuck.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void compareIMG() {



        IndexPage pp = new IndexPage();
        pp.openUrl("https://www.shirtee.com/designer/?id=4528");
      //  DesignerPage dp = new DesignerPage();

        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id='pd_container']"));


        try
        {
            FileUtils.copyFile(ImageComparer.captureElementPicture(element), new File("initial.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        softAssert.assertEquals(ImageComparer.compareImage("initial.png", "src/main/resources/fuck.png"),
                ImageComparer.result.Matched, "FUCKCKCKCKCKKCKCKC");

        softAssert.assertAll();

    }





}



