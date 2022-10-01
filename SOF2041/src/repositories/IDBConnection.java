/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import java.sql.Connection;

/**
 *
 * @author HA NGOC BACH
 */
public interface IDBConnection {
    public Connection openDbConnection();
    public void closeConnection(Connection connection);
}
