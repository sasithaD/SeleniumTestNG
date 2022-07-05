package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageElements;
import utils.TestBase;

public class HomePage extends TestBase {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.WELCOME_TEXT_SELECTOR)
    WebElement welcomeText;

    @FindBy(xpath = PageElements.EMP_MANAGEMENT_MENU_BTN_SELECTOR)
    WebElement employeeManagementMenuBtn;

    @FindBy(css = PageElements.KEBAB_BTN_SELECTOR)
    WebElement kebabBtn;

    @FindBy(css = PageElements.MORE_QUALIFICATIONS_BTN_SELECTOR)
    WebElement moreQualificationBtn;

    @FindBy(css = PageElements.MORE_SKILLS_BTN_SELECTOR)
    WebElement moreSkillsBtn;

    @FindBy(xpath = PageElements.FOOTER_ELEMENT_SELECTOR)
    WebElement footerElement;

    @FindBy(xpath = PageElements.REPORT_ANALYTICS_MENU_BTN_SELECTOR)
    WebElement reportAnalyticsMenuBtn;


    public void selectOptionFromMainMenu(String option) {
        clickOnElement(driver.findElement(By.xpath("//*[@id='mainMenuFirstLevelUnorderedList']//b[contains(text(),'" + option + "')]")));
    }

    public void verifyWelcomeTextIsPresent() {
        if (!isElementPresentAndDisplay(welcomeText)) {
            assertFailure("", "", "Home page welcome text element is missing");
        }
    }

    public void clickEmployeeManagementMenuBtn() {
        clickOnElement(employeeManagementMenuBtn);
    }

    public void clickReportAnalyticsBtn() {
        clickOnElement(reportAnalyticsMenuBtn);
    }

    public void selectMoreItems() {
        waitUntilVisibilityOfElement(By.cssSelector(".expand-icon"));
        clickOnElement(kebabBtn);
        waitFor(3000);
        mouseMove(moreQualificationBtn);
        waitFor(2000);
        moveAndClick(moreSkillsBtn);
    }

    public void scrollForElementView() {
        waitUntilVisibilityOfElement(By.cssSelector(".expand-icon"));
        scrollUntilElementViewJS(footerElement);
        waitFor(2000);
    }
}
