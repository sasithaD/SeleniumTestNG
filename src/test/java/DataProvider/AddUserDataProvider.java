package DataProvider;

import org.testng.annotations.DataProvider;
import utils.TestBase;

public class AddUserDataProvider extends TestBase {

    public AddUserDataProvider() {
    }

    @DataProvider(name="addEmployee")
    public Object[][] addUserData() {
        Object[][] objTestData = readExcelData("src/main/resources/data/TestUserData.xls","addUser");
        return objTestData;
    }
}
