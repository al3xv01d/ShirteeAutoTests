package pages.magento_admin;

import abstraction.AbstractPage;
import tools.Config;

/**
 * Created by User on 02.07.2017.
 */
public class AdminFacade extends AbstractPage {

    public AdminOrdersPage ordersPage;
    public AdminLoginPage loginPage;

    public AdminFacade(AdminLoginPage loginPage, AdminOrdersPage ordersPage) {
        this.ordersPage = ordersPage;
        this.loginPage = loginPage;
    }

    public void openOrdersPage() {
        openUrl(Config.adminOrdersPageUrl);
    }
}
