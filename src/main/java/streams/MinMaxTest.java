package streams;

import static model.Student.student;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.Student;
import util.Imc;

public class MinMaxTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Student s1 = student().id(1L).name("Bia").gender('F').weight(50)
				.height(1.5F).score(9.5).birthDate(LocalDate.now().minusYears(15)).build();
		Student s2 = student().id(2L).name("Luna").gender('F').weight(53)
				.height(1.8F).score(9).birthDate(LocalDate.now().minusYears(16)).build();
		Student s3 = student().id(3L).name("Ariel").gender('F').weight(72)
				.height(1.68F).score(7).birthDate(LocalDate.now().minusYears(13)).build();
		Student s4 = student().id(4L).name("Abel").gender('F').weight(48)
				.height(1.53F).score(10).birthDate(LocalDate.now().minusYears(14)).build();
		Student s5 = student().id(5L).name("Peter").gender('M').weight(82)
				.height(1.78F).score(5).birthDate(LocalDate.now().minusYears(15)).build();
		Student s6 = student().id(6L).name("Claus").gender('M').weight(73)
				.height(1.85F).score(7.5).birthDate(LocalDate.now().minusYears(16)).build();
		Student s7 = student().id(7L).name("Muriel").gender('M').weight(96)
				.height(1.68F).score(6).birthDate(LocalDate.now().minusYears(17)).build();
		Student s8 = student().id(8L).name("Joy").gender('M').weight(68)
				.height(1.64F).score(10).birthDate(LocalDate.now().minusYears(18)).build();
		
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
		
		Comparator<Student> bestScore = (st1, st2) -> {
			if (st1.getScore() > st2.getScore())
				return 1;
			if (st1.getScore() < st2.getScore())
				return -1;
			if (st1.getAge() > st2.getAge())
				return 1;
			if (st1.getAge() < st2.getAge())
				return -1;
			return 0;
		};
		
		Comparator<Student> worstScore = (st1, st2) -> {
			if (st1.getScore() > st2.getScore())
				return -1;
			if (st1.getScore() < st2.getScore())
				return 1;
			if (st1.getAge() > st2.getAge())
				return 1;
			if (st1.getAge() < st2.getAge())
				return -1;
			return 0;
		};
		
		Comparator<Student> compareIMC = new Comparator<>() {
			
			@Override
			public int compare(Student s1, Student s2) {
				return Double.compare(Imc.calcImc(s1), Imc.calcImc(s2));
			}
		};
		
		console.println("\n---<max>---");
		list.stream().max(bestScore).ifPresent(console::println);
		list.stream().max(worstScore).ifPresent(console::println);
		
		console.println("\n---<max reverser>---");
		list.stream().max(bestScore.reversed()).ifPresent(console::println);
		list.stream().max(worstScore.reversed()).ifPresent(console::println);
		
		console.println("\n---<min>---");
		list.stream().min(bestScore).ifPresent(console::println);
		list.stream().min(worstScore).ifPresent(console::println);
		
		console.println("\n---<min reversed>---");
		list.stream().min(bestScore.reversed()).ifPresent(console::println);
		list.stream().min(worstScore.reversed()).ifPresent(console::println);
		
		console.println("\n---<compareIMC>---");
		list.stream().max(compareIMC).ifPresent(console::println);
		list.stream().min(compareIMC).ifPresent(console::println);
		
		console.close();
	}
	
}
