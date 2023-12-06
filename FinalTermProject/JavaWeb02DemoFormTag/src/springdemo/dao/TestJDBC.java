package springdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/fruitDB?useSSL=false";
		String user="root";
		String pass="Ntrunghieu27";
		
		try {
			System.out.println("Connecting to the database: "+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful!");
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}
}
