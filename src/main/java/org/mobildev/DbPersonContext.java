package org.mobildev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbPersonContext {
	
    public static synchronized Connection getInstance() 
            throws SQLException, ClassNotFoundException 
        { 
            // Initialize all the information regarding 
            // Database Connection 
            String dbDriver = "com.mysql.jdbc.Driver"; 
            String dbURL = "jdbc:mysql://localhost:3306/"; 
            // Database name to access 
            String dbName = "mobildev"; 
            String dbUsername = "mastercan"; 
            String dbPassword = "06061989"; 
      
            Class.forName(dbDriver); 
            Connection con = DriverManager.getConnection(dbURL + dbName, 
                                                         dbUsername,  
                                                         dbPassword); 
            return con; 
        }
}
