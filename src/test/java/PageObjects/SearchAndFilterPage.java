package PageObjects;

import org.openqa.selenium.By;
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

    @FindBy(xpath = PageElements.BTN_FILTER_SELECTOR)
    WebElement btnFilter;

    @FindBy(xpath = PageElements.FORM_EMP_SEARCH_SELECTOR)
    WebElement formEmpSearch;

    @FindBy(css = PageElements.MENU_EMP_MANGMNT_SELECTOR)
    WebElement menuEmpMngmnt;

    @FindBy(xpath = PageElements.TEXT_EMP_NAME_FILTER_SELECTOR)
    WebElement txtEmpName;

    @FindBy(xpath = PageElements.BTN_SEARCH_FILTER_SELECTOR)
    WebElement btnSearch;

    @FindBy(xpath = PageElements.TBL_EMP_NAME_SELECTOR)
    WebElement txtEmpNameInTbl;

    @FindBy(css = PageElements.TXT_EMP_PER_FIRST_NAME)
    WebElement txtFirstName;

    @FindBy(css = PageElements.TXT_EMP_PER_LAST_NAME)
    WebElement txtLastName;

    @FindBy(xpath = PageElements.DRP_SUB_UNIT)
    WebElement drpSubUnit;

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
        waitForElementVisibilityBy(By.xpath("//*[@id='menuQuickSearch_menuQuickSearch']"), 3);
    }

    public void waitTillFilterIcon(){
        waitForElementVisibilityBy(By.xpath("//a[@class='employee-navbar-button action-icon' and @ng-click='navbar.search()']"), 5);
    }

    public void waitTillEmpSearchForm(){
        waitForElementVisibilityBy(By.xpath("//*[@id='employee_list_search_modal']//*[text()='Filter Employees By']"), 3);
    }

    public void waitTillEmpSearchResultTableForm(){
        waitForElementVisibilityBy(By.xpath("//*[@id='employeeListTable']"), 5);
    }

    public void clickMenuEmpManagement(){
        clickOnElement(menuEmpMngmnt);
    }

    public String getEmpName(){
        String nm = getElementText(txtEmpNameInTbl);
        return nm;
    }

    public String getEmpFirstName(){
        String fnm = javaScriptGetText(txtFirstName);
        return fnm;
    }

    public String getEmpLastName(){
        String lnm = javaScriptGetText(txtLastName);
        return lnm;
    }

    public void clickOnResultTable(){
         clickOnElement(txtEmpNameInTbl);
    }

    public void clickFilterBtn(){
       javaScriptClick(btnFilter);
    }

    public void typeEmployeeName(String name){
        typeOnElement(txtEmpName, name);
    }

    public void selectSubUnit(String value){
        selectValueFromAutoSuggestionListInTextField(drpSubUnit, value);
    }

    public void clickOnSearch(){
        javaScriptClick(btnSearch);
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


    public void loginToTheApplication(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginBtn();
    }
}
