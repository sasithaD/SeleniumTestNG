package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Elements.PageElements;
import utils.TestBase;

public class EmployeeManagementPage extends TestBase {

    public EmployeeManagementPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.ADD_EMP_BTN_SELECTOR)
    WebElement addEmployeeBtn;

    @FindBy(xpath = PageElements.ADD_EMP_TOGGLE_BTN_SELECTOR)
    WebElement addEmployeeToggleBtn;

    public void clickAddEmployeeBtn() {
        waitUntilVisibilityOfElement(By.cssSelector("#addEmployeeButton"));
        clickOnElement(addEmployeeBtn);
    }

    public void addEmployeeDetails() {
        waitUntilVisibilityOfElement(By.xpath("//*[@id='hasLoginDetails']"));
        checkBoxJSSelect(addEmployeeToggleBtn);
        waitFor(3000);
        checkBoxJSDisSelect(addEmployeeToggleBtn);
    }
}
