package generics;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BoxWithSomeThingsTest {
	
	@Test
	void BoxTest() {
		
		BoxWithSomeThings bwst = new BoxWithSomeThings();
		bwst.setThing(2.3);
		
		assertThrows(ClassCastException.class, () -> {
			@SuppressWarnings("unused")
			Integer thing = (Integer) bwst.getThing();
		});
		
		String string = bwst.toString();
		assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt(string);
		});
	}
}
