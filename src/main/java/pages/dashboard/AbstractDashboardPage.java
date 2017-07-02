package pages.dashboard;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstraction.AbstractPage;
import tools.Wait;

public class AbstractDashboardPage extends AbstractPage {

    //*******************  LOCATORS ********************//

    private final String closePopUpBtn_lo = "//div[@class=\"event-popup-actions\"]/button";

    private final String openLocaleBtn_lo = "//div[@class=\"dashboard-header-lang\"]";
    private final String germanLocaleBtn_lo = "//div[@class=\"dashboard-header-lang\"]/div/div/a[1]";
    private final String englishLocaleBtn_lo = "//div[@class=\"dashboard-header-lang\"]/div/div/a[2]";

    private final String logoutBtn_lo = "//div[@class=\"dashboard-header-logout\"]/a";

    private final String loadingScreen_lo = "//div[@id=\"dashboard_info_popup-info\"]";
//div[@class="event-popup-placeholder"]
    //dashboard_info_popup-info
    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(xpath = closePopUpBtn_lo )
    protected WebElement closePopUpBtn;

    @FindBy(xpath = loadingScreen_lo )
    protected WebElement loadingScreen;

    @FindBy(xpath = openLocaleBtn_lo )
    protected WebElement openLocaleBtn;

    @FindBy(xpath = germanLocaleBtn_lo )
    protected WebElement germanLocaleBtn;

    @FindBy(xpath = englishLocaleBtn_lo )
    protected WebElement englishLocaleBtn;

    @FindBy(xpath = logoutBtn_lo )
    protected WebElement logoutBtn;

    //*******************  ACTIONS ********************//

    public void closePopUp() {

        if(isExist(closePopUpBtn)) {
            Wait.clickable(closePopUpBtn);
            closePopUpBtn.click();
            Wait.invisibility(loadingScreen_lo);
        }


    }

    public void setLocale(String locale) {
        switch (locale) {

            case "eng":
                if(this.driver.getCurrentUrl().contains("shirtee.de") ) {
                    openLocaleBtn.click();
                    englishLocaleBtn.click();
                }
                break;

            case "de":
                if(this.driver.getCurrentUrl().contains("shirtee.com") ) {
                    openLocaleBtn.click();
                    germanLocaleBtn.click();
                }
                break;
        }

    }

    public void logout() {
        logoutBtn.click();
    }





}
