package utils.connector;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnector {

    private static Logger dbConnectorLogger = Logger.getLogger(String.valueOf(DBConnector.class));
    private static Connection con;


    public static Connection getConnection(String driverName, String dbUrl, String username, String password) {
        try {
                Class.forName(driverName);
            try {
                con = DriverManager.getConnection(dbUrl, username, password);
            } catch (SQLException ex) {
                dbConnectorLogger.info("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            dbConnectorLogger.info("Driver not found.");
        }
        return con;
    }
}


