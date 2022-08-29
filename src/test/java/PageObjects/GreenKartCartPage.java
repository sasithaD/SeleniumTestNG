package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Elements.PageElements;
import utils.TestBase;

public class GreenKartCartPage extends TestBase {

    public GreenKartCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.TOTAL_PRICE_SELECTOR)
    WebElement totalPrice;

    @FindBy(css = PageElements.DISCOUNT_AMOUNT_SELECTOR)
    WebElement discountAmount;

    public void verifyCartPageTotalPrice() {
        waitUntilVisibilityOfElement(By.cssSelector(PageElements.TOTAL_PRICE_SELECTOR));
        String actualPrice = getElementText(totalPrice);
        String expectedPrice = readActualValue("productPrice");

        if (!expectedPrice.equals(actualPrice)) {
            assertFailure(actualPrice, expectedPrice, "Price incorrect");
        }

        String discountAmountText = getElementText(discountAmount);
        String numericDiscountText = getNumericValue(discountAmountText);
        if (!numericDiscountText.equals("0")) {
            assertFailure("", "", "Error");
        }
    }
}
