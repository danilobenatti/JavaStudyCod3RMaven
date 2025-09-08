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
		
		Properties props = new Properties();
		
		try (FileInputStream inputStream = new FileInputStream(
				new File("./src/main/java/util/connection.properties"))) {
/**			InputStream inputStream = ConnectionDatabase.class
					.getResourceAsStream("./connection.properties"); **/
			props.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(props.getProperty("db.driver"));
			return DriverManager.getConnection(props.getProperty("db.url"),
					props.getProperty("db.username"),
					props.getProperty("db.password"));
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
