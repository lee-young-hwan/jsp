package com.example.libs.model;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	public static Connection getConnection() throws SQLException{
		 return DriverManager.getConnection("jdbc:apache:commons:dbcp:cp");
}
}