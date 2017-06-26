package pages_elements.dashboard_campaigns;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.AbstractPageElement;

public class CampaignLine extends AbstractPageElement {

    //*******************  LOCATORS ********************//
    private String campaignLine_lo = "//tbody[@id=\"campaign_items_content\"]/tr[%d]";

    private String campaignTitle_lo = ".//div[@class=\"campaign-title\"]";

    private String deleteBtn_lo = ".//div[@class=\"buttons\"]/a[6]";

    private String statusBtn_lo = ".//div[@class=\"status\"]//label";

    //*******************  WEBDRIVER ELEMENTS ********************//

    private WebElement campaignLine;

    //*******************  CONSTRUCTOR ********************//

    public CampaignLine(int campaignLineNumber) {
        this.campaignLine = driver.findElement(By.xpath(String.format(campaignLine_lo, campaignLineNumber)));
    }

    //*******************  ACTIONS ********************//

    public String getCampaignTitle() {
        return this.campaignLine.findElement(By.xpath(campaignTitle_lo)).getText();
    }

    public void deleteCampaign() {
        this.campaignLine.findElement(By.xpath(deleteBtn_lo)).click();
    }

    public void toggleStatus() {
        this.campaignLine.findElement(By.xpath(statusBtn_lo));
    }
}
