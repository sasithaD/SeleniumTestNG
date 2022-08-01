package PageObjects;

import Elements.PageElements;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelRequestPage extends TestBase {

    @FindBy(css = PageElements.MENU_TRAVEL_SELECTOR)
    WebElement menuTravel;

    @FindBy(xpath = PageElements.BTN_ASSIGN_TRAVEL_REQST)
    WebElement addTravelReqst;


    public void clickReportMenu() {
        clickOnElement(menuTravel);
    }

    public void scrollTillTravelMenu() {
        scrollUntilElementViewJS(menuTravel);
    }

    public void clickAddTravelRequest() {
        javaScriptClick(addTravelReqst);
    }

    public boolean searchWordInCSVFile(String csvPath, String searchText) {

        boolean foundText = false;
        List<String> csvContent = new ArrayList<>();

        try {
            List<String[]> csvResult = readCSV(csvPath, ',');

            csvResult.forEach(rowResults -> csvContent.addAll(Arrays.asList(rowResults)));

            foundText = csvContent.contains(searchText) || csvContent.stream().anyMatch(s -> s.contains(searchText));

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return foundText;
    }

}





