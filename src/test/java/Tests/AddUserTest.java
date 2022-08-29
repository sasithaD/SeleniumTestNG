package Tests;

import Model.User;
import PageObjects.AddUserPage;
import DataProvider.TestDataProvider;
import PageObjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestBase;

import java.util.List;


public class AddUserTest extends TestBase{

    public LoginPage loginPage;


    @BeforeSuite
    public void setupPreConditions() {

        TestBase.readPropertyFile();
        List<String> browserList = List.of(properties.getProperty("browser").split(","));
        if (browserList.size() > 0) {
            for (String browser : browserList) {
                setupPreRequisitesWithBrowserList(browser);
            }
        } else
            testBaseLogger.info("Unable to proceed without specific browser name in Config.properties file");
    }


    @BeforeClass
    public void setupURL() {
        setupUrl();
        loginPage = new LoginPage();
        loginPage.loginToTheApplication(properties.getProperty("userName"), properties.getProperty("password"));
    }


    //@Test(dataProvider="addEmployee")
    @Test(dataProvider = "addEmployee", dataProviderClass = TestDataProvider.class)
    public void addUser(String empNme, String username, String password, String conPassword, String empRole, String empStatus)  {
        AddUserPage addUserPage = PageFactory.initElements(driver, AddUserPage.class);
        addUserPage.clickMenuAdmin();
        addUserPage.clickAddEmployee();
        addUserPage.waitUntilForm();
        addUserPage.selectEmployeeRole(empRole);
        addUserPage.typeEmpName(empNme);
        addUserPage.typeEmployeeNameUsername(username);
        addUserPage.selectEmployeeStatus(empStatus);
        addUserPage.typeEmployeePassword(password);
        addUserPage.typeEmployeeConfirmPassword(conPassword);
        addUserPage.waitUntilSave();
        addUserPage.saveEmployee();
        addUserPage.waitUntilMenu();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
        System.out.println("Emp added successfully --> " + driver.getCurrentUrl());

    }


/*
    @AfterSuite
    public void closeWebDriver() {
        driver.close();
    }*/
}
