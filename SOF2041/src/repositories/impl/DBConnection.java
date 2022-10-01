/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.IDBConnection;

/**
 *
 * @author HA NGOC BACH
 */
public class DBConnection implements IDBConnection {

    protected String hostName = "localhost";
    protected String account = "sa";
    protected String pass = "123";
    protected String dbName = "SOF2041_bachhn";
    protected String connectionSQL = "jdbc:sqlserver://" + hostName + ":1433;databaseName=" + dbName;
    protected String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    protected Connection con;

   

    @Override
    public Connection openDbConnection() {
        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DriverManager.getConnection(connectionSQL, account, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
