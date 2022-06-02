package Tests;

import PageObjects.HomePage.HomePage;
import PageObjects.LoginPage.LoginPage;
import PageObjects.SearchAndFilterPage.SearchAndFilterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestBase;

public class SearchAndFilterTest extends TestBase {

    public SearchAndFilterPage searchAndFilterPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeTest
    public void setupURL(){
        searchAndFilterPage = PageFactory.initElements(driver, SearchAndFilterPage.class);
        setupUrl();
        searchAndFilterPage.loginToTheApplication(properties.getProperty("userName"), properties.getProperty("password"));
        searchAndFilterPage.waitTillPageLoad();
    }

    @Test
    public void searchForItem() {
        searchAndFilterPage = PageFactory.initElements(driver, SearchAndFilterPage.class);
        searchAndFilterPage.searchForRandomItem("Employee Tasks");
        searchAndFilterPage.waitTillPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), "https://chamikag-trials7501.orangehrmlive.com/client/#/noncore/onboarding/viewEmployeeTasks/reset/1");
    }

    @Test
    public void searchForRandomItem() {
        searchAndFilterPage = PageFactory.initElements(driver, SearchAndFilterPage.class);
        searchAndFilterPage.searchForRandomItem("a");
        searchAndFilterPage.waitTillPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), "https://chamikag-trials7501.orangehrmlive.com/client/#/admin/systemUsers");
    }

    @Test
    public void filterByEmployee() {
        searchAndFilterPage = PageFactory.initElements(driver, SearchAndFilterPage.class);
        searchAndFilterPage.clickMenuEmpManagement();
        searchAndFilterPage.waitTillFilterIcon();
        searchAndFilterPage.clickFilterBtn();
        searchAndFilterPage.waitTillEmpSearchForm();
        //searchAndFilterPage.waitTillPageLoad();
        //Assert.assertEquals(driver.getCurrentUrl(), "https://chamikag-trials7501.orangehrmlive.com/client/#/admin/systemUsers");
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
}
