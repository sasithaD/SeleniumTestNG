package Elements;

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
    public static final String REPORT_ANALYTICS_MENU_BTN_SELECTOR = "//*[@id='left_menu_item_336']";
    public static final String ATTENDANCE_MENU_BTN_SELECTOR = "#menu_item_291:nth-child(1) span";

    /*-----------------Add User Page Elements--------------*/
    public static final String MENU_ADMIN_SELECTOR = "a[id='menu_admin_viewAdminModule']";
    public static final String ADD_BTN_SELECTOR = "input[id='btnAdd']";
    public static final String DRP_USER_ROLE_SELECTOR = "select[id='systemUser_userType']";
    public static final String DRP_USER_ROLE_OPTION_SELECTOR = "option[value='2']";
    public static final String TEXT_EMP_NAME_SELECTOR = "input[id='systemUser_employeeName_empName']";
    public static final String TEXT_EMP_NAME_SELECTED_SELECTOR = "input[id='systemUser_employeeName_empId']";
    public static final String TEXT_EMP_USERNAME_SELECTOR = "input[id='systemUser_userName']";
    public static final String DRP_EMP_STATUS_SELECTOR = "select[id='systemUser_status']";
    public static final String DRP_USER_STATUS_OPTION_SELECTOR = "option[value='1']";
    public static final String TEXT_EMP_PASSWORD_SELECTOR = "input[id='systemUser_password']";
    public static final String TEXT_EMP_CONFIRM_PASSWORD_SELECTOR = "input[id='systemUser_confirmPassword']";
    public static final String BTN_EMP_SAVE_SELECTOR = "input[id='btnSave']";

    /*-----------------Delete User Page Elements--------------*/
    public static final String TEXT_USERNAME_SEARCH_SELECTOR = "input[id='searchSystemUser_userName']";
    public static final String BTN_SEARCH_SELECTOR = "input[id='searchBtn']";
    public static final String BTN_DELETE_SELECTOR = "input[id='btnDelete']";
    public static final String CHECK_ALL_SELECTOR = "input[id='ohrmList_chkSelectAll']";
    public static final String BTN_DIALOG_DELETE_SELECTOR = "input[id='dialogDeleteBtn']";
    public static final String COL_NUMBER_RECORD_SELECTOR = "td[colspan='5']";

    /*-----------------Search & Filter Page Elements--------------*/
    public static final String TEXT_QUICK_SEARCH_SELECTOR = "input[id='menuQuickSearch_menuQuickSearch']";
    public static final String LIST_SEARCH_SELECTOR = "ul[id='menuQuickSearchResultList']";
    public static final String BTN_FILTER_SELECTOR = "//a[@class='employee-navbar-button action-icon' and @ng-click='navbar.filter()']"; //  "a[class='employee-navbar-button action-icon']"; // ng-click="navbar.filter()" class='employee-navbar-button action-icon'
    public static final String FORM_EMP_SEARCH_SELECTOR = "//*[@id='employee_list_search_modal']//*[text()='Filter Employees By']"; //"form[id='frmEmployeeSearch']";
    public static final String MENU_EMP_MANGMNT_SELECTOR = "a[href='#/pim/employees']";
    public static final String TEXT_EMP_NAME_FILTER_SELECTOR = "//*[@class='modal-content']//input[@id='emp_search_mdl_employee_name_filter_value']";
    public static final String BTN_SEARCH_FILTER_SELECTOR = "//*[@class='modal-footer']//*[@ng-click='modal.search()']";
    public static final String TABLE_EMPLOYEE_SELECTOR = "//*[@id='employeeListTable']";     /*   "//*[@class='pim-container']//table[@id='employeeListTable']"; */
    public static final String TBL_EMP_NAME_SELECTOR = "//*[@id='employeeListTable']/tbody/tr/td[3]";
    public static final String TXT_EMP_PER_FIRST_NAME = "input[id='firstName']";
    public static final String TXT_EMP_PER_LAST_NAME = "input[id='lastName']";
    public static final String DRP_SUB_UNIT = "//input[@class='select-dropdown' and @data-activates= 'select-options-303db02e-497d-3a76-888c-de0f80de65ba' ]";

    /*-----------------Employee Management Page Elements--------------*/
    public static final String ADD_EMP_BTN_SELECTOR = "#addEmployeeButton";
    public static final String ADD_EMP_TOGGLE_BTN_SELECTOR = "//*[@id='hasLoginDetails']";

    /*-----------------Report Analytics Page Elements--------------*/
    public static final String PARTICIPATION_SESSION_INFO_BTN_SELECTOR = ".reports-accordion-content-row:nth-child(1) div[data-test='reportItem3'] div";
    public static final String ROWS_PER_PAGE_DROPDOWN_SELECTOR = "//li[contains(@class,'page-size')]//input";
    public static final String NEXT_PAGE_BTN_SELECTOR = "//a[@title='Next Page']";
    public static final String PAGINATION_SUMMARY_SELECTOR = ".pagination .summary";
    public static final String TABLE_SELECTOR = "//*[@id='pim_report_table']";

    /*-----------------Attendance Page Elements--------------*/
    public static final String DOWNLOAD_PDF_BTN_SELECTOR = "button[data-icon='ohrm_file_pdf']";

    /*-----------------GreenKart Home Page Elements--------------*/
    public static final String VEG_SEARCH_INPUT_SELECTOR = "input[class='search-keyword']";
    public static final String PRODUCT_PRICE_SELECTOR = ".products .product .product-price";
    public static final String ADD_TO_CART_BTN_SELECTOR = "//button[contains(text(),'ADD TO CART')]";
    public static final String CART_BTN_SELECTOR = "img[alt='Cart']";
    public static final String PROCEED_TO_CHECKOUT_BTN_SELECTOR = "//button[contains(text(),'PROCEED TO CHECKOUT')]";

    /*-----------------GreenKart Cart Page Elements--------------*/
    public static final String TOTAL_PRICE_SELECTOR = ".discountAmt";
    public static final String DISCOUNT_AMOUNT_SELECTOR = ".discountPerc";
}
