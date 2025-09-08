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
		final String URL = "jdbc:mysql://localhost?";
		URL.concat(String.join("&", "verifyServerCertificate=false",
				"useSSL=true", "sslMode=PREFERRED", "useUnicode=true",
				"useTimezone=true", "serverTimezone=America/Sao_Paulo",
				"connectionCollation=utf8_bin", "characterSetResults=utf8",
				"characterEncoding=utf-8"));
		
		final String user = System.getenv("username");
		final String pass = System.getenv("password");
		
		Properties prop = new Properties();
		prop.put("user", user);
		prop.put("password", pass);
		
		try (Connection connection = DriverManager.getConnection(URL, prop);
				Statement stmt = connection.createStatement()) {
			stmt.execute("CREATE DATABASE IF NOT EXISTS `javastudy`");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
