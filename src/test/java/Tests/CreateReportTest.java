package Tests;

import PageObjects.CreateReportPage;
import PageObjects.SearchAndFilterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestBase;



public class CreateReportTest extends TestBase {

    public CreateReportPage createReportPage;
    public SearchAndFilterPage searchAndFilterPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeTest
    public void setupURL(){
        createReportPage = PageFactory.initElements(driver, CreateReportPage.class);
        searchAndFilterPage = PageFactory.initElements(driver, SearchAndFilterPage.class);
        setupUrl();
        searchAndFilterPage.loginToTheApplication(properties.getProperty("userName"), properties.getProperty("password"));

    }

    @Test
    public void createNewReport(){
        createReportPage.clickReportMenu();
        waitFor(5000);
        createReportPage.clickNewReport();
        createReportPage.clickAddReport();
        waitFor(8000);
        createReportPage.sendReportName("New Report 19");
        waitFor(3000);
        createReportPage.clickNext();
        createReportPage.checkEmployeeName();
        createReportPage.checkEmployeeGender();
        createReportPage.checkEmploymentStatus();
        createReportPage.checkEmployeeJobTitle();
        waitFor(3000);
        createReportPage.clickNext();
        createReportPage.clickFieldGroup();
        waitFor(3000);
        createReportPage.selectItemPersonalfromDropdown();
        createReportPage.clickFieldEmpID();
        createReportPage.clickFieldEmpName();
        createReportPage.clickFieldEmpGender();
        createReportPage.clickFieldGroup();
        waitFor(3000);
        createReportPage.selectJobFromDropdown();
        createReportPage.clickFieldEmpStatus();
        createReportPage.clickFieldJobTitle();
        createReportPage.clickSave();
        waitFor(10000);
        createReportPage.choseEmployeeStatus("Full-Time Permanent");
        createReportPage.choseJobTitle("Software Development Manager");
        createReportPage.clickGenerate();
        waitFor(1000);
        createReportPage.isOwnNameOnGeneratedReport("Chamika");


    }


}
