package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BoxIntTest {
	
	@Test
	void BoxTest() {
		
		BoxInt boxA = new BoxInt();
		
		boxA.setAnyThing(123);
		
		assertEquals(Integer.class, boxA.getAnyThing().getClass());
	}
	
}
