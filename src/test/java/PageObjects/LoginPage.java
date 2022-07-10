package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Elements.PageElements;
import utils.TestBase;

public class LoginPage extends TestBase {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.USERNAME_SELECTOR)
    WebElement userNameInput;

    @FindBy(css = PageElements.PASSWORD_SELECTOR)
    WebElement passwordInput;

    @FindBy(css = PageElements.LOGIN_BTN_SELECTOR)
    WebElement loginBtn;

    @FindBy(css = PageElements.ERROR_MSG_SELECTOR)
    WebElement errorMsg;

    @FindBy(css = PageElements.NEW_LOGIN_BTN_SELECTOR)
    WebElement newLoginBtn;

    public void enterUserName(String userName) {
        typeOnElement(userNameInput, userName);
    }

    public void enterPassword(String password) {
        typeOnElement(passwordInput, password);
    }

    public void clickLoginBtn() {
        clickOnElement(loginBtn);
    }

    public void clickNewLoginBtn() {
        clickOnElement(newLoginBtn);
    }

    public void loginToTheApplication(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginBtn();
    }

    public void loginToTheNewApplication(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickNewLoginBtn();
    }

    public void assertInlineErrorMsg(String expectedErrorMsg) {
        String actualErrorMsg = getElementText(errorMsg);
        if (!expectedErrorMsg.equals(actualErrorMsg)) {
            assertFailure(actualErrorMsg, expectedErrorMsg, "Error message incorrect, Expected value : " + expectedErrorMsg + " but Actual value: " + actualErrorMsg + "");
        }
    }
}
