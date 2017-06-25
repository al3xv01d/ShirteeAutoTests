import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {

    private static final Pattern ImgFolder = new Pattern(Main.class.getResource("images_icon.jpg"));
    private static final Pattern CreateFolder = new Pattern(Main.class.getResource("create_folder.jpg"));

    public static void main(String[] args) throws FindFailed {

        Screen screen = new Screen();

        screen.keyDown(KeyEvent.VK_WINDOWS);
        screen.keyDown(KeyEvent.VK_E);
        screen.keyUp(KeyEvent.VK_WINDOWS);
        screen.keyUp(KeyEvent.VK_E);

        screen.wait(ImgFolder.similar( (float) 0.90), 2).click();
        screen.wait(CreateFolder.similar( (float) 0.90), 2).click();

        screen.type("FUCKCKCKCK");
        screen.keyDown(KeyEvent.VK_ENTER);
        screen.keyUp(KeyEvent.VK_ENTER);

        System.out.println(generateString(new Random(), "abcdefghijklmnopqrstuvwxyz", 11));


    }

    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
