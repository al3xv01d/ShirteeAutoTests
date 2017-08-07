package pages_elements.designer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstraction.AbstractPageElement;
import tools.Wait;

public class StepThreeBlock extends AbstractPageElement{

    //*******************  BLOCK ELEMENTS ********************//

    public DesignerStepThreeLoginForm loginForm;

    //*******************  LOCATORS ********************//

    private final String campaignName_lo = "sales_name";
    private final String campaignUrl_lo = "sales_url";
    private final String publishCampaignBtn_lo = "pd_sales";


    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = campaignName_lo)
    private WebElement campaignName;

    @FindBy(id = campaignUrl_lo)
    private WebElement campaignUrl;

    @FindBy(id = publishCampaignBtn_lo)
    private WebElement publishCampaignBtn;

    //*******************  CONSTRUCTOR ********************//

    public StepThreeBlock(DesignerStepThreeLoginForm loginForm) {
        this.loginForm = loginForm;
    }

    //*******************  ACTIONS ********************//

    public void setCampaignName(String name) {
        fillInputField(campaignName, name);
    }

    public String getCampaignName() {
       // campaignName.click();
        //campaignName.sendKeys();

        return  campaignName.getText();//("innerText");
    }

    public void setCampaignUrl(String url) {
        fillInputField(campaignUrl, url);
    }

    public void publishCampaign() {
        Wait.visibility(publishCampaignBtn);
        Wait.clickable(publishCampaignBtn);
        publishCampaignBtn.click();

    }

}
