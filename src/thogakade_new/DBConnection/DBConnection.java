/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade_new.DBConnection;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;


/**
 *
 * @author ranga
 */
public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "root", "1234");
            

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
            
     

    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            return instance = new DBConnection();
        }
        return instance;
    }
}
