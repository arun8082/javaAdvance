package vn.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/javaee";
		String className = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "admin";
		Class.forName(className);
		return DriverManager.getConnection(url, user, password);
	}
}
