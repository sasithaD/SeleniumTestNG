package PageObjects.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class HomePageElements extends TestBase {

    public HomePageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#welcome")
    WebElement welcomeText;
}
