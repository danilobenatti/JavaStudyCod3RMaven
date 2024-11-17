package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionTest {
	
	public static void main(String[] args) {
		
		/**
		 * https://dev.mysql.com/doc/connector-j/en/connector-j-connp-props-security.html
		 */
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&amp;useSSL=true&amp;sslMode=PREFERRED&amp;useTimezone=true&amp;serverTimezone=America/Sao_Paulo&amp;useUnicode=true&amp;connectionCollation=utf8_bin&amp;characterSetResults=utf8&amp;characterEncoding=utf-8";
		final String user = "root";
		final String pass = "123456";
		
		Properties prop = new Properties();
		prop.put("user", user);
		prop.put("password", pass);
		
		try (Connection connection = DriverManager.getConnection(url, prop);
				Statement stmt = connection.createStatement()) {
			stmt.execute("CREATE DATABASE IF NOT EXISTS `javastudy`");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
