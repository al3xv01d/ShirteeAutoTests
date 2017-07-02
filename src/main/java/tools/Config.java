package tools;

public class Config {

    public static String browser = "chrome";

    private static boolean isLogged = false;
    private static String server; // dev, live
    private static String domain = "de";


    //************* ACCOUNTS AND PASSWORDS ***************** //

    public static String user_email = "akh@gomage.com";
    public static String user_pass = "gomage777";

    public static String admin_user = "";
    public static String admin_password = "";

    //************* SHIRTEE SHOP'S PAGES ***************** //

    public static String indexShirteeUrl;
    public static String shopUrl;
    public static String designerUrl;

    public static String testProductUrl_1;
    public static String testProductUrl_2;
    public static String testProductUrl_3;

    //************* ADMIN PAGES ***************** //

    public static String adminLoginPage;
    public static String adminOrdersPageUrl;

    //************* DASHBOARD PAGES ***************** //

    public static String dashboardIndexPage;


    /**
     * @param browser
     * @param locale - de or com
     * @param server
     * @param isLogged
     */
    public static void init(String browser, String locale, String server, boolean isLogged) {
        Config.browser = browser;
        Config.server = server;
        Config.domain = locale;
        Config.isLogged = isLogged;


        if(Config.server == "dev") {

            Config.server = "dev.";

            Config.indexShirteeUrl = "http://dev.shirtee." + Config.domain;
            Config.shopUrl = "http://dev.shirtee." + Config.domain + "/shop";
            Config.designerUrl = "http://dev.shirtee." + Config.domain + "/shop/designer/?id=1140/";

            Config.testProductUrl_1 = "http://dev.shirtee." + Config.domain + "/testdoenload";


            Config.adminLoginPage = "http://dev.shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "http://dev.shirtee.de/index.php/ffadmin/sales_order/";

            Config.dashboardIndexPage = "http://www.shirtee.de/dashboard/index/index/";


        } else if(Config.server == "live") {

            Config.indexShirteeUrl = "http://shirtee." + Config.domain;
            Config.shopUrl = "http://shirtee." + Config.domain + "/shop";
            Config.designerUrl = "http://shirtee." + Config.domain + "/shop/designer/?id=1140/";

            Config.testProductUrl_1 = "http://shirtee." + Config.domain + "/vatersohn";


            Config.adminLoginPage = "http://shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "http://shirtee.de/index.php/ffadmin/sales_order/";


        } else if(Config.server == "stage") {

            Config.indexShirteeUrl = "http://stage.shirtee." + Config.domain;
            Config.shopUrl = "http://stage.shirtee." + Config.domain + "/shop";
            Config.designerUrl = "http://shirtee." + Config.domain + "/shop/designer/?id=1140/";

            Config.testProductUrl_1 = "http://stage.shirtee." + Config.domain + "/test-download1/";


            Config.adminLoginPage = "http://stage.shirtee.de/index.php/ffadmin";
            Config.adminOrdersPageUrl = "http://stage.shirtee.de/index.php/ffadmin/sales_order/";
        }



    }
}
