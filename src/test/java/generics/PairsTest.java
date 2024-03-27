package generics;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PairsTest {
	
	@Test
	void ParesTest1() {
		
		Pairs<Integer, String> result = new Pairs<>();
		
		result.add(1, "Mary");
		result.add(2, "Peter");
		result.add(3, "Gui");
		result.add(4, "Anna");
		result.add(1, "Gaya");
		result.add(2, "Rebecca");
		
		assertEquals("Gaya", result.getValue(1));
		assertNotEquals("Peter", result.getValue(2));
	}
	
}
