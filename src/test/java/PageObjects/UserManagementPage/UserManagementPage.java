package PageObjects.UserManagementPage;

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

    public void assertTableUserName(String expectedName) {
        String actualName = getElementText(userManagementPageElements.tableUserName);
        if (!expectedName.equals(actualName)) {
            assertFailure(actualName, expectedName, "User name incorrect, Expected value: " + expectedName + " but the actual value: " + actualName + "");
        }
    }

    public void assertTableUserRole(String expectedRole) {
        String actualRole = getElementText(userManagementPageElements.tableUserRole);
        if (!expectedRole.equals(actualRole)) {
            assertFailure(actualRole, expectedRole, "User role incorrect, Expected value: " + expectedRole + " but the actual value: " + actualRole + "");
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
        if (!expectedStatus.equals(actualStatus)) {
            assertFailure(actualStatus, expectedStatus, "User status incorrect, Expected value: " + expectedStatus + " but the actual value: " + actualStatus + "");
        }
    }

    public void selectAndDisSelectTableCheckBox() {
        selectCheckBox(userManagementPageElements.tableCheckBox);
        disSelectCheckBox(userManagementPageElements.tableCheckBox);
    }
}