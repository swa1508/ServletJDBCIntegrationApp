package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnUtil {
	
	private static Connection con = null;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","123");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static Connection getConnection()
	{
		return con;
	}

}
