package PageObjects.LoginPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestBase;

public class LoginPage extends TestBase {

    private LoginPageElements loginPageElements;

    public LoginPage() {
        this.loginPageElements = new LoginPageElements();
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

    public void loginToTheApplication(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginBtn();
    }

    public void assertInlineErrorMsg(String expectedErrorMsg) {
        String actualErrorMsg = getElementText(loginPageElements.errorMsg);
        if (!expectedErrorMsg.equals(actualErrorMsg)) {
            assertFailure(actualErrorMsg, expectedErrorMsg, "Error message incorrect, Expected value : " + expectedErrorMsg + " but Actual value: " + actualErrorMsg + "");
        }
    }
}
