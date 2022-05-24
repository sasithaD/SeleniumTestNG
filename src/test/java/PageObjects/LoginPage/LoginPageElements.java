package PageObjects.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class LoginPageElements extends TestBase {

    public LoginPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#txtUsername")
    WebElement userNameInput;

    @FindBy(css = "#txtPassword")
    WebElement passwordInput;

    @FindBy(css = "#btnLogin")
    WebElement loginBtn;

    @FindBy(css = "#spanMessage")
    WebElement errorMsg;

}
