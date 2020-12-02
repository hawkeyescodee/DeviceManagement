/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnln.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Liam Nguyen
 */
public class MyConnection implements Serializable {
    
    public static Connection getMyConnection() throws Exception {
        //1. nạp driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DeviceManagement","sa","Nhatlinh123");
        return conn;       
        
    }
    
    
}
