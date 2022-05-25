package Tests;

import PageObjects.HomePage.HomePage;
import PageObjects.LoginPage.LoginPage;
import com.google.j2objc.annotations.Property;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestBase;

import java.util.List;
import java.util.Properties;

public class TestLoginPage extends TestBase {

    public LoginPage loginPage;
    public HomePage homePage;

    @BeforeSuite
    public void setupPreConditions() {

        TestBase.readPropertyFile();
        List<String> browsers = List.of(properties.getProperty("browser").split(","));
        if (browsers.size() > 0) {
            for (String browser : browsers) {
                setupPreRequisites(browser);
            }
        } else
            testBaseLogger.info("Unable to proceed without specific browser name in Config.properties file");
    }

    @BeforeMethod
    public void setupURL() {
        setupUrl();
        loginPage = new LoginPage();
        homePage = new HomePage();
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
