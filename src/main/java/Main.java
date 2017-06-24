import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.event.KeyEvent;

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


    }
}
