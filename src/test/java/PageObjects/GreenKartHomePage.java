package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Elements.PageElements;
import utils.TestBase;

public class GreenKartHomePage extends TestBase {

    public GreenKartHomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.VEG_SEARCH_INPUT_SELECTOR)
    WebElement vegSearchInput;

    @FindBy(css = PageElements.PRODUCT_PRICE_SELECTOR)
    WebElement productPrice;

    @FindBy(xpath = PageElements.ADD_TO_CART_BTN_SELECTOR)
    WebElement addToCartBtn;

    @FindBy(css = PageElements.CART_BTN_SELECTOR)
    WebElement cartBtn;

    @FindBy(xpath = PageElements.PROCEED_TO_CHECKOUT_BTN_SELECTOR)
    WebElement proceedToCheckoutBtn;

    public void selectVegetable(String veg) {
        typeOnElement(vegSearchInput, veg);
    }

    public void addProductToCart() {
        waitUntilVisibilityOfElement(By.xpath(PageElements.ADD_TO_CART_BTN_SELECTOR));
        String productPriceText = getElementText(productPrice);
        writeActualValue("productPrice", productPriceText);
        clickOnElement(addToCartBtn);
    }

    public void proceedToCheckout() {
        clickOnElement(cartBtn);
        waitUntilVisibilityOfElement(By.xpath(PageElements.PROCEED_TO_CHECKOUT_BTN_SELECTOR));
        clickOnElement(proceedToCheckoutBtn);
    }
}
