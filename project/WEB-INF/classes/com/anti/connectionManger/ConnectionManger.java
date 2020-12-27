package com.anti.connectionManger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManger {

	static Connection connection=null;
	
	 private static String userName="root";
	
     private static String userPassword="harshita123";
	
     private static String dataBaseName="antiCollusionFinal";
     
     private static String url="jdbc:mysql://35.222.116.235:3306/"+dataBaseName;
     
     
    public static  Connection getConnection()
    {
    
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				connection=DriverManager.getConnection(url, userName, userPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		return connection;
    	
    }
	
}
