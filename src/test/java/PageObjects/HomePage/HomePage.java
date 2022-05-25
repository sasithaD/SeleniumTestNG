package PageObjects.HomePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestBase;

public class HomePage extends TestBase {

    private HomePageElements homePageElements;

    public HomePage() {
        this.homePageElements = new HomePageElements();
    }

    public void selectOptionFromMainMenu(String option) {
        clickOnElement(driver.findElement(By.xpath("//*[@id='mainMenuFirstLevelUnorderedList']//b[contains(text(),'" + option + "')]")));
    }

    public void enterUserName(String userName) {
        typeOnElement(homePageElements.userNameInput, userName);
    }

    public void selectUserRoleFromDropDown(String role) {
        selectDropDownByText(homePageElements.userRoleDropDown, role);
    }

    public void enterEmployeeName(String empName) {
        typeOnElementWithEnter(homePageElements.empNameInput, empName);
    }

    public void selectStatusFromDropDown(String status) {
        selectDropDownByText(homePageElements.statusDropDown, status);
    }

    public void clickSearchUserBtn() {
        clickOnElement(homePageElements.userSearchBtn);
    }

    public void assertTableUserName(String expectedName) {
        String actualName = getElementText(homePageElements.tableUserName);
        assertEqual(actualName, expectedName, "User name incorrect, Expected value: " + expectedName + " but the actual value: " + actualName + "");
    }

    public void assertTableUserRole(String expectedRole) {
        String actualRole = getElementText(homePageElements.tableUserRole);
        assertEqual(actualRole, expectedRole, "User role incorrect, Expected value: " + expectedRole + " but the actual value: " + actualRole + "");
    }

    public void assertTableEmployeeName(String expectedName) {
        String actualName = getElementText(homePageElements.tableEmpName);
        assertEqual(actualName, expectedName, "Employee name incorrect, Expected value: " + expectedName + " but the actual value: " + actualName + "");
    }

    public void assertTableStatus(String expectedStatus) {
        String actualStatus = getElementText(homePageElements.tableStatus);
        assertEqual(actualStatus, expectedStatus, "User status incorrect, Expected value: " + expectedStatus + " but the actual value: " + actualStatus + "");
    }
}
