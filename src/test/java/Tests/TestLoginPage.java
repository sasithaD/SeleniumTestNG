package Tests;

import PageObjects.LoginPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestBase;

public class TestLoginPage extends TestBase {

    public LoginPage loginPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeMethod
    public void setupURL() {
        setupUrl();
        loginPage = new LoginPage();
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginBtn();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }

    public void loginWithIncorrectUserName() {
        loginPage.enterUserName("Admin111");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginBtn();
        loginPage.assertInlineErrorMsg("Invalid credentials");
    }

    public void loginWithIncorrectPassword() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin");
        loginPage.clickLoginBtn();
        loginPage.assertInlineErrorMsg("Invalid credentials");
    }

    public void loginWithoutPassword() {
        loginPage.enterUserName("Admin");
        loginPage.clickLoginBtn();
        loginPage.assertInlineErrorMsg("Password cannot be empty");
    }

    public void loginWithoutUserName() {
        loginPage.enterPassword("admin123");
        loginPage.clickLoginBtn();
        loginPage.assertInlineErrorMsg("Username cannot be empty");
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
}
