package collection_structure;

import static model.Customer.customer;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import model.Customer;

public class HashSetCode {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		HashSet<Customer> customers = new HashSet<>();
		
		var c1 = customer().id(1).name("Cloe").email("cloe@mail.com").build();
		var c2 = customer().id(2).name("Mary").email("mary@pmail.rt").build();
		var c3 = customer().id(3).name("Joy").email("yoj@kmail.yp").build();
		
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		customers.forEach(console::println);
		
		console.println();
		
		Set<Customer> treeSet = new TreeSet<>(new CustomerCompareById());
		
		var c4 = customer().id(4).name("Peter").email("p3t3r@mail.com").build();
		
		treeSet.addAll(customers);
		treeSet.add(c4);
		
		treeSet.forEach(console::println);
		
		var cli = customer().id(1).name("Cloe").email("cloe@mail.com").build();
		
		console.println(customers.size());
		console.println(customers.contains(cli));
		console.println(customers.remove(c1));
		console.println(customers.contains(cli));
		console.println(customers.size());
		
		Set<Customer> set = new HashSet<>();
		set.addAll(customers);
		
		set.forEach(console::println);
		
		console.close();
	}
	
	public static class CustomerCompareById implements Comparator<Customer> {
		
		@Override
		public int compare(Customer c1, Customer c2) {
			return Long.compare(c1.getId(), c2.getId());
		}
	}
	
}

