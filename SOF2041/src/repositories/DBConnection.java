
package repositories;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static String hostName = "localhost";
    private static String account = "sa";
    private static String pass = "123";
    private static String dbName = "SOF2041_bachhn";
    private static String connectionSQL = "jdbc:sqlserver://"+hostName+":1433;databaseName=" +dbName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection cnn;
    
    // LOAD DRIVER
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
        }
    }
    
    // Mo ket noi 
    static Connection openDbConnection(){
        try {
            return DriverManager.getConnection(connectionSQL, account,pass );
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(openDbConnection());
    }
}
