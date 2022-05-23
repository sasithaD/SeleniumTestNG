package PageObjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.TestBase;

public class LoginPage extends TestBase {

    public WebDriver driver;
    private LoginPageElements loginPageElements;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.loginPageElements = new LoginPageElements(driver);
    }

    public void enterUserName(String userName) {
        typeOnElement(loginPageElements.userNameInput, userName);
    }

    public void enterPassword(String password) {
        typeOnElement(loginPageElements.passwordInput, password);
    }

    public void clickLoginBtn() {
        clickOnElement(loginPageElements.loginBtn);
    }

    public void assertInlineErrorMsg(String expectedErrorMsg) {
        String actualErrorMsg = getElementText(loginPageElements.errorMsg);
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
