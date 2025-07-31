package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {
	
	List<String> langs = Arrays.asList("Java", "C#", "JavaScript", "PHP");
	List<Number> numbers = Arrays.asList(1.1, 2L, 3.3F, 4, 5.5, 6F);
	
	@Test
	void GetLast1Test() {
		
		String lang = (String) ListUtil.getLast1(langs);
		assertEquals("PHP", lang);
		
		Number number = (Number) ListUtil.getLast1(numbers);
		assertEquals(Float.valueOf(6), number);
	}
	
	@Test
	void GetLast2Test() {
		
		String lang = ListUtil.getLast2(langs);
		assertEquals("PHP", lang);
		
		Number number = ListUtil.getLast2(numbers);
		assertEquals(6F, number);
	}
	
}
