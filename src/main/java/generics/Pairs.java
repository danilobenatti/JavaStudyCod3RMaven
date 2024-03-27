package generics;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Pairs<K extends Number, V> {
	
	private final Set<Pair<K, V>> items = new LinkedHashSet<>();
	
	public void add(K key, V value) {
		if (key == null)
			return; // conditional exit of method
		Pair<K, V> pair = new Pair<>(key, value);
		if (this.items.contains(pair)) {
			this.items.remove(pair);
		}
		this.items.add(pair);
	}
	
	public V getValue(K key) {
		if (key == null)
			return null;
		Optional<Pair<K, V>> optional = this.items.stream()
				.filter(p -> key.equals(p.getKey())).findFirst();
		return optional.isPresent() ? optional.get().getValue() : null;
	}
	
}
