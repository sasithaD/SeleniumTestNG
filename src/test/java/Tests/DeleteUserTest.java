package Tests;

import PageObjects.DeleteUserPage;
import PageObjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.List;

public class DeleteUserTest extends TestBase {

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


    @BeforeMethod
    public void setupURL(){
        setupUrl();
        loginPage = new LoginPage();
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginBtn();

    }

    @Test
    public void deleteUser() throws InterruptedException {

        //Thread.sleep(2000);
        DeleteUserPage deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
        deleteUserPage.clickMenuAdmin();
        deleteUserPage.typeUsername("firefox2");
        deleteUserPage.clickSearchBtn();
        deleteUserPage.checkboxSelect();
        boolean isDeleteEnabled = deleteUserPage.isDeletebuttonEnabled();
        if(isDeleteEnabled == false) {
            System.out.println("Record is not selected to be deleted");
        } else {
            System.out.println("Record is selected to be deleted");
            deleteUserPage.clickDeleteBtn();
            deleteUserPage.clickDialogDeleteBtn();
        }
        deleteUserPage.typeUsername("firefox2");
        deleteUserPage.clickSearchBtn();
        String txt = deleteUserPage.clickOnNoDataRow();
        Assert.assertEquals(txt, "No Records Found");


    }
}
