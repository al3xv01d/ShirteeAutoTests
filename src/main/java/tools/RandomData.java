package tools;

import java.util.Random;

/**
 * Created by User on 25.06.2017.
 */
public class RandomData {

    private static String letters = "abcdefghijklmnopqrstuvwxyz";

    public static String getRandomName() {
        return "AutoJT_name_" + RandomData.generateRandomString(10) ;
    }

    public static int getRandomInt(int a, int b) {
        //from a to b
        return a + (int) (Math.random() * b);
    }


    private static String generateRandomString(int length)
    {
        Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = letters.charAt(random.nextInt(letters.length()));
        }
        return new String(text);
    }



}
