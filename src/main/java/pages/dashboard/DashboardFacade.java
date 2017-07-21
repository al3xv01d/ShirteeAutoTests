package pages.dashboard;


import abstraction.AbstractPage;

public class DashboardFacade extends AbstractPage {

    public DashboardOrdersPage ordersPage;
    public DashboardPromotionPage promoPage;

    public DashboardFacade(DashboardOrdersPage ordersPage, DashboardPromotionPage promoPage) {

        this.ordersPage = ordersPage;
        this.promoPage = promoPage;

    }

}
