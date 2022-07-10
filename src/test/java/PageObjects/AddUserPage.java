package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Elements.PageElements;
import utils.TestBase;

public class AddUserPage extends TestBase {

    @FindBy(css = PageElements.MENU_ADMIN_SELECTOR)
    WebElement menuAdmin;
    @FindBy(css = PageElements.ADD_BTN_SELECTOR)
    WebElement btnAddEmployee;
    @FindBy(css = PageElements.DRP_USER_ROLE_SELECTOR)
    WebElement drpUserRole;
    @FindBy(css = PageElements.DRP_USER_ROLE_OPTION_SELECTOR)
    WebElement drpUserRoleOption;
    @FindBy(css = PageElements.TEXT_EMP_NAME_SELECTOR)
    WebElement txtEmpName;
    @FindBy(css = PageElements.TEXT_EMP_NAME_SELECTED_SELECTOR)
    WebElement txtEmpNameSelected;
    @FindBy(css = PageElements.TEXT_EMP_USERNAME_SELECTOR)
    WebElement txtEmpUsername;
    @FindBy(css = PageElements.DRP_EMP_STATUS_SELECTOR)
    WebElement drpEmpStatus;
    @FindBy(css = PageElements.DRP_USER_STATUS_OPTION_SELECTOR)
    WebElement drpUserStatusOption;
    @FindBy(css = PageElements.TEXT_EMP_PASSWORD_SELECTOR)
    WebElement txtEmpPassword;
    @FindBy(css = PageElements.TEXT_EMP_CONFIRM_PASSWORD_SELECTOR)
    WebElement txtEmpConfirmPassword;
    @FindBy(css = PageElements.BTN_EMP_SAVE_SELECTOR)
    WebElement btnEmpSave;

    public AddUserPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickMenuAdmin(){
        clickOnElement(menuAdmin);
    }

    public void clickAddEmployee(){
        clickOnElement(btnAddEmployee);
    }

    public void selectEmployeeRole(String txt){
        selectDropDownByText(drpUserRole, txt);
    }

    public void typeEmployeeName(String ename){
        typeOnElement(txtEmpName, ename);
    }

/*    public void selectEmployeeName(){
        selectValueFromAutoSuggestionListInTextField(txtEmpNameSelected);
    }*/

    public void typeEmpName(String nm){
        typeOnElementWithEnter(txtEmpName, nm);
    }

    public void typeEmployeeNameUsername(String uname){
        typeOnElement(txtEmpUsername, uname);
    }

    public void selectEmployeeStatus(String status){
        selectDropDownByText(drpEmpStatus, status);
    }

    public void typeEmployeePassword(String pw){
        typeOnElement(txtEmpPassword, pw);
    }

    public void typeEmployeeConfirmPassword(String conPw){
        typeOnElement(txtEmpConfirmPassword, conPw);
    }

    public void saveEmployee(){
        clickOnElement(btnEmpSave);
    }

    public void waitUntilForm(){
        waitUntilElementIsVisibleByCss("select[id='systemUser_status']", 2);
    }

    public void waitUntilSave(){
        waitUntilElementIsVisibleByCss("input[id='btnAdd']", 2);
    }

    public void waitUntilMenu(){
        waitUntilElementIsVisibleByCss("input[id='btnAdd']", 5);
    }

}
