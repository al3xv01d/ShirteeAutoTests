package pages;

import abstraction.AbstractShirteePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.designer.DesignerValidation;
import pages_elements.designer.StepOneBlock;
import pages_elements.designer.StepThreeBlock;
import pages_elements.designer.StepTwoBlock;
import tools.Wait;


public class DesignerPage extends AbstractShirteePage {

    //******************* PAGE ELEMENTS ********************//

    public StepOneBlock step1;
    public StepTwoBlock step2;
    public StepThreeBlock step3;
    public DesignerValidation validation;

    //*******************  LOCATORS ********************//

    private final String nextStepBtn_lo = "pd_gt_product";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = nextStepBtn_lo)
    private WebElement nextStepBtn;

    //******************* CONSTRUCTOR ********************//

    public DesignerPage(StepOneBlock step1, StepTwoBlock step2, StepThreeBlock step3, DesignerValidation validation) {

        this.step1 = step1;
        this.step2 = step2;
        this.step3 = step3;
        this.validation = validation;
    }


    //*******************  ACTIONS ********************//

    public void gotoNextStep() {
        Wait.visibility(nextStepBtn);
        nextStepBtn.click();
    }

    public boolean isLoginFormVisible() {
      Wait.seconds(1);
      return isExistsAndVisible(driver.findElement(By.xpath("//form[@id=\"login-form\"]")));
    }

}
