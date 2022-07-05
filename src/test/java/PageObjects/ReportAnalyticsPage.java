package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageElements;
import utils.TestBase;

public class ReportAnalyticsPage extends TestBase {

    @FindBy(css = PageElements.PARTICIPATION_SESSION_INFO_BTN_SELECTOR)
    WebElement participationSessionInfoBtn;

    @FindBy(xpath = PageElements.ROWS_PER_PAGE_DROPDOWN_SELECTOR)
    WebElement rowsPerPageDropdown;

    @FindBy(xpath = PageElements.NEXT_PAGE_BTN_SELECTOR)
    WebElement nextPageBtn;

    @FindBy(css = PageElements.PAGINATION_SUMMARY_SELECTOR)
    WebElement paginationSummary;

    public ReportAnalyticsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickSessionInfoBtn() {
        waitUntilVisibilityOfElement(By.xpath(".reports-accordion-content-row:nth-child(1) div[data-test='reportItem3'] div"));
        clickOnElement(participationSessionInfoBtn);
    }

    public void selectRowsPerPage(int rowsPerPageCount) {
        waitUntilVisibilityOfElement(By.xpath("//*[@id='pim_report_table']"));
        clickOnElement(rowsPerPageDropdown);
        waitFor(1000);
        clickOnElement(driver.findElement(By.xpath("//*[contains(@id,'select-options')]//span[contains(text(),'" + rowsPerPageCount + "')]")));
    }

    public void assertMyNameIsPresentOrNot(int rowsPerPageCount, String name) {
        waitUntilVisibilityOfElement(By.xpath(PageElements.TABLE_SELECTOR));
        String summaryText = getElementText(paginationSummary);
        String[] summaryTextArray = summaryText.split("of ");
        int pageCount = Integer.valueOf(summaryTextArray[1]) / rowsPerPageCount;
        for (int j = 0; j < (pageCount + 1); j++) {
            for (int i = 0; i < rowsPerPageCount; i++) {
                scrollUntilElementViewJS(driver.findElement(By.cssSelector(".pagination .summary")));
                scrollUntilElementViewJS(driver.findElement(By.xpath("//*[@id='pim_report_table']//tbody//tr[" + (i + 1) + "]//td[1]//span")));
                if (getElementText(driver.findElement(By.xpath("//*[@id='pim_report_table']//tbody//tr[" + (i + 1) + "]//td[1]//span"))).equals(name)) {
                    assertFailure("", "", "My name cannot be present in the table");
                }
            }
            clickOnElement(nextPageBtn);
            waitUntilVisibilityOfElement(By.xpath(PageElements.TABLE_SELECTOR));
            selectRowsPerPage(rowsPerPageCount);
        }
    }
}
