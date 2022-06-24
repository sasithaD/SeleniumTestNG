package DBTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.connector.DBConnector;

import java.sql.*;

public class TestQuery extends TestBase {

    private static String driverName = properties.getProperty("driverName");
    private static String dbUrl = properties.getProperty("dbUrl");
    private static String username = properties.getProperty("dbUsername");
    private static String password = properties.getProperty("dbPassword");
    private DBConnector dbConnector = new DBConnector();
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet resultSet = null;

    @BeforeSuite
    public void setUpDBConnection() {

        con = dbConnector.getConnection(driverName, dbUrl, username, password);
    }

    @Test
    public void TestDataRetrievalFromDB() throws SQLException {

        stmt = con.createStatement();
        resultSet = stmt.executeQuery("select * from customer where rownum <= 5;"); // need to change, dummy query

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();

        while (resultSet.next()) {
            for(int i = 1; i < columnCount; i++)
                System.out.print(resultSet.getString(i) + " ");
            System.out.println();
        }

    }

    @AfterSuite
    public void closeDBConnection() throws SQLException {
        con.close();
    }
}
