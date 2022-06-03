package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElements {

    /*-----------------Login Page Elements--------------*/
    public static final String USERNAME_SELECTOR = "#txtUsername";
    public static final String PASSWORD_SELECTOR = "#txtPassword";
    public static final String LOGIN_BTN_SELECTOR = "#btnLogin";
    public static final String ERROR_MSG_SELECTOR = "#spanMessage";
    public static final String NEW_LOGIN_BTN_SELECTOR = "button[type='submit']";

    /*-----------------User Management Page Elements--------------*/
    public static final String USER_ROLE_DROPDOWN_SELECTOR = "#searchSystemUser_userType";
    public static final String USERNAME_INPUT_SELECTOR = "#searchSystemUser_userName";
    public static final String EMP_NAME_INPUT_SELECTOR = "#searchSystemUser_employeeName_empName";
    public static final String STATUS_DROPDOWN_SELECTOR = "#searchSystemUser_status";
    public static final String USER_SEARCH_BTN_SELECTOR = "#searchBtn";
    public static final String TABLE_USERNAME_SELECTOR = "#resultTable tbody tr:nth-child(1) td:nth-child(2) a";
    public static final String TABLE_USER_ROLE_SELECTOR = "#resultTable tbody tr:nth-child(1) td:nth-child(3)";
    public static final String TABLE_EMP_NAME_SELECTOR = "#resultTable tbody tr:nth-child(1) td:nth-child(4)";
    public static final String TABLE_STATUS_SELECTOR = "#resultTable tbody tr:nth-child(1) td:nth-child(5)";
    public static final String TABLE_CHECKBOX_SELECTOR = "#resultTable tbody tr:nth-child(2) td:nth-child(1) input";
    public static final String RESET_BTN_SELECTOR = "#resetBtn";
    public static final String DELETE_BTN_SELECTOR = "#btnDelete";
    public static final String TABLE_ROW_LIST_SELECTOR = "//*[@id='resultTable']//tbody//tr";

    /*-----------------Home Page Elements--------------*/
    public static final String WELCOME_TEXT_SELECTOR = "#welcome";
    public static final String EMP_MANAGEMENT_MENU_BTN_SELECTOR = "//*[@data-automation-id='menu_pim_viewEmployeeList'][1]//*[contains(text(),'Employee Management')]";
    public static final String KEBAB_BTN_SELECTOR = ".expand-icon";
    public static final String MORE_QUALIFICATIONS_BTN_SELECTOR = "a[data-automation-id='more_menu_child_menu_admin_Qualifications']";
    public static final String MORE_SKILLS_BTN_SELECTOR = "a[data-automation-id='more_menu_child_menu_admin_viewSkills']";
    public static final String FOOTER_ELEMENT_SELECTOR = "//*[contains(text(),'COVID-19 Report')]";

    /*-----------------Employee Management Page Elements--------------*/
    public static final String ADD_EMP_BTN_SELECTOR = "#addEmployeeButton";
    public static final String ADD_EMP_TOGGLE_BTN_SELECTOR = "//*[@id='hasLoginDetails']";

}
