package tools;

public class Config {

    public static String browser = "chrome";

    private static boolean isLogged = false;
    private static String server = "dev.";
    private static String locale = "de";

    public final String indexUrl = "http://" + Config.server + "shirtee." + Config.locale;
    public final String shopUrl = "http://" + Config.server + "shirtee." + Config.locale + "/shop";
    public final String designerUrl = "http://" + Config.server + "shirtee." + Config.locale + "/shop/designer/?id=1140/";

    public static void init() {

    }
}
