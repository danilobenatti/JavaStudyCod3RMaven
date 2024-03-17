package extra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class FtpFileUpload {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(FtpFileUpload.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		FTPClientConfig config = new FTPClientConfig();
		config.setServerLanguageCode("pt");
		config.setDefaultDateFormatStr("d MMM yyyy");
		config.setRecentDateFormatStr("d MMM HH:mm");
		config.setServerTimeZoneId("America/Sao_Paulo");
		
		Map<String, String> envValues = System.getenv();
		
		File localFile = new File("./src/extra/test.txt");
		String remoteFile = "public_ftp/incoming/test.txt";
		
		FTPClient ftpClient = new FTPClient();
		
		try (FileInputStream inputStream = new FileInputStream(localFile)) {
			if (!ftpClient.isConnected()) {
				ftpClient.connect(envValues.get("FTP_URL"), 21);
			}
			ftpClient.configure(config);
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.setAutodetectUTF8(true);
			ftpClient.setBufferSize(1024);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			if (ftpClient.login(envValues.get("USER"), envValues.get("PASS"))) {
				log.printf(Level.INFO, "Successfully connect: %s (%sms)",
						ftpClient.getStatus(), ftpClient.getConnectTimeout());
			}
			boolean isDone = ftpClient.storeFile(remoteFile, inputStream);
			if (isDone) {
				log.info("Uploaded successfully.");
			}
		} catch (IOException ex) {
			log.printf(Level.INFO, "Error: %s", ex.getMessage());
		} finally {
			try {
				if (ftpClient.isConnected()) {
					if (ftpClient.logout())
							log.info("Logout from FTP.");
					ftpClient.disconnect();
					log.info("Disconnect from FTP.");
				}
			} catch (IOException ex) {
				log.printf(Level.INFO, "Error: %s", ex.getMessage());
			}
		}
	}
}
