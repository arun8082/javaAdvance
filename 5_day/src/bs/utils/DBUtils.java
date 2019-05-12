package bs.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static Connection getConnection() throws Exception{
		String url ="jdbc:mysql://localhost:3306/javaee";
		String user="root";
		String password="admin";
		return DriverManager.getConnection(url,user,password);
	}
}
