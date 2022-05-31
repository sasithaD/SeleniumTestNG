package PageObjects.DeleteUserPage;

import utils.TestBase;



public class DeleteUserPage extends TestBase {

    private DeleteUserPageElements deleteUserPageElements;

    public DeleteUserPage(){
        this.deleteUserPageElements = new DeleteUserPageElements();
    }

    public void clickMenuAdmin(){
        clickOnElement(deleteUserPageElements.menuAdmin);
    }

    public void typeUsername(String uname){
        typeOnElement(deleteUserPageElements.txtUsernameSearch, uname);
    }

    public void clickSearchBtn(){
        clickOnElement(deleteUserPageElements.btnSearch);
    }

    public void checkboxSelect(){
        clickOnElement(deleteUserPageElements.chkAll);
    }

    public boolean isDeletebuttonEnabled(){
       boolean isDeleteBtnEnabled = isElementEnabled(deleteUserPageElements.btnDelete);
       if(isDeleteBtnEnabled == true) {
           System.out.println("Record selected");
       } else {
           System.out.println("Record not selected");
       }

       return isDeleteBtnEnabled;
    }

    public void clickDeleteBtn(){
        clickOnElement(deleteUserPageElements.btnDelete);
    }

    public void clickDialogDeleteBtn(){
        clickOnElement(deleteUserPageElements.btnDialogDelete);
    }

    public String clickOnNoDataRow(){

        String txt = getElementText(deleteUserPageElements.colNoRecord);
        return txt;

    }
}
