package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectionFactory {
	
	public static Connection getConnection() {
		
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true&sslMode=PREFERRED";
		
		Properties prop = new Properties();
		
		try (FileInputStream inputStream = new FileInputStream(
				new File("./src/main/java/util/connection.properties"))) {
/**			InputStream inputStream = ConnectionDatabase.class
					.getResourceAsStream("./connection.properties"); **/
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection(url,
					prop.getProperty("db.username"),
					prop.getProperty("db.password"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
