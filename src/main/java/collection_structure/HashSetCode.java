package collection_structure;

import static model.Customer.customer;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Customer;

public class HashSetCode {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(HashSetCode.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		HashSet<Customer> customers = new HashSet<>();
		
		var cli1 = customer().id(1).name("Cloe").email("cloe@mail.com").build();
		var cli2 = customer().id(2).name("Mary").email("mary@pmail.rt").build();
		var cli3 = customer().id(3).name("Joy").email("yoj@kmail.yp").build();
		
		customers.add(cli1);
		customers.add(cli2);
		customers.add(cli3);
		
		var customer = customer().id(1).name("Cloe").email("cloe@mail.com")
				.build();
		
		log.info(customers.contains(customer));
	}
	
}
