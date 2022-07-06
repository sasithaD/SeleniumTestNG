package Tests;

import PageObjects.SearchAndFilterPage;
import PageObjects.TravelRequestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestBase;

public class TravelRequestTest extends TestBase {

    public TravelRequestPage travelRequestPage;
    public SearchAndFilterPage searchAndFilterPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeTest
    public void setupURL(){
        travelRequestPage = PageFactory.initElements(driver, TravelRequestPage.class);
        searchAndFilterPage = PageFactory.initElements(driver, SearchAndFilterPage.class);
        setupUrl();
        searchAndFilterPage.loginToTheApplication(properties.getProperty("userName"), properties.getProperty("password"));

    }

    @Test
    public void createTravelRequest(){
        travelRequestPage.scrollTillTravelMenu();
        travelRequestPage.clickReportMenu();
        //waitFor(10000);
        waitUntilVisibilityOfElement(By.xpath("//a[@id='addItemBtn']"));
        travelRequestPage.clickAddTravelRequest();
    }
}
