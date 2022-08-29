package Tests;

import PageObjects.SearchAndFilterPage;
import PageObjects.TravelRequestPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.FileNotFoundException;

public class TravelRequestTest extends TestBase {

    public TravelRequestPage travelRequestPage;
    public SearchAndFilterPage searchAndFilterPage;

/*    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeTest
    public void setupURL(){
        travelRequestPage = PageFactory.initElements(driver, TravelRequestPage.class);
        searchAndFilterPage = PageFactory.initElements(driver, SearchAndFilterPage.class);
        setupUrl();
        searchAndFilterPage.loginToTheApplication(properties.getProperty("userName"), properties.getProperty("password"));

    }*/

    @Test
    public void createTravelRequest(){
        travelRequestPage.scrollTillTravelMenu();
        travelRequestPage.clickReportMenu();
        waitFor(10000);
        //waitUntilVisibilityOfElement(By.xpath("//a[@id='addItemBtn']"));
        travelRequestPage.clickAddTravelRequest();
    }

    @Test
    public void readCSVFile() throws FileNotFoundException {

        travelRequestPage = PageFactory.initElements(driver, TravelRequestPage.class);
        boolean hasName = travelRequestPage.searchWordInCSVFile("src/main/resources/data/Attendance_Sheet.csv" , "Chamika");
        Assert.assertEquals(hasName, false, "Searched string is included in the CSV report");

    }
}
