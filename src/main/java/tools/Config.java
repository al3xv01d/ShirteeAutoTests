package tools;
//*NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
public class Config {

    public static String browser = System.getProperty("browser");
    public static String server = System.getProperty("server"); // dev, live
    public static String domain = System.getProperty("domain");
    public static String isLogged = System.getProperty("isLogged");

//    public static String browser;
//    public static String server;
//    public static String domain;
//    public static String isLogged;

    // ************ SOME DATA *************************//

    public static String amountPromoCode = "?gs=11amount";
    public static String percentPromoCode = "?gs=2percent";

    public static double amountPromoValue = 7;
    public static double percentPromoValue = 30;

    public static double shippingPrice = 4.50;

    //************* ACCOUNTS AND PASSWORDS ***************** //

        // AUTO TESTER 1 //
    public static String tester1_email = "auto_tester_1@gomage.com";
    public static String tester1_pass = "test777";

    // AUTO TESTER 2 //
    public static String tester2_email = "auto_tester_2@gomage.com";
    public static String tester2_pass = "test777";

    // ADMIN ACCOUNT //
    public static String admin_user = "gomage";
    public static String admin_password = "";

    //************* SHIRTEE SHOP'S PAGES ***************** //

    public static String indexShirteeUrl;
    public static String shopUrl;
    public static String designerUrl;
    public static String checkoutUrl;

    public static String testProductUrl_1;
    public static String testProductUrl_2;

    public static String dashboardPromoPageUrl;
    public static String dashboardOrdersPage;


    //************* ADMIN PAGES ***************** //

    public static String adminLoginPage;
    public static String adminOrdersPageUrl;

    //************* DASHBOARD PAGES ***************** //

    public static String dashboardIndexPage;

    static {
        if(null == Config.browser) {
            System.out.println("You are in IDE");
            Config.browser = "chrome";
            Config.server = "live";
            Config.domain = "com";
            Config.isLogged = "no";
        }
    }

    public static void init() {

        if( Config.server.equals("live") ) {

            Config.indexShirteeUrl = "https://www.shirtee.com";
            Config.shopUrl = "https://shirtee.com/shop";
            Config.designerUrl = "https://www.shirtee.com/designer/?id=1140/";
            Config.checkoutUrl = "https://www.shirtee.com/checkout/onepage/";

            Config.testProductUrl_1 = "https://www.shirtee.com/auto-test-company-1/";
            Config.testProductUrl_2 = "https://www.shirtee.com/auto-test-company-2/";

            Config.dashboardOrdersPage = "https://www.shirtee.com/customdashboard/order/history/";
            Config.dashboardPromoPageUrl = "https://www.shirtee.com/promotion/dashboard/index/";

            Config.adminLoginPage = "https://shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "https://shirtee.de/index.php/ffadmin/sales_order/";



        } else if( Config.server.equals("dev") ) {

            Config.indexShirteeUrl = "https://dev.shirtee.com";
            Config.shopUrl = "https://dev.shirtee.com/" + Config.domain + "/shop";
            Config.designerUrl = "https://dev.shirtee.com/" + Config.domain + "/designer/?id=1140/";
            Config.checkoutUrl = "https://dev.shirtee.com/" + Config.domain + "checkout/onepage/";

            Config.testProductUrl_1 = "https://dev.shirtee.com/auto-test-company-1/";

            Config.dashboardOrdersPage = "https://dev.shirtee.com/customdashboard/order/history/";
            Config.dashboardPromoPageUrl = "https://dev.shirtee.com/promotion/dashboard/index/";

            Config.adminLoginPage = "https://dev.shirtee.com/index.php/ffadmin";
            Config.adminOrdersPageUrl = "https://dev.shirtee.com/index.php/ffadmin/sales_order/";




        } else if( Config.server.equals("stage") ) {

            Config.indexShirteeUrl = "https://stage.shirtee.de";
            Config.shopUrl = "https://stage.shirtee.de/shop";
            Config.designerUrl = "https://stage.shirtee.de/shop/designer/?id=1140/";
            Config.checkoutUrl = "https://stage.shirtee.de/checkout/onepage/";

            Config.testProductUrl_1 = "https://stage.shirtee.de/auto-test-company-1/";

            Config.dashboardOrdersPage = "https://stage.shirtee.de/customdashboard/order/history/";
            Config.dashboardPromoPageUrl = "https://stage.shirtee.de/promotion/dashboard/index/";

            Config.adminLoginPage = "https://stage.shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "https://stage.shirtee.de/index.php/ffadmin/sales_order/";
        }



    }
}
