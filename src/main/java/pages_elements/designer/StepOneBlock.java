package pages_elements.designer;
//import org.sikuli.script.Sikulix;
import org.jboss.netty.util.Timeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
import abstraction.AbstractPageElement;
import tools.PriceHelper;

import java.util.concurrent.TimeUnit;

public class StepOneBlock extends AbstractPageElement{

    //*******************  LOCATORS ********************//

    private final String productTextTextarea_lo = "add_text_textarea";
    private final String addTextTab_lo = "pd_add_text";
    private final String addImgTab_lo = "pd_add_image";

    private final String fontSelector_lo = "font-selector";
    private final String productCategorySelector_lo = "category_selector";

    private final String uploadImageBtn_lo = "//div[@class=\"upload-image-drop-zone-text-3\"]/a";

    private final String colorItem_lo = "//div[@id=\"right-color-group\"]/span";

    private final String pricePerPiece_lo = "//*[(@id=\"front_price\" or @id=\"back_price\" or @id=\"front_back_price\") and not(contains(@style,'display: none'))]/span";

    private final String frontSide_lo = "//ul[@class=\"pd_sides_list\"]/li[1]";
    private final String backSide_lo = "//ul[@class=\"pd_sides_list\"]/li[2]";

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

    @FindBy(xpath = frontSide_lo)
    private WebElement frontSide;

    @FindBy(xpath = backSide_lo)
    private WebElement backSide;


    //*******************  ACTIONS ********************//

    public double getPricePerPiece() {
        return PriceHelper.getRealPrice( pricePerPiece.getText() );
    }

    public void fillProductText(String text) {
        fillInputField(productTextTextarea, text);
    }

    public void clearProductText() {
        productTextTextarea.click();
        productTextTextarea.clear();
    }

//    public void uploadImage() {
//        addImgTab.click();
//        uploadImageBtn.click();
//
//        Screen s = new Screen();
//
//        try {
//
//            Pattern imgFolder = new Pattern(getClass().getResource("/img_folder_2.jpg"));
//            Pattern image = new Pattern(getClass().getResource("/20001x2001px.jpg"));
//
//
//            s.wait(imgFolder.similar( (float) 0.90), 2).click();
//            s.wait(image.similar( (float) 0.90), 2).doubleClick();
//        } catch (FindFailed e){
//            e.printStackTrace();
//        }
//    }

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

    public void showFrontSide() {
        frontSide.click();
    }

    public void showBackSide() {
        backSide.click();
    }

}
