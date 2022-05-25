package Tests;

import PageObjects.HomePage.HomePage;
import PageObjects.LoginPage.LoginPage;
import PageObjects.UserManagementPage.UserManagementPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestBase;

public class TestUserManagementPage extends TestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public UserManagementPage userManagementPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeMethod
    public void setupURL() throws InterruptedException {
        setupUrl();
        loginPage = new LoginPage();
        homePage = new HomePage();
        userManagementPage = new UserManagementPage();

        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginBtn();
        Thread.sleep(2000);
        homePage.selectOptionFromMainMenu("Admin");
    }

    @Test(priority = 1)
    public void verifyUserNameFilterIsWorking() {
        userManagementPage.enterUserName("Admin");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableUserName("Admin");
    }

    @Test(priority = 2)
    public void verifyUserRoleFilterIsWorking() {
        userManagementPage.selectUserRoleFromDropDown("ESS");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableUserRole("ESS");
    }

    @Test(priority = 3)
    public void verifyEmployeeNameFilterIsWorking() {
        userManagementPage.enterEmployeeName("Cassidy Hope");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableEmployeeName("Cassidy Hope");
    }

    @Test(priority = 4)
    public void verifyStatusFilterIsWorking() {
        userManagementPage.selectStatusFromDropDown("Disabled");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableStatus("Disabled");
    }

    @Test(priority = 5)
    public void verifyAllFiltersWorkingAtOneTime() {
        userManagementPage.enterUserName("Admin");
        userManagementPage.selectUserRoleFromDropDown("Admin");
        userManagementPage.enterEmployeeName("shamsa AL");
        userManagementPage.selectStatusFromDropDown("Enabled");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableUserName("Admin");
        userManagementPage.assertTableUserRole("Admin");
        userManagementPage.assertTableEmployeeName("shamsa AL");
        userManagementPage.assertTableStatus("Enabled");
    }

    @Test
    public void verifyDeleteButton() {
        userManagementPage.selectAndDisSelectTableCheckBox();
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
}
