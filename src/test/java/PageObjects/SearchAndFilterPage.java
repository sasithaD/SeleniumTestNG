package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageElements;
import utils.TestBase;

public class SearchAndFilterPage extends TestBase {

    @FindBy(css = PageElements.TEXT_QUICK_SEARCH_SELECTOR)
    WebElement txtQuickSearch;

    @FindBy(css = PageElements.LIST_SEARCH_SELECTOR)
    WebElement listSearch;

    @FindBy(css = PageElements.BTN_FILTER_SELECTOR)
    WebElement btnFilter;

    @FindBy(css = PageElements.FORM_EMP_SEARCH_SELECTOR)
    WebElement formEmpSearch;

    @FindBy(css = PageElements.MENU_EMP_MANGMNT_SELECTOR)
    WebElement menuEmpMngmnt;

    @FindBy(css = PageElements.USERNAME_SELECTOR)
    WebElement txtUsername;

    @FindBy(css = PageElements.PASSWORD_SELECTOR)
    WebElement txtPassword;

    @FindBy(css = PageElements.NEW_LOGIN_BTN_SELECTOR)
    WebElement btnLogin;

    public SearchAndFilterPage(){
        PageFactory.initElements(driver, this);
    }

    public void searchForKnownItem(String value){
        typeOnElementWithEnter(txtQuickSearch, value);
    }


    public void searchForRandomItem(String value){
        selectValueFromAutoSuggestionListInTextField(txtQuickSearch, value);
    }

    public void waitTillPageLoad(){
        waitUntilElementIsVisibleByXpath("//*[@id='menuQuickSearch_menuQuickSearch']", 3);
    }

    public void waitTillFilterIcon(){
        waitUntilElementIsVisibleByXpath("//*[@id='ribbon-actions']/ui-view/ul/li[3]/a", 5);
    }

    public void waitTillEmpSearchForm(){
        waitUntilElementIsVisibleByXpath("//*[@id='employee_list_search_modal']/div[1]/div", 5);
    }

    public void enterUserName(String userName) {
        typeOnElement(txtUsername, userName);
    }

    public void enterPassword(String password) {
        typeOnElement(txtPassword, password);
    }

    public void clickLoginBtn(){
        clickOnElement(btnLogin);
    }

    public void clickMenuEmpManagement(){
        clickOnElement(menuEmpMngmnt);
    }

    public void clickFilterBtn(){
        clickOnElement(btnFilter);
    }




    public void loginToTheApplication(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginBtn();
    }
}
