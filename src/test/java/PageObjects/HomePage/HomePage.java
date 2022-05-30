package PageObjects.HomePage;

import org.openqa.selenium.By;
import utils.TestBase;

public class HomePage extends TestBase {

    private HomePageElements homePageElements;

    public HomePage() {
        this.homePageElements = new HomePageElements();
    }

    public void selectOptionFromMainMenu(String option) {
        clickOnElement(driver.findElement(By.xpath("//*[@id='mainMenuFirstLevelUnorderedList']//b[contains(text(),'" + option + "')]")));
    }

    public void verifyWelcomeTextIsPresent() {
        if (!isElementPresentAndDisplay(homePageElements.welcomeText)) {
            assertFailure("", "", "Home page welcome text element is missing");
        }
    }
}
