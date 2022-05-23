package PageObjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    public WebDriver driver;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
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
