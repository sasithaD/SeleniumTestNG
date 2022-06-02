package utils;

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

//    /*-----------------Add User Page Elements--------------*/
//    public static final String MENU_ADMIN_SELECTOR = "a[id='menu_admin_viewAdminModule']";
//    public static final String ADD_BTN_SELECTOR = "input[id='btnAdd']";
//    public static final String DRP_USER_ROLE_SELECTOR = "select[id='systemUser_userType']";
//    public static final String DRP_USER_ROLE_OPTION_SELECTOR = "option[value='2']";
//    public static final String TEXT_EMP_NAME_SELECTOR = "input[id='systemUser_employeeName_empName']";
//    public static final String TEXT_EMP_NAME_SELECTED_SELECTOR = "input[id='systemUser_employeeName_empId']";
//    public static final String TEXT_EMP_USERNAME_SELECTOR = "input[id='systemUser_userName']";
//    public static final String DRP_EMP_STATUS_SELECTOR = "select[id='systemUser_status']";
//    public static final String DRP_USER_STATUS_OPTION_SELECTOR = "option[value='1']";
//    public static final String TEXT_EMP_PASSWORD_SELECTOR = "input[id='systemUser_password']";
//    public static final String TEXT_EMP_CONFIRM_PASSWORD_SELECTOR = "input[id='systemUser_confirmPassword']";
//    public static final String BTN_EMP_SAVE_SELECTOR = "input[id='btnSave']";
//
//    /*-----------------Delete User Page Elements--------------*/
//    public static final String TEXT_USERNAME_SEARCH_SELECTOR = "input[id='searchSystemUser_userName']";
//    public static final String BTN_SEARCH_SELECTOR = "input[id='searchBtn']";
//    public static final String BTN_DELETE_SELECTOR = "input[id='btnDelete']";
//    public static final String CHECK_ALL_SELECTOR = "input[id='ohrmList_chkSelectAll']";
//    public static final String BTN_DIALOG_DELETE_SELECTOR = "input[id='dialogDeleteBtn']";
//    public static final String COL_NUMBER_RECORD_SELECTOR = "td[colspan='5']";
}
