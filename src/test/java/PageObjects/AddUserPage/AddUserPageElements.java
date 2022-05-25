package PageObjects.AddUserPage;

public class AddUserPageElements {

    public static final String menuAdmin =  "a[id='menu_admin_viewAdminModule']";
    public static final String btnAddEmployee = "input[id='btnAdd']" ;
    public static final String drpUserRole =  "select[id='systemUser_userType']" ;
    public static final String drpUserRoleOption = "option[value='2']" ;
    public static final String txtEmpName = "input[id='systemUser_employeeName_empName']";
    public static final String txtEmpNameSelected = "input[id='systemUser_employeeName_empId']";
    public static final String txtEmpUsername = "input[id='systemUser_userName']";
    public static final String drpEmpStatus = "select[id='systemUser_status']";
    public static final String drpUserStatusOption = "option[value='1']" ;
    public static final String txtEmpPassword = "input[id='systemUser_password']";
    public static final String txtEmpConfirmPassword = "input[id='systemUser_confirmPassword']";
    public static final String btnEmpSave = "input[id='btnSave']" ;
}
