/**
 * this is an abstract class for the HashMap 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/28
 */


import java.util.ArrayList;
/**
 * Class HashMap: An implementation of the hash table using separate chaining
 */
public abstract class HashMap <K, V> {
	protected double loadFactor;

	protected HashMap(double lf) {
		loadFactor = lf;
	}

	protected int trim2PowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity  = capacity << 1;
		return capacity;
	}

	protected abstract int hash(int hashCode);

	protected abstract void rehash();

	public boolean isEmpty() {
		return size() == 0;
	}
	

	public boolean containsKey(K key) {
		if(get(key) != null)
			return true;
		return false;
	}

	public abstract void clear();

	public abstract V get(K key);

	public abstract int size();

	public abstract void remove(K key);

	public abstract V put(K key, V value);

	public abstract ArrayList<MapEntry<K, V>> toList();

	public abstract ArrayList<V> values();

	public abstract void printCharacteristics();
	
}
