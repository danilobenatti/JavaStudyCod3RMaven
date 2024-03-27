package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {
	
	List<String> langs = Arrays.asList("Java", "C#", "JavaScript", "PHP");
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
	
	@Test
	void GetLast1Test() {
		
		String lang = (String) ListUtil.getLast1(langs);
		assertEquals("PHP", lang);
		
		Integer number = (Integer) ListUtil.getLast1(numbers);
		assertEquals(6, number);
	}
	
	@Test
	void GetLast2Test() {
		
		String lang = ListUtil.getLast2(langs);
		assertEquals("PHP", lang);
		
		Integer number = ListUtil.getLast2(numbers);
		assertEquals(6, number);
	}
	
}
