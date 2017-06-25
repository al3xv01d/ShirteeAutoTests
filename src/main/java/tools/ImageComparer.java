package tools;

import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;

public class ImageComparer {

    public enum result {
        Matched,
        SizeMismatch,
        PixelMismatch
    }


    public static File captureElementPicture(WebElement element) throws Exception

    {

        // Get the WrapsDriver of the WebElement
        WrapsDriver wrapsDriver = (WrapsDriver) element;

        // Get the entire Screenshot from the driver of passed WebElement
        File screen = ((TakesScreenshot)
                wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);

        // Create an instance of Buffered Image from captured screenshot
        BufferedImage img = ImageIO.read(screen);

        // Get the Width and Height of the WebElement using getSize()
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        // Create a rectangle using Width and Height
        Rectangle rect = new Rectangle(width, height);

        // Get the Location of WebElement in a Point.
        // This will provide X & Y co-ordinates of the WebElement
        org.openqa.selenium.Point p = element.getLocation();

        // Create image by for element using its location and size.
        // This will give image data specific to the WebElement
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);

        // Write back the image data for element in File object
        ImageIO.write(dest, "png", screen);

        // Return the File object containing image data
        return screen;

    }


    public static result compareImage(String baseFile, String actualFile)

    {
        result compareResult = result.PixelMismatch;
        Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
        Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);

        try {

            PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
            PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);

            int[] baseImageData = null;
            int[] actualImageData = null;

            if (baseImageGrab.grabPixels()) {
                int width = baseImageGrab.getWidth();
                int height = baseImageGrab.getHeight();
                baseImageData = new int[width * height];
                baseImageData = (int[]) baseImageGrab.getPixels();
            }

            if (actualImageGrab.grabPixels()) {

                int width = actualImageGrab.getWidth();
                int height = actualImageGrab.getHeight();
                actualImageData = new int[width * height];
                actualImageData = (int[]) actualImageGrab.getPixels();

            }

            if ((baseImageGrab.getHeight() != actualImageGrab.getHeight())
                    || (baseImageGrab.getWidth() != actualImageGrab.getWidth()))
                compareResult = result.SizeMismatch;

            else if (java.util.Arrays.equals(baseImageData, actualImageData))
                compareResult = result.Matched;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return compareResult;

    }
}		

		

