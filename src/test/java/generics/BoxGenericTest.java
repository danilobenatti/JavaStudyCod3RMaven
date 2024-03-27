package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BoxGenericTest {
	
	@Test
	void BoxTest() {
		
		BoxGeneric<String> box = new BoxGeneric<>();
		
		box.setAnyThing("123");
		
		assertEquals("123", box.getAnyThing());
	}
	
}
