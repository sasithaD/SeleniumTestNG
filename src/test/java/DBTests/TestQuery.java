package DBTests;

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

    @Test
    public void TestDataRetrievalFromDB() throws SQLException {

        con = dbConnector.getConnection(driverName, dbUrl, username, password);
        stmt = con.createStatement();
        resultSet = stmt.executeQuery("select *  from customer;"); // need to change, dummy query

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while (resultSet.next()) {
            for(int i = 1; i < columnsNumber; i++)
                System.out.print(resultSet.getString(i) + " ");
            System.out.println();
        }

        con.close();

    }
}
