package Tests;

import PageObjects.GreenKartCartPage;
import PageObjects.GreenKartHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestBase;

public class GreenKartTest extends TestBase {

    public GreenKartHomePage greenKartHomePage;
    public GreenKartCartPage greenKartCartPage;

    @BeforeSuite
    public void setupPreConditions() {
        setupPreRequisites();
    }

    @BeforeClass
    public void setupURL() {
        setupUrl();
        greenKartHomePage = new GreenKartHomePage();
        greenKartCartPage = new GreenKartCartPage();
    }

    @Test
    public void verifyTotalPrice() {
        greenKartHomePage.selectVegetable("Brocolli");
        greenKartHomePage.addProductToCart();
        greenKartHomePage.proceedToCheckout();
        greenKartCartPage.verifyCartPageTotalPrice();
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }
}
