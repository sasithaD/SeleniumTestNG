package PageObjects.SearchAndFilterPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class SearchAndFilterPageElements extends TestBase {

    public SearchAndFilterPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id='menuQuickSearch_menuQuickSearch']")
    WebElement txtQuickSearch;

    @FindBy(css = "ul[id='menuQuickSearchResultList']")
    WebElement listSearch;

    @FindBy(css = "a[class='employee-navbar-button action-icon']")  // ng-click="navbar.filter()" class='employee-navbar-button action-icon'
    WebElement btnFilter;

    @FindBy(css = "form[id='frmEmployeeSearch']")
    WebElement formEmpSearch;


    @FindBy(css = "a[href='#/pim/employees']")
    WebElement menuEmpMngmnt;

    @FindBy(css = "input[id='txtUsername']")
    WebElement txtUsername;

    @FindBy(css = "input[id='txtPassword']")
    WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnLogin;



}
