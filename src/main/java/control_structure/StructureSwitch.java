package control_structure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import model.Customer;
import model.Employed;
import model.Person;
import model.Student;

public class StructureSwitch {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Employed e1 = new Employed();
		e1.setName("John");
		Customer c1 = new Customer();
		c1.setName("Peter");
		Person p1 = new Person();
		p1.setName("Mary");
		Student s1 = new Student();
		s1.setName("Steve");
		
		List<Person> list = new ArrayList<>();
		list.add(e1);
		list.add(c1);
		list.add(p1);
		list.add(s1);
		
		list.forEach(o -> console.println(whoIs(o)));
		
		console.close();
		
	}
	
	private static String whoIs(Object obj) {
		return switch (obj) {
			case Employed e -> new StringBuilder().append("Is Employed: ").append(e.getName()).toString();
			case Customer c -> new StringJoiner("\s").add("Is Customer:").add(c.getName()).toString();
			case Student s -> String.join("\s", "Is Student:", s.getName());
			case Person p -> StringUtils.join("Is Person: ", p.getName());
			default ->
				throw new IllegalArgumentException("Unexpected value: " + obj);
		};
		
	}
	
}
