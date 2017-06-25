package tools;

public class Config {

    public static String browser = "chrome";

    private static boolean isLogged = false;
    private static String server = "dev.";
    private static String domain = "de";

    public final static String indexShirteeUrl = "http://" + Config.server + "shirtee." + Config.domain;
    public final static String shopUrl = "http://" + Config.server + "shirtee." + Config.domain + "/shop";
    public final static String designerUrl = "http://" + Config.server + "shirtee." + Config.domain + "/shop/designer/?id=1140/";

    /**
     * @param browser
     * @param locale - de or com
     * @param server
     * @param isLogged
     */
    public static void init(String browser, String locale, String server, boolean isLogged) {
        Config.browser = browser;
        Config.domain = locale;
        Config.server = server;
        Config.isLogged = isLogged;

    }
}
