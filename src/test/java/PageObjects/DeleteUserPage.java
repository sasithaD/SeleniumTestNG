package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageElements;
import utils.TestBase;



public class DeleteUserPage extends TestBase {

    @FindBy(css = PageElements.MENU_ADMIN_SELECTOR)
    WebElement menuAdmin;

    @FindBy(css = PageElements.TEXT_USERNAME_SEARCH_SELECTOR)
    WebElement txtUsernameSearch;

    @FindBy(css = PageElements.BTN_SEARCH_SELECTOR)
    WebElement btnSearch;

    @FindBy(css = PageElements.BTN_DELETE_SELECTOR)
    WebElement btnDelete;

    @FindBy(css = PageElements.CHECK_ALL_SELECTOR)
    WebElement chkAll;

    @FindBy(css = PageElements.BTN_DIALOG_DELETE_SELECTOR)
    WebElement btnDialogDelete;

    @FindBy(css = PageElements.COL_NUMBER_RECORD_SELECTOR)
    WebElement colNoRecord;

    public DeleteUserPage(){
        PageFactory.initElements(driver, this);
    }


    public void clickMenuAdmin(){
        clickOnElement(menuAdmin);
    }

    public void typeUsername(String uname){
        typeOnElement(txtUsernameSearch, uname);
    }

    public void clickSearchBtn(){
        clickOnElement(btnSearch);
    }

    public void checkboxSelect(){
        clickOnElement(chkAll);
    }

    public boolean isDeletebuttonEnabled(){
       boolean isDeleteBtnEnabled = isElementEnabled(btnDelete);
       if(isDeleteBtnEnabled == true) {
           System.out.println("Record selected");
       } else {
           System.out.println("Record not selected");
       }

       return isDeleteBtnEnabled;
    }

    public void clickDeleteBtn(){
        clickOnElement(btnDelete);
    }

    public void clickDialogDeleteBtn(){
        clickOnElement(btnDialogDelete);
    }

    public String clickOnNoDataRow(){

        String txt = getElementText(colNoRecord);
        return txt;

    }
}
