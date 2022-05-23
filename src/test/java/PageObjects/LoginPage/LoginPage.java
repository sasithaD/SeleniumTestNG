package PageObjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    public WebDriver driver;
    private LoginPageElements loginPageElements;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.loginPageElements = new LoginPageElements(driver);
    }

    public void enterUserName(String userName) {
        loginPageElements.userNameInput.clear();
        loginPageElements.userNameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        loginPageElements.passwordInput.clear();
        loginPageElements.passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginPageElements.loginBtn.click();
    }

    public void assertInlineErrorMsg(String expectedErrorMsg) {
        String actualErrorMsg = loginPageElements.errorMsg.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
