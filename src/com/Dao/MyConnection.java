package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public Connection getConnection(){
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//step2- connection to database
			//step2-connection to database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return con;
	}
}



