package com.shoping.dao;

import java.sql.*;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection connection=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopcart", "root", "7284");
		return connection;
		}
	catch(SQLException ce){
				throw new SQLException("unable to get connection");
		}
	//test
	finally {
		connection =null;
	}
	}
	
}
