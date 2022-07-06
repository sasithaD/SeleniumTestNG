package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ReportAnalyticsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.IOException;

public class TestReportAnalyticsPage extends TestBase {

    public HomePage homePage;
    public ReportAnalyticsPage reportAnalyticsPage;
    public LoginPage loginPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeClass
    public void setupURL() {
        setupUrl();
        reportAnalyticsPage = new ReportAnalyticsPage();
        homePage = new HomePage();
        loginPage = new LoginPage();

        loginPage.loginToTheNewApplication(properties.getProperty("userName"), properties.getProperty("password"));
    }

    @Test
    public void verifyMyNameIsPresentOrNot() {
        homePage.clickReportAnalyticsBtn();
        reportAnalyticsPage.clickSessionInfoBtn();
        reportAnalyticsPage.selectRowsPerPage(20);
        reportAnalyticsPage.assertMyNameIsPresentOrNot(20, "Sasitha");
    }

    @Test
    public void test() throws IOException {
        System.out.println(readPDF("C:\\Users\\SasithaDilshan\\Downloads\\Attendance Sheets.pdf"));
        driver.quit();
    }
}
