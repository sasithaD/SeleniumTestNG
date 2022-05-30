package PageObjects.AddUserPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class AddUserPageElements extends TestBase {


    public AddUserPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[id='menu_admin_viewAdminModule']")
     WebElement menuAdmin;
    @FindBy(css = "input[id='btnAdd']")
     WebElement btnAddEmployee;
    @FindBy(css = "select[id='systemUser_userType']")
     WebElement drpUserRole;
    @FindBy(css = "option[value='2']")
     WebElement drpUserRoleOption;
    @FindBy(css = "input[id='systemUser_employeeName_empName']")
     WebElement txtEmpName;
    @FindBy(css = "input[id='systemUser_employeeName_empId']")
     WebElement txtEmpNameSelected;
    @FindBy(css = "input[id='systemUser_userName']")
     WebElement txtEmpUsername;
    @FindBy(css = "select[id='systemUser_status']")
     WebElement drpEmpStatus;
    @FindBy(css = "option[value='1']")
     WebElement drpUserStatusOption;
    @FindBy(css = "input[id='systemUser_password']")
     WebElement txtEmpPassword;
    @FindBy(css = "input[id='systemUser_confirmPassword']")
     WebElement txtEmpConfirmPassword;
    @FindBy(css = "input[id='btnSave']")
     WebElement btnEmpSave;
}
