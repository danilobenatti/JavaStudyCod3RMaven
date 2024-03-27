package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BoxNumberTest {
	
	@Test
	void BoxTest() {
		
		BoxNumber<Double> boxA = new BoxNumber<>();
		boxA.setAnyThing(5.8);
		BoxNumber<Float> boxB = new BoxNumber<>();
		boxB.setAnyThing(5.8F);
		
		assertEquals(5.8, boxA.getAnyThing());
		assertEquals(5.8F, boxB.getAnyThing());
	}
	
}
