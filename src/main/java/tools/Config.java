package tools;

public class Config {

    public static String browser = "chrome";

    public static boolean isLogged = false;
    private static String server; // dev, live
    public static String domain = "de";

    // ************ SOME DATA *************************//

    public static String amountPromoCode = "?gs=11amount";
    public static String percentPromoCode = "?gs=2percent";

    public static double amountPromoValue = 7;
    public static double percentPromoValue = 30;

    public static double shippingPrice = 4.50;

    //************* ACCOUNTS AND PASSWORDS ***************** //

        // AUTO TESTER 1 //
    public static String user_email = "auto_tester_1@gomage.com";
    public static String user_pass = "test777";

    // ADMIN ACCOUNT //
    public static String admin_user = "gomage";
    public static String admin_password = "";

    //************* SHIRTEE SHOP'S PAGES ***************** //

    public static String indexShirteeUrl;
    public static String shopUrl;
    public static String designerUrl;
    public static String checkoutUrl;

    public static String testProductUrl_1;

    public static String dashboardPromoPageUrl;
    public static String dashboardOrdersPage;


    //************* ADMIN PAGES ***************** //

    public static String adminLoginPage;
    public static String adminOrdersPageUrl;

    //************* DASHBOARD PAGES ***************** //

    public static String dashboardIndexPage;


    /**
     * @param browser
     * @param domain - de or com
     * @param server
     * @param isLogged
     */
    public static void init(String browser, String domain, String server, boolean isLogged) {
        Config.browser = browser;
        Config.server = server;
        Config.domain = domain;
        Config.isLogged = isLogged;


        if(Config.server == "live") {

            Config.indexShirteeUrl = "http://shirtee." + Config.domain;
            Config.shopUrl = "http://shirtee." + Config.domain + "/shop";
            Config.designerUrl = "https://www.shirtee." + Config.domain + "/designer/?id=1140/";
            Config.checkoutUrl = "https://www.shirtee." + Config.domain + "/checkout/onepage/";

            Config.testProductUrl_1 = "https://www.shirtee." + Config.domain + "/auto-test-company-1//";

            Config.dashboardOrdersPage = "https://www.shirtee.de/customdashboard/order/history/";
            Config.dashboardPromoPageUrl = "https://www.shirtee.de/promotion/dashboard/index/";

            Config.adminLoginPage = "http://shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "http://shirtee.de/index.php/ffadmin/sales_order/";



        } else if(Config.server == "dev") {

            Config.server = "dev.";

            Config.indexShirteeUrl = "http://dev.shirtee." + Config.domain;
            Config.shopUrl = "http://dev.shirtee." + Config.domain + "/shop";
            Config.designerUrl = "https://dev.shirtee." + Config.domain + "/shop/designer/?id=1140/";

            Config.testProductUrl_1 = "http://dev.shirtee." + Config.domain + "/auto-test-company-1/";

            Config.dashboardOrdersPage = "https://dev.shirtee.de/customdashboard/order/history/";


            Config.adminLoginPage = "http://dev.shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "http://dev.shirtee.de/index.php/ffadmin/sales_order/";




        } else if(Config.server == "stage") {

            Config.indexShirteeUrl = "http://stage.shirtee." + Config.domain;
            Config.shopUrl = "http://stage.shirtee." + Config.domain + "/shop";
            Config.designerUrl = "http://stage.shirtee." + Config.domain + "/shop/designer/?id=1140/";

            Config.testProductUrl_1 = "http://stage.shirtee." + Config.domain + "/test-download1/";


            Config.adminLoginPage = "http://stage.shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "http://stage.shirtee.de/index.php/ffadmin/sales_order/";
        }



    }
}
