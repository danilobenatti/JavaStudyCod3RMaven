package generics;

import java.util.List;

public class ListUtil {
	
	private ListUtil() {
	}
	
	public static Object getLast1(List<?> list) {
		return list.get(list.size() - 1);
	}
	
	public static <T> T getLast2(List<T> list) {
		return list.get(list.size() - 1);
	}
	
}
