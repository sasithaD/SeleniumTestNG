package Tests;

import PageObjects.SearchAndFilterPage;
import RetryAnalyzer.RetryAnalyzer;
import RetryAnalyzer.RetryTestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestBase;

@Listeners(RetryTestListener.class)

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
        searchAndFilterPage.searchForRandomItem("Employee Tasks");
        searchAndFilterPage.waitTillPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), "https://chamikag-trials7501.orangehrmlive.com/client/#/noncore/onboarding/viewEmployeeTasks/reset/1");
    }

    @Test
    public void searchForRandomItem() {
        searchAndFilterPage.searchForRandomItem("a");
        searchAndFilterPage.waitTillPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), "https://chamikag-trials7501.orangehrmlive.com/client/#/admin/systemUsers");
    }

    @Test (priority=1, retryAnalyzer = RetryAnalyzer.class)
    public void filterByEmployeeName() throws InterruptedException {

        String nm, fname, lname, fullname;
        searchAndFilterPage.clickMenuEmpManagement();
        searchAndFilterPage.waitTillFilterIcon();

        searchAndFilterPage.clickFilterBtn();
        waitFor(3000);
        searchAndFilterPage.typeEmployeeName("Brody Alan");
        waitFor(3000);
        searchAndFilterPage.clickOnSearch();
        waitFor(5000);
        searchAndFilterPage.waitTillEmpSearchResultTableForm();
        captureScreenshotOnFailure(driver, "screenshot_2");
        Assert.assertEquals(searchAndFilterPage.getEmpName(), "Brody Alann");
        nm = searchAndFilterPage.getEmpName();
        System.out.println("Emp name in table --> " + nm) ;
        searchAndFilterPage.clickOnResultTable();
        waitFor(1000);
        fname = searchAndFilterPage.getEmpFirstName();
        lname = searchAndFilterPage.getEmpLastName();
        fullname = fname + " " + lname;
        Assert.assertEquals(fullname, "Brody Alan");

    }

    @Test (priority=2)
    public void filterByEmployeeAllInfo() {

        searchAndFilterPage.clickMenuEmpManagement();
        searchAndFilterPage.waitTillFilterIcon();

        searchAndFilterPage.clickFilterBtn();
        waitFor(3000);
        searchAndFilterPage.typeEmployeeName("Brody Alan");
        waitFor(3000);
        searchAndFilterPage.selectSubUnit("QA Team");
        waitFor(3000);
        searchAndFilterPage.clickOnSearch();
        waitFor(5000);
        searchAndFilterPage.waitTillEmpSearchResultTableForm();
        Assert.assertEquals(searchAndFilterPage.getEmpName(), "Brody Alan");
        searchAndFilterPage.clickOnResultTable();
        waitFor(1000);
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
}
