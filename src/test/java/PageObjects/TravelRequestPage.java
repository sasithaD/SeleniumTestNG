package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageElements;
import utils.TestBase;

public class TravelRequestPage extends TestBase {

    @FindBy(css = PageElements.MENU_TRAVEL_SELECTOR)
    WebElement menuTravel;

    @FindBy(xpath = PageElements.BTN_ASSIGN_TRAVEL_REQST)
    WebElement addTravelReqst;


    public void clickReportMenu(){
        clickOnElement(menuTravel);
    }

    public void scrollTillTravelMenu(){
        scrollUntilElementViewJS(menuTravel);
    }

    public void clickAddTravelRequest(){
        javaScriptClick(addTravelReqst);
    }
}
