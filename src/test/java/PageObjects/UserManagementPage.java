package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Elements.PageElements;
import utils.TestBase;

import java.util.List;

public class UserManagementPage extends TestBase {

    public UserManagementPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = PageElements.USER_ROLE_DROPDOWN_SELECTOR)
    WebElement userRoleDropDown;

    @FindBy(css = PageElements.USERNAME_INPUT_SELECTOR)
    WebElement userNameInput;

    @FindBy(css = PageElements.EMP_NAME_INPUT_SELECTOR)
    WebElement empNameInput;

    @FindBy(css = PageElements.STATUS_DROPDOWN_SELECTOR)
    WebElement statusDropDown;

    @FindBy(css = PageElements.USER_SEARCH_BTN_SELECTOR)
    WebElement userSearchBtn;

    @FindBy(css = PageElements.TABLE_USERNAME_SELECTOR)
    WebElement tableUserName;

    @FindBy(css = PageElements.TABLE_USER_ROLE_SELECTOR)
    WebElement tableUserRole;

    @FindBy(css = PageElements.TABLE_EMP_NAME_SELECTOR)
    WebElement tableEmpName;

    @FindBy(css = PageElements.TABLE_STATUS_SELECTOR)
    WebElement tableStatus;

    @FindBy(css = PageElements.TABLE_CHECKBOX_SELECTOR)
    WebElement tableCheckBox;

    @FindBy(css = PageElements.RESET_BTN_SELECTOR)
    WebElement resetBtn;

    @FindBy(css = PageElements.DELETE_BTN_SELECTOR)
    WebElement deleteBtn;

    @FindBy(xpath = PageElements.TABLE_ROW_LIST_SELECTOR)
    List<WebElement> tableRowList;

    public void enterUserName(String userName) {
        typeOnElement(userNameInput, userName);
    }

    public void selectUserRoleFromDropDown(String role) {
        selectDropDownByText(userRoleDropDown, role);
    }

    public void enterEmployeeName(String empName) {
        typeOnElementWithEnter(empNameInput, empName);
    }

    public void selectStatusFromDropDown(String status) {
        selectDropDownByText(statusDropDown, status);
    }

    public void clickSearchUserBtn() {
        clickOnElement(userSearchBtn);
    }

    public void clickResetBtn() {
        clickOnElement(resetBtn);
    }

    public void assertTableUserName(String expectedName) {
        String actualName = getElementText(tableUserName);
        if (!expectedName.equals(actualName)) {
            assertFailure(actualName, expectedName, "User name incorrect, Expected value: " + expectedName + " but the actual value: " + actualName + "");
        }
    }

    public void assertTableUserRole(String expectedRole) {
        for (int i = 0; i < tableRowList.size(); i++) {
            String actualRole = getElementTextBy(By.xpath("//*[@id='resultTable']//tbody//tr[" + Integer.valueOf(i + 1) + "]//td[3]"));
            if (!actualRole.equals(expectedRole)) {
                assertFailure(actualRole, expectedRole, "User role incorrect, Expected value: " + expectedRole + " but the actual value: " + actualRole + "");
            }
        }
    }

    public void assertTableEmployeeName(String expectedName) {
        String actualName = getElementText(tableEmpName);
        if (!expectedName.equals(actualName)) {
            assertFailure(actualName, expectedName, "Employee name incorrect, Expected value: " + expectedName + " but the actual value: " + actualName + "");
        }
    }

    public void assertTableStatus(String expectedStatus) {
        for (int i = 0; i < tableRowList.size(); i++) {
            String actualStatus = getElementTextBy(By.xpath("//*[@id='resultTable']//tbody//tr[" + Integer.valueOf(i + 1) + "]//td[5]"));
            if (!actualStatus.equals(expectedStatus)) {
                assertFailure(actualStatus, expectedStatus, "User status incorrect, Expected value: " + expectedStatus + " but the actual value: " + actualStatus + "");
            }
        }
    }

    public void verifyDeleteButtonIsClickable() {
        if (isElementEnableForAction(deleteBtn)) {
            assertFailure("", "", "Delete button should not be enabled");
        }
        selectCheckBox(tableCheckBox);
        waitUntilElementGetClickable(deleteBtn);
        if (!isElementEnableForAction(deleteBtn)) {
            assertFailure("", "", "Web element is still disable");
        }
        disSelectCheckBox(tableCheckBox);
    }

    public void verifyTableColumns(String columnName) {
        if (!isElementPresent(By.xpath("//*[@id='resultTable']//a[contains(text(),'" + columnName + "')]"))) {
            assertFailure("", "", "Column " + columnName + " is not found");
        }
    }
}