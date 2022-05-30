package PageObjects.DeleteUserPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class DeleteUserPageElements extends TestBase {

    public DeleteUserPageElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[id='menu_admin_viewAdminModule']")
    WebElement menuAdmin;

    @FindBy(css = "input[id='searchSystemUser_userName']")
    WebElement txtUsernameSearch;

    @FindBy(css = "input[id='searchBtn']")
    WebElement btnSearch;

    @FindBy(css = "input[id='btnDelete']")
    WebElement btnDelete;

    @FindBy(css = "input[id='ohrmList_chkSelectAll']")
    WebElement chkAll;

    @FindBy(css = "input[id='dialogDeleteBtn']")
    WebElement btnDialogDelete;

    @FindBy(css = "td[colspan='5']")
    WebElement colNoRecord;


}
