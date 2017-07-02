package pages.magento_admin;


import abstraction.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages_elements.admin.OrderLine;
import tools.Wait;

public class AdminOrdersPage extends AbstractPage {

    //*******************  LOCATORS ********************//

    private final String orderIdSearchField_lo = "sales_order_grid_filter_real_order_id";
    private final String searchButton_lo = "//td[@class=\"filter-actions a-right\"]/button[2]";

    private final String loadingPopUp_lo = "//*[@id='loading_mask_loader']";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = orderIdSearchField_lo)
    private WebElement orderIdSearchField;

    @FindBy(xpath = searchButton_lo)
    private WebElement searchButton;

    //*******************  ACTIONS ********************//

    /**
     * Always returns first order
     * @param orderId
     */
    public OrderLine findAndGetOrder(String orderId) {
        fillInputField(orderIdSearchField, orderId);
        searchButton.click();
        Wait.invisibility(loadingPopUp_lo);
        return new OrderLine();
    }

}
