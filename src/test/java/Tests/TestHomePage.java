package Tests;

import PageObjects.HomePage.HomePage;
import PageObjects.LoginPage.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestBase;

public class TestHomePage extends TestBase {

    public HomePage homePage;
    public LoginPage loginPage;

    @BeforeSuite
    public void setupPreConditions() {
        //setupPreRequisites();
    }

    @BeforeMethod
    public void setupURL() throws InterruptedException {
        setupUrl();
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginBtn();
        Thread.sleep(2000);
        homePage.selectOptionFromMainMenu("Admin");
    }

    @Test(priority = 1)
    public void verifyUserNameFilterIsWorking() {
        homePage.enterUserName("Admin");
        homePage.clickSearchUserBtn();
        homePage.assertTableUserName("Admin");
    }

    @Test(priority = 2)
    public void verifyUserRoleFilterIsWorking() {
        homePage.selectUserRoleFromDropDown("ESS");
        homePage.clickSearchUserBtn();
        homePage.assertTableUserRole("ESS");
    }

    @Test(priority = 3)
    public void verifyEmployeeNameFilterIsWorking() {
        homePage.enterEmployeeName("Cassidy Hope");
        homePage.clickSearchUserBtn();
        homePage.assertTableEmployeeName("Cassidy Hope");
    }

    @Test(priority = 4)
    public void verifyStatusFilterIsWorking() {
        homePage.selectStatusFromDropDown("Disabled");
        homePage.clickSearchUserBtn();
        homePage.assertTableStatus("Disabled");
    }

    @Test(priority = 5)
    public void verifyAllFiltersWorkingAtOneTime() {
        homePage.enterUserName("Admin");
        homePage.selectUserRoleFromDropDown("Admin");
        homePage.enterEmployeeName("shamsa AL");
        homePage.selectStatusFromDropDown("Enabled");
        homePage.clickSearchUserBtn();
        homePage.assertTableUserName("Admin");
        homePage.assertTableUserRole("Admin");
        homePage.assertTableEmployeeName("shamsa AL");
        homePage.assertTableStatus("Enabled");
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
}
