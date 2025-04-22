package collection_structure;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import model.Person;

public class StringTreeSet {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Set<String> set = new TreeSet<>();
		
		set.add("abcxyz");
		set.add("xyzabcde");
		set.add("defzzzzzzzzzzz");
		set.add("mno");
		
		for (String str : set)
			console.println(str);
		
		Person p1 = Person.person().id(1).name("Cloe").gender('F')
				.birthDate(LocalDate.of(2015, Month.MAY, 1)).build();
		Person p2 = Person.person().id(2).name("Peter").gender('M')
				.birthDate(LocalDate.of(2010, Month.NOVEMBER, 15)).build();
		Person p3 = Person.person().id(3).name("Bethy").gender('F')
				.birthDate(LocalDate.of(2020, Month.JANUARY, 21)).build();
		Person p4 = Person.person().id(4).name("John").gender('M')
				.birthDate(LocalDate.of(2007, Month.SEPTEMBER, 30)).build();
		
		SortedSet<Person> approved = new TreeSet<>(new PersonCompareByName());
		approved.add(p1);
		approved.add(p2);
		approved.add(p3);
		approved.add(p4);
		
		approved.forEach(console::println);
		
		console.close();
	}
	
	public static class PersonCompareByName implements Comparator<Person> {
		
		@Override
		public int compare(Person p1, Person p2) {
			return p1.getName().compareToIgnoreCase(p2.getName());
		}
		
	}
	
}

