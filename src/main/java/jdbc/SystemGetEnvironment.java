package jdbc;

import java.io.PrintWriter;

public class SystemGetEnvironment {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out);
		
		String url = System.getenv("url");
		String username = System.getenv("username");
		String password = System.getenv("password");
		console.println("URL: " + url);
		console.println("Username: " + username);
		console.println("Password: " + password);
		
		console.flush();
		console.close();
	}
	
}
