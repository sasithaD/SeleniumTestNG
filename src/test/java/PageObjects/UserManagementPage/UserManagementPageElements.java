package PageObjects.UserManagementPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class UserManagementPageElements extends TestBase {

    public UserManagementPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#searchSystemUser_userType")
    WebElement userRoleDropDown;

    @FindBy(css = "#searchSystemUser_userName")
    WebElement userNameInput;

    @FindBy(css = "#searchSystemUser_employeeName_empName")
    WebElement empNameInput;

    @FindBy(css = "#searchSystemUser_status")
    WebElement statusDropDown;

    @FindBy(css = "#searchBtn")
    WebElement userSearchBtn;

    @FindBy(css = "#resultTable tbody tr:nth-child(1) td:nth-child(2) a")
    WebElement tableUserName;

    @FindBy(css = "#resultTable tbody tr:nth-child(1) td:nth-child(3)")
    WebElement tableUserRole;

    @FindBy(css = "#resultTable tbody tr:nth-child(1) td:nth-child(4)")
    WebElement tableEmpName;

    @FindBy(css = "#resultTable tbody tr:nth-child(1) td:nth-child(5)")
    WebElement tableStatus;

    @FindBy(css = "#resultTable tbody tr:nth-child(2) td:nth-child(1) input")
    WebElement tableCheckBox;

    @FindBy(css = "#resetBtn")
    WebElement resetBtn;

    @FindBy(css = "#btnDelete")
    WebElement deleteBtn;

}
