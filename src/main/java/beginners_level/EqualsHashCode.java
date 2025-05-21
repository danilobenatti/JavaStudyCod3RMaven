package beginners_level;

import java.io.PrintWriter;
import java.time.LocalDate;

import model.Customer;
import model.util.PersonUtil;

public class EqualsHashCode {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Customer c1 = Customer.customer().id(1L).name("John").gender('M')
				.email("john@mail.com")
				.birthDate(LocalDate.now().minusYears(47)).build();
		PersonUtil.personDiedNow(c1);
		
		Customer c2 = c1;
		c2.setName("John2");
		c2.setEmail("jhon99@mail.com");
		c2.setGoodPayer(false);
		c2.setBirthDate(LocalDate.now().minusYears(32).minusMonths(5));
		
		Customer c3 = new Customer();
		c3.setId(1L);
		c3.setName("Jhon");
		c3.setEmail("jhon@email.com");
		c3.setLastPurchaseDate(LocalDate.now().minusMonths(2));
		c3.setBirthDate(LocalDate.now().minusYears(28).minusMonths(8));
		
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
