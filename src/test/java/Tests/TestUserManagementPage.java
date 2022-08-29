package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.UserManagementPage;
import org.testng.annotations.*;
import utils.TestBase;

public class TestUserManagementPage extends TestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public UserManagementPage userManagementPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeClass
    public void setupURL() {
        setupUrl();
        loginPage = new LoginPage();
        homePage = new HomePage();
        userManagementPage = new UserManagementPage();

        loginPage.loginToTheApplication(properties.getProperty("userName"), properties.getProperty("password"));
        homePage.selectOptionFromMainMenu("Admin");
    }

    @Test(priority = 1)
    public void verifyUserNameFilterIsWorking() {
        userManagementPage.enterUserName("Admin");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableUserName("Admin");
        userManagementPage.clickResetBtn();
    }

    @Test(priority = 2)
    public void verifyUserRoleFilterIsWorking() {
        userManagementPage.selectUserRoleFromDropDown("ESS");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableUserRole("ESS");
        userManagementPage.clickResetBtn();
    }

    @Test(priority = 3)
    public void verifyEmployeeNameFilterIsWorking() {
        userManagementPage.enterEmployeeName("Cassidy Hope");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableEmployeeName("Cassidy Hope");
        userManagementPage.clickResetBtn();
    }

    @Test(priority = 4)
    public void verifyStatusFilterIsWorking() {
        userManagementPage.selectStatusFromDropDown("Disabled");
        userManagementPage.clickSearchUserBtn();
        userManagementPage.assertTableStatus("Disabled");
        userManagementPage.clickResetBtn();
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

    @Test(priority = 6)
    public void verifyDeleteButtonActions() {
        userManagementPage.verifyDeleteButtonIsClickable();
    }

    @Test(priority = 7)
    public void verifyUserTable() {
        userManagementPage.verifyTableColumns("Username");
        userManagementPage.verifyTableColumns("User Role");
        userManagementPage.verifyTableColumns("Employee Name");
        userManagementPage.verifyTableColumns("Status");
    }

    @AfterClass
    public void closeWebDriver() {
        driver.quit();
    }
}
