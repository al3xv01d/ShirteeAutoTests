package pages_elements.designer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstraction.AbstractPageElement;
import tools.Config;
import tools.Wait;

/**
 * Created by User on 26.06.2017.
 */
public class DesignerStepThreeLoginForm extends AbstractPageElement {

    //*******************  LOCATORS ********************//

    private final String loginForm_lo = "login-form";
    private final String emailField_lo = "email";
    private final String passwordField_lo = "pass";
    private final String loginBtn_lo = "customer-login-btn";

    //*******************  WEBDRIVER ELEMENTS ********************//

    @FindBy(id = loginForm_lo)
    private WebElement loginForm;

    @FindBy(id = emailField_lo)
    private WebElement emailField;

    @FindBy(id = passwordField_lo)
    private WebElement passwordField;

    @FindBy(id = loginBtn_lo)
    private WebElement loginBtn;


    //*******************  ACTIONS ********************//

    public boolean isLoginFormVisible() {
        return isExistsAndVisible(loginForm);
    }

    public void login() {
        Wait.visibility(emailField);

        fillInputField(emailField, Config.user_email);
        fillInputField(passwordField, Config.user_pass);
        loginBtn.click();
    }
}
