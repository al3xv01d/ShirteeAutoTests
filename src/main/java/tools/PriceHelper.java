package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PriceHelper {

    public static double getRealPrice(String price) {

        String pattern = "[0-9]+[.,][0-9]+";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);

        if ( m.find() ) {
            String doubleFormatPrice = m.group(0).replace(",", ".");
            return  Double.parseDouble(doubleFormatPrice);
        } else {
            return 0.0;
        }
    }
}
