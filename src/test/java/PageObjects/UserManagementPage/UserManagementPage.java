package PageObjects.UserManagementPage;

import org.openqa.selenium.By;
import utils.TestBase;

public class UserManagementPage extends TestBase {

    private UserManagementPageElements userManagementPageElements;

    public UserManagementPage() {
        this.userManagementPageElements = new UserManagementPageElements();
    }

    public void enterUserName(String userName) {
        typeOnElement(userManagementPageElements.userNameInput, userName);
    }

    public void selectUserRoleFromDropDown(String role) {
        selectDropDownByText(userManagementPageElements.userRoleDropDown, role);
    }

    public void enterEmployeeName(String empName) {
        typeOnElementWithEnter(userManagementPageElements.empNameInput, empName);
    }

    public void selectStatusFromDropDown(String status) {
        selectDropDownByText(userManagementPageElements.statusDropDown, status);
    }

    public void clickSearchUserBtn() {
        clickOnElement(userManagementPageElements.userSearchBtn);
    }

    public void clickResetBtn() {
        clickOnElement(userManagementPageElements.resetBtn);
    }

    public void assertTableUserName(String expectedName) {
        String actualName = getElementText(userManagementPageElements.tableUserName);
        if (!expectedName.equals(actualName)) {
            assertFailure(actualName, expectedName, "User name incorrect, Expected value: " + expectedName + " but the actual value: " + actualName + "");
        }
    }

    public void assertTableUserRole(String expectedRole) {
        String actualRole = getElementText(userManagementPageElements.tableUserRole);
        for (int i = 0; i < userManagementPageElements.tableRowList.size(); i++) {
            if (!getElementTextBy(By.xpath("//*[@id='resultTable']//tbody//tr[" + Integer.valueOf(i + 1) + "]//td[3]")).equals(expectedRole)) {
                assertFailure(actualRole, expectedRole, "User role incorrect, Expected value: " + expectedRole + " but the actual value: " + actualRole + "");
            }
        }
    }

    public void assertTableEmployeeName(String expectedName) {
        String actualName = getElementText(userManagementPageElements.tableEmpName);
        if (!expectedName.equals(actualName)) {
            assertFailure(actualName, expectedName, "Employee name incorrect, Expected value: " + expectedName + " but the actual value: " + actualName + "");
        }
    }

    public void assertTableStatus(String expectedStatus) {
        String actualStatus = getElementText(userManagementPageElements.tableStatus);
        for (int i = 0; i < userManagementPageElements.tableRowList.size(); i++) {
            if (!getElementTextBy(By.xpath("//*[@id='resultTable']//tbody//tr[" + Integer.valueOf(i + 1) + "]//td[5]")).equals(expectedStatus)) {
                assertFailure(actualStatus, expectedStatus, "User status incorrect, Expected value: " + expectedStatus + " but the actual value: " + actualStatus + "");
            }
        }
    }

    public void verifyDeleteButtonIsClickable() {
        if (isElementEnableForAction(userManagementPageElements.deleteBtn)) {
            assertFailure("", "", "Delete button should not be enabled");
        }
        selectCheckBox(userManagementPageElements.tableCheckBox);
        waitUntilElementGetClickable(userManagementPageElements.deleteBtn);
        if (!isElementEnableForAction(userManagementPageElements.deleteBtn)) {
            assertFailure("", "", "Web element is still disable");
        }
        disSelectCheckBox(userManagementPageElements.tableCheckBox);
    }

    public void verifyTableColumns(String columnName) {
        if (!isElementPresent(By.xpath("//*[@id='resultTable']//a[contains(text(),'" + columnName + "')]"))) {
            assertFailure("", "", "Column " + columnName + " is not found");
        }
    }
}