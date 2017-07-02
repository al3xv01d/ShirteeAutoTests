package tools;

import java.util.Random;

/**
 * Created by User on 25.06.2017.
 */
public class RandomData {

    private static String letters = "abcdefghijklmnopqrstuvwxyz";

    public static String getRandomString_dontuse() {
        return "AutoJT_name_" + RandomData.generateRandomString(10) ;
    }

    public static int getRandomInt(int a, int b) {
        //from a to b
        return a + (int) (Math.random() * b);
    }


    public static String generateRandomString(int length)
    {
        Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = letters.charAt(random.nextInt(letters.length()));
        }
        return new String(text);
    }

    public static String getRandomEmail() {
        return "JAT_" + generateRandomString(5) + "@" + generateRandomString(5) + ".com";
    }



}
