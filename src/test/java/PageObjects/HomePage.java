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
}
