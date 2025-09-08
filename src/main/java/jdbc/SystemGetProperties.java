package jdbc;

import java.io.PrintWriter;

public class SystemGetProperties {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out);
		
		String osArch = System.getProperty("os.arch");
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		String fileSep = System.getProperty("file.separator");
		String userTimezone = System.getProperty("user.timezone");
		String userCountryFormat = System.getProperty("user.country.format");
		String userCountry = System.getProperty("user.country");
		String userHome = System.getProperty("user.home");
		String userLanguage = System.getProperty("user.language");
		 
		console.println("operating system name: " + osName);
		console.println("operating system arch: " + osArch);
		console.println("Operation System version: " + osVersion);
		console.println("file separator: " + fileSep);
		console.println("User Timezone: " + userTimezone);
		console.println("User Country Format: " + userCountryFormat);
		console.println("User Country: " + userCountry);
		console.println("User Home: " + userHome);
		console.println("User Language: " + userLanguage);
		
		System.getProperties().forEach((k, v) -> console.println(k + " -> " + v));
		
		console.flush();
		console.close();
	}
	
}
