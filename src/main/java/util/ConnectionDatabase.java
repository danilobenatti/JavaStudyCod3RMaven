package util;

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
	
	private static BasicDataSource bds;
	
	private static Properties getProperties() {
		Properties props = new Properties();
		try (FileInputStream input = new FileInputStream(
				new File("./src/main/java/util/connection.properties"))) {
			props.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
	public static BasicDataSource getDataSource() {
		Properties props = getProperties();
		if (bds == null || bds.isClosed()) {
			bds = new BasicDataSource();
			bds.setUrl(props.getProperty("db.url"));
			bds.setDefaultSchema(props.getProperty("db.schema"));
			bds.setUsername(props.getProperty("db.username"));
			bds.setPassword(props.getProperty("db.password"));
			bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			bds.setConnectionProperties(String.join(";", USESSL, SSLMODE,
					CERTIFICATE, ENCODING, TIMEZONE));
			bds.setDefaultAutoCommit(true);
			bds.setInitialSize(3);
			bds.setMinIdle(3);
			bds.setMaxIdle(8);
			bds.setMaxTotal(8);
		}
		log.info(() -> "Start conn: ".concat(bds.getDefaultSchema()));
		return bds;
	}
	
	public static Connection getConnection() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
