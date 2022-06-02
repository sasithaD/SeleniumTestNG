package PageObjects.AddUserPage;

import utils.TestBase;

public class AddUserPage extends TestBase {

    private AddUserPageElements addUserPageElements;

    public AddUserPage() {
        this.addUserPageElements = new AddUserPageElements();
    }

    public void clickMenuAdmin(){
        clickOnElement(addUserPageElements.menuAdmin);
    }

    public void clickAddEmployee(){
        clickOnElement(addUserPageElements.btnAddEmployee);
    }

    public void selectEmployeeRole(String txt){
        selectDropDownByText(addUserPageElements.drpUserRole, txt);
    }

    public void typeEmployeeName(String ename){
        typeOnElement(addUserPageElements.txtEmpName, ename);
    }

/*    public void selectEmployeeName(){
        selectValueFromAutoSuggestionListInTextField(addUserPageElements.txtEmpNameSelected);
    }*/

    public void typeEmpName(String nm){
        typeOnElementWithEnter(addUserPageElements.txtEmpName, nm);
    }

    public void typeEmployeeNameUsername(String uname){
        typeOnElement(addUserPageElements.txtEmpUsername, uname);
    }

    public void selectEmployeeStatus(String status){
        selectDropDownByText(addUserPageElements.drpEmpStatus, status);
    }

    public void typeEmployeePassword(String pw){
        typeOnElement(addUserPageElements.txtEmpPassword, pw);
    }

    public void typeEmployeeConfirmPassword(String conPw){
        typeOnElement(addUserPageElements.txtEmpConfirmPassword, conPw);
    }

    public void saveEmployee(){
        clickOnElement(addUserPageElements.btnEmpSave);
    }

    public void waitUntilForm(){
        waitUntilElementIsVisible("select[id='systemUser_status']", 2);
    }

    public void waitUntilSave(){
        waitUntilElementIsVisible("input[id='btnAdd']", 2);
    }

    public void waitUntilMenu(){
        waitUntilElementIsVisible("input[id='btnAdd']", 5);
    }

}
