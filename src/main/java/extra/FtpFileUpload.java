package extra;

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class FtpFileUpload {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(FtpFileUpload.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Map<String, String> envValues = System.getenv();
		
		File localFile = new File("./src/main/java/extra/test.txt");
		String remoteFile = "public_ftp/incoming/test.txt";
		
		FTPClient ftpClient = new FTPClient();
		
		FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
		config.setServerLanguageCode("pt");
		config.setDefaultDateFormatStr("d MMM yyyy");
		config.setRecentDateFormatStr("d MMM HH:mm");
		config.setServerTimeZoneId("America/Sao_Paulo");
		
		try (FileInputStream inputStream = new FileInputStream(localFile)) {
			if (!ftpClient.isConnected()) {
				ftpClient.connect(envValues.get("URL"), 21);
				int reply = ftpClient.getReplyCode();
				if (!FTPReply.isPositiveCompletion(reply)) {
					ftpClient.disconnect();
					log.error("FTP server refused connection.");
				}
			}
			ftpClient.configure(config);
			ftpClient.setDataTimeout(Duration.ofMinutes(2));
			ftpClient.setControlKeepAliveTimeout(Duration.ofMinutes(1));
			ftpClient.setKeepAlive(true);
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.setAutodetectUTF8(true);
			ftpClient.setBufferSize(1024);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			if (ftpClient.login(envValues.get("USER"), envValues.get("PASS"))) {
				log.info(StringUtils.joinWith(SPACE, "Successfully connect:",
						ftpClient.getStatus(), ftpClient.getSystemType(),
						"(" + ftpClient.getConnectTimeout() + ")",
						ftpClient.getRemoteAddress()));
				if (ftpClient.storeFile(remoteFile, inputStream))
					log.info("Uploaded successfully.");
			} else {
				log.error("Login refused");
			}
		} catch (IOException ex) {
			log.error("Error: %s", ex.getMessage());
		} finally {
			try {
				if (ftpClient.isConnected()) {
					if (ftpClient.logout())
						log.info("Logout from FTP.");
					ftpClient.disconnect();
					log.info("Disconnect from FTP.");
				}
			} catch (IOException ex) {
				log.error("Error: %s", ex.getMessage());
			}
		}
	}
}
