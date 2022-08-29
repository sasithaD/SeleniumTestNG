package Tests;

import PageObjects.EmployeeManagementPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestBase;

public class TestEmployeeManagementPage extends TestBase {

    public HomePage homePage;
    public EmployeeManagementPage employeeManagementPage;
    public LoginPage loginPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeClass
    public void setupURL() {
        setupUrl();
        employeeManagementPage = new EmployeeManagementPage();
        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.loginToTheNewApplication(properties.getProperty("userName"), properties.getProperty("password"));
    }

    @Test
    public void verifyAddEmployeeFlow() {
        homePage.clickEmployeeManagementMenuBtn();
        employeeManagementPage.clickAddEmployeeBtn();
        employeeManagementPage.addEmployeeDetails();
    }

    @Test
    public void verifyAddingMoreItems() {
        homePage.selectMoreItems();
    }

    @Test
    public void scrollForElement() {
        homePage.scrollForElementView();
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
}
