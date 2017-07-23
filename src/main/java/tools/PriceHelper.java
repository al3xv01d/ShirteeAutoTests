package tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PriceHelper {

    public static double getRealPrice(String price) {

        String pattern = "[0-9]+[.,][0-9]+|[0-9]+";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(price);

        if ( m.find() ) {
            String doubleFormatPrice = m.group(0).replace(",", ".");
            return  Double.parseDouble(doubleFormatPrice);
        } else {
            System.out.println("PROBLEMS IN PRICE HELPER");
            return 0.0;
        }

    }

    public static double getFormattedDouble(double price) {

        double d2 = new BigDecimal(price).setScale(2, RoundingMode.CEILING).doubleValue();

        return d2;
    //    String formattedDouble = String.format("%.2f", price);
       // return  PriceHelper.getRealPrice(formattedDouble);
    }

}
