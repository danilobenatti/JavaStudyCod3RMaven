package util;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.joinWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectionDatabase {
	
	static Logger log = LogManager.getLogger(ConnectionDatabase.class);
	
	private static final String USESSL = "useSSL=true";
	private static final String SSLMODE = "sslMode=PREFERRED";
	private static final String CERTIFICATE = "verifyServerCertificate=false";
	private static final String ENCODING = "useUnicode=true;connectionCollation=utf8_bin;characterSetResults=utf8;characterEncoding=UTF-8";
	private static final String TIMEZONE = "useTimezone=true;serverTimezone=America/Sao_Paulo";
	
	private static BasicDataSource dataSource;
	
	private static Properties getProperties() {
		Properties prop = new Properties();
		try (FileInputStream input = new FileInputStream(
				new File("./src/main/java/util/connection.properties"))) {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static BasicDataSource getDataSource() {
		Properties prop = getProperties();
		if (dataSource == null || dataSource.isClosed()) {
			dataSource = new BasicDataSource();
			dataSource.setUrl(prop.getProperty("db.url"));
			dataSource.setDefaultSchema(prop.getProperty("db.schema"));
			dataSource.setUsername(prop.getProperty("db.username"));
			dataSource.setPassword(prop.getProperty("db.password"));
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setConnectionProperties(joinWith(";", USESSL, SSLMODE,
					CERTIFICATE, ENCODING, TIMEZONE));
			dataSource.setDefaultAutoCommit(true);
			dataSource.setInitialSize(3);
			dataSource.setMinIdle(3);
			dataSource.setMaxIdle(8);
			dataSource.setMaxTotal(8);
		}
		log.info(() -> join("Start conn: ", dataSource.getDefaultSchema()));
		return dataSource;
	}
	
	public static Connection getDataSourceConnection() throws SQLException {
		return getDataSource().getConnection();
	}
}
