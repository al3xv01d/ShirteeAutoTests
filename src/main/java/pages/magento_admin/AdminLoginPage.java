package pages.magento_admin;


import abstraction.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.Config;

public class AdminLoginPage extends AbstractPage{

    private final String loginField_lo = "username";
    private final String passwordField_lo = "login";

    @FindBy(id = loginField_lo)
    private WebElement loginField;

    @FindBy(id = passwordField_lo)
    private WebElement passwordField;

    public void login() {
        fillInputField(loginField, Config.admin_user);
        fillInputField(passwordField, Config.admin_password);
        passwordField.submit();
    }


}
