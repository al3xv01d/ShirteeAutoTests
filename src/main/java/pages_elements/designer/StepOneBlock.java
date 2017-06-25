package pages_elements.designer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pages_elements.AbstractPageElement;

public class StepOneBlock extends AbstractPageElement{

    //*******************  LOCATORS ********************//

    private final String productTextTextarea_lo = "add_text_textarea";
    private final String addTextTab_lo = "pd_add_text";
    private final String addImgTab_lo = "pd_add_image";

    private final String fontSelector_lo = "font-selector";
    private final String productCategorySelector_lo = "category_selector";

    private final String uploadImageBtn_lo = "//div[@class=\"upload-image-drop-zone-text-3\"]/a";

    private final String colorItem_lo = "//div[@id=\"right-color-group\"]/span";

    private final String pricePerPiece_lo = "//span[@id=\"base_price\"]/span";


    //*******************  ELEMENTS ********************//

    @FindBy(id = productTextTextarea_lo)
    private WebElement productTextTextarea;

    @FindBy(id = addTextTab_lo)
    private WebElement addTextTab;

    @FindBy(id = addImgTab_lo)
    private WebElement addImgTab;

    @FindBy(xpath = uploadImageBtn_lo)
    private WebElement uploadImageBtn;

    @FindBy(id = fontSelector_lo)
    private WebElement fontSelector;

    @FindAll({@FindBy(xpath = colorItem_lo )})
    private WebElement allColorItems;

    @FindBy(xpath = pricePerPiece_lo)
    private WebElement pricePerPiece;


    //*******************  ACTIONS ********************//


    public void fillProductText(String text) {
        fillInputField(productTextTextarea, text);
    }

    public void uploadImage() {
        addImgTab.click();
        uploadImageBtn.click();

        Screen s = new Screen();

        try {

            Pattern imgFolder = new Pattern(getClass().getResource("/img_folder_2.jpg"));
            Pattern image = new Pattern(getClass().getResource("/20001x2001px.jpg"));


            s.wait(imgFolder.similar( (float) 0.90), 2).click();
            s.wait(image.similar( (float) 0.90), 2).doubleClick();
        } catch (FindFailed e){
            e.printStackTrace();
        }
    }

    public void selectFont(String font) {
        Select fontSelect = new Select(fontSelector);

        switch(font) {
            case "Agent Orange":
                fontSelect.selectByValue("Agent Orange");
                break;
            case "Allstar":
                fontSelect.selectByValue("Allstar");
                break;
            case "Brush Hand New":
                fontSelect.selectByValue("Brush Hand New");
                break;
            case "BrushSome":
                fontSelect.selectByValue("BrushSome");
                break;
            case "Canterbury":
                fontSelect.selectByValue("Canterbury");
                break;
            case "DejaVu Sans":
                fontSelect.selectByValue("DejaVu Sans");
                break;
            case "DejaVu Sans Mono":
                fontSelect.selectByValue("DejaVu Sans Mono");
                break;
            case "DejaVu Serif":
                fontSelect.selectByValue("DejaVu Serif");
                break;
            case "Florence":
                fontSelect.selectByValue("Florence");
                break;
            case "From Cartoon Blocks":
                fontSelect.selectByValue("From Cartoon Blocks");
                break;
            case "LDFComicSans":
                fontSelect.selectByValue("LDFComicSans");
                break;
            case "LeArchitect":
                fontSelect.selectByValue("LeArchitect");
                break;
            case "Open Sans":
                fontSelect.selectByValue("Open Sans");
                break;
            default:
                fontSelect.selectByIndex(0);
                break;
        }

    }

}
