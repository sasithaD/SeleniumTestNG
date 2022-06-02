package PageObjects.SearchAndFilterPage;

import utils.TestBase;

public class SearchAndFilterPage extends TestBase {

    private SearchAndFilterPageElements searchAndFilterPageElements;

    public SearchAndFilterPage() {
        this.searchAndFilterPageElements = new SearchAndFilterPageElements();
    }

    public void searchForKnownItem(String value){
        typeOnElementWithEnter(searchAndFilterPageElements.txtQuickSearch, value);
    }


    public void searchForRandomItem(String value){
        selectValueFromAutoSuggestionListInTextField(searchAndFilterPageElements.txtQuickSearch, value);
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
        typeOnElement(searchAndFilterPageElements.txtUsername, userName);
    }

    public void enterPassword(String password) {
        typeOnElement(searchAndFilterPageElements.txtPassword, password);
    }

    public void clickLoginBtn(){
        clickOnElement(searchAndFilterPageElements.btnLogin);
    }

    public void clickMenuEmpManagement(){
        clickOnElement(searchAndFilterPageElements.menuEmpMngmnt);
    }

    public void clickFilterBtn(){
        clickOnElement(searchAndFilterPageElements.btnFilter);
    }




    public void loginToTheApplication(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginBtn();
    }
}
