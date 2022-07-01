package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageElements;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class CreateReportPage extends TestBase {


    @FindBy(css = PageElements.MENU_RPT_SELECTOR)
    WebElement menuReport;

    @FindBy(xpath = PageElements.BTN_NEW_RPT)
    WebElement btnNewReport;

    @FindBy(xpath = PageElements.BTN_ADD_RPT)
    WebElement btnAddReport;

    @FindBy(xpath = PageElements.TXT_RPT_NAME)
    WebElement txtRptName;

    @FindBy(xpath = PageElements.BTN_NEXT)
    WebElement btnNext;

    @FindBy(xpath = PageElements.CHK_EMP_NAME)
    WebElement chkEmpName;

    @FindBy(xpath = PageElements.CHK_EMP_GENDER)
    WebElement chkEmpGender;

    @FindBy(xpath = PageElements.CHK_EMP_STATUS)
    WebElement chkEmpStatus;

    @FindBy(xpath = PageElements.CHK_JOB_TITLE)
    WebElement chkEmpJobTitle;

    @FindBy(xpath = PageElements.BTN_FIELD_GROUP)
    WebElement btnFieldGroup;

    @FindBy(xpath = PageElements.DRP_PERSONAL)
    WebElement drpPersonal;

    @FindBy(xpath = PageElements.CHK_PER_EMP_ID)
    WebElement chkPerEmpID;

    @FindBy(xpath = PageElements.CHK_PER_EMP_NAME)
    WebElement chkPerEmpName;

    @FindBy(xpath = PageElements.CHK_PER_EMP_GENDER)
    WebElement chkPerEmpGender;

    @FindBy(xpath = PageElements.DRP_JOB)
    WebElement drpJob;

    @FindBy(xpath = PageElements.CHK_JOB_EMP_STATUS)
    WebElement chkJobStatus;

    @FindBy(xpath = PageElements.CHK_JOB_EMP_TITLE)
    WebElement chkJobTitle;

    @FindBy(xpath = PageElements.BTN_SAVE)
    WebElement btnSave;

    @FindBy(xpath = PageElements.BTN_PAGINATION)
    WebElement btnPagination;

    @FindBy(xpath = PageElements.OPT_PAGINATION_MAX)
    WebElement optPaginationMax;

    @FindBy(css = PageElements.FILTER_EMP_STATUS)
    WebElement filterEmpStatus;

    @FindBy(css = PageElements.FILTER_JOB_TITLE)
    WebElement filterEmpTitle;

    @FindBy(xpath = PageElements.BTN_GENERATE)
    WebElement btnGenerate;

    @FindBy(xpath = PageElements.TBL_REPORT_ROWS)
    List<WebElement> tblReportRows;

    public void clickReportMenu(){
        clickOnElement(menuReport);
    }

    public void clickNewReport(){
        clickOnElement(btnNewReport);
    }

    public void clickAddReport(){
        clickOnElement(btnAddReport);
    }

    public void sendReportName(String rptName){
        typeOnElement(txtRptName, rptName);
    }

    public void clickNext(){
        clickOnElement(btnNext);
    }

    public void checkEmployeeName(){
        clickOnElement(chkEmpName);
    }

    public void checkEmployeeGender(){
        clickOnElement(chkEmpGender);
    }

    public void checkEmploymentStatus(){
        clickOnElement(chkEmpStatus);
    }

    public void checkEmployeeJobTitle(){
        clickOnElement(chkEmpJobTitle);
    }

    public void clickFieldGroup(){
        clickOnElement(btnFieldGroup);
    }

    public void selectItemPersonalfromDropdown(){
        clickOnElement(drpPersonal);
    }

    public void clickFieldEmpID(){
        clickOnElement(chkPerEmpID);
    }

    public void clickFieldEmpName(){
        clickOnElement(chkPerEmpName);
    }

    public void clickFieldEmpGender(){
        clickOnElement(chkPerEmpGender);
    }

    public void clickFieldEmpStatus(){
        clickOnElement(chkJobStatus);
    }

    public void clickFieldJobTitle(){
        clickOnElement(chkJobTitle);
    }

    public void selectJobFromDropdown(){
        clickOnElement(drpJob);
    }

    public void clickSave(){
        clickOnElement(btnSave);
    }

    public void clickPagination(){
        clickOnElement(btnPagination);
    }

    public void selectMaxPaginationLimit(){
        clickOnElement(optPaginationMax);
    }

    public void choseEmployeeStatus(String txt){
        selectValueFromAutoSuggestionListInTextField(filterEmpStatus, txt);
    }

    public void choseJobTitle(String txt){
        selectValueFromAutoSuggestionListInTextField(filterEmpTitle, txt);
    }

    public void clickGenerate(){
        clickOnElement(btnGenerate);
    }

    public boolean checkName(String name){
        boolean hasName;
        String nameOnTable;
        ArrayList<String> nameList = new ArrayList<String>();

        for (int i = 0; i < tblReportRows.size(); i++) {
             nameOnTable = getElementTextBy(By.xpath("//*[@id='pim_report_table']//tbody//tr[" + Integer.valueOf(i + 1) + "]//td[2]"));
             nameList.add(nameOnTable);
        }

        if(nameList.contains(name))
            hasName = true;
        else
            hasName = false;

        return hasName;
    }

}
