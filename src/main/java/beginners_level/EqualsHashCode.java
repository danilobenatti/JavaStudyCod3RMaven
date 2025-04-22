package beginners_level;

import java.io.PrintWriter;
import java.time.LocalDate;

import model.Customer;

public class EqualsHashCode {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		var c1 = Customer.customer().id(1).name("John").email("john@mail.com")
				.birthDate(LocalDate.now().minusYears(47)).build();
		c1.killPersonNow();
		
		Customer c2 = c1;
		c2.setName("John");
		c2.setEmail("jhon99@mail.com");
		c2.setGoodPayer(false);
		//c2.setBornDate(LocalDate.now().minusYears(32).minusMonths(5));
		
		Customer c3 = new Customer();
		c3.setId(1);
		c3.setName("Jhon");
		c3.setEmail("jhon@email.com");
		
		console.printf("1) %s%n", c1);
		console.printf("2) %s%n", c2);
		console.printf("3) %s%n", c3);
		
		console.printf("c1 == c2? %s%n", c1 == c2);
		console.printf("c1 equals c2? %s%n", c1.equals(c2));
		
		console.printf("c3 == c1? %s%n", c3 == c1);
		console.printf("c3 equals c1? %s%n", c3.equals(c1));
		
		console.printf("c3 == c2? %s%n", c3 == c2);
		console.printf("c3 equals c2? %s%n", c3.equals(c2));
		
		console.close();
	}
	
}
