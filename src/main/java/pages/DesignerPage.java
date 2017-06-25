package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.designer.StepOneBlock;
import pages_elements.designer.StepThreeBlock;
import pages_elements.designer.StepTwoBlock;


public class DesignerPage extends AbstractShirteePage {

    //******************* PAGE ELEMENTS ********************//

    public StepOneBlock step1 = new StepOneBlock();
    public StepTwoBlock step2 = new StepTwoBlock();
    public StepThreeBlock step3 = new StepThreeBlock();

    //*******************  LOCATORS ********************//

    @FindBy(id = "pd_gt_product")
    private WebElement nextStepBtn;

    //*******************  ACTIONS ********************//

    public void gotoNextStep() {
        nextStepBtn.click();
    }

}
