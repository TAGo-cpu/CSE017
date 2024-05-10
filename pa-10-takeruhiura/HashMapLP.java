/**
 * this is a class for the HashMapLP which is for linear probing
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/28
 */

import java.util.ArrayList;
/**
 * Class HashMap: An implementation of the hash table using separate chaining
 */
public class HashMapLP<K, V> extends HashMap<K, V>{
    // data members
	private int size;
	private MapEntry<K,V>[] hashTable;
	public static int collisions;
	public static int getIterations;
	public static int removeIterations;

    /**
     * Default constructor 
     * default capacity: 100
     * default load factor: 0.9
	 * Time complexity: O(1)
     */
	public HashMapLP() {
		this(100, 0.9);
		collisions = 0;
	}
    /**
     * Constructor with one parameter
     * @param c for the capacity
     * default load factor: 0.9
	 * Time complexity: O(log n)
     */
	public HashMapLP(int c) {
		this(c, 0.9);
		collisions = 0;
	}
    /**
     * Constructor with two parameters
     * @param c for the capacity
     * @param lf for the load factor
	 * Time complexity: O(log n)
     */
	public HashMapLP(int capacity, double lf) {
		super(lf);
		hashTable = new MapEntry[trim2PowerOf2(capacity)];
		collisions = 0;
	}

    /**
     * Method hash
     * @param hashCode
     * @return a valid index in the hashtable
	 * Time complexity: O(1)
     */
    protected int hash(int hashCode) {
		return hashCode & (hashTable.length-1);
	}
    /**
     * Method size
     * @return the number of pairs (key,value) stored the hashtable
	 * Time complexity: O(1)
     */
	public int size() {
		return size;
	}
    /**
     * Method clear to clear the hashtable
	 * Time complexity: O(n)
     */
	public void clear() {
		size = 0;
		for(int i=0; i<hashTable.length; i++)
			hashTable[i] = null;
	}


    /**
     * Method get to find an entry in the hashtable
     * @param key the value of the key being searched for
     * @return the value associated with the key if key is found, null otherwise
     */
	public V get(K key) {
		getIterations = 0;
		int HTIndex = hash(key.hashCode());
		if(hashTable[HTIndex] != null) {
			MapEntry<K,V> entry = hashTable[HTIndex];
			while(entry != null){
				getIterations++;
				if(entry.getKey().equals(key))
					return entry.getValue();
				HTIndex = (HTIndex +1) & (hashTable.length-1);
				entry = hashTable[HTIndex];
		}
		}
		return null;
	}
    /**
     * Method remove to remote an entry from the hashtable
     * @param key the key to be removed
     * if the key is found, the pair (key and it associated value) will be removed from the hashtable
     * the hashtable is not modified if key is not found
     */
	public void remove(K key) {
		removeIterations = 0;
		ArrayList<MapEntry<K,V>> list = new ArrayList<>();
		int HTIndex = hash(key.hashCode());
		while (hashTable[HTIndex]!= null) { //key is in the hash map
			removeIterations++;
			MapEntry<K, V> entry = hashTable[HTIndex];
			if(entry.getKey().equals(key)){
				hashTable[HTIndex] = null;
				size--;
				HTIndex = (HTIndex +1) & (hashTable.length-1);
				entry = hashTable[HTIndex];
				while(entry != null){
					removeIterations++;
					list.add(entry);
					hashTable[HTIndex] = null;
					size--;
					HTIndex = (HTIndex +1) & (hashTable.length-1);
					entry = hashTable[HTIndex];
				}
			for(MapEntry<K,V> item: list){
				removeIterations++;
				this.put(item.getKey(), item.getValue());

				}	
				break;
			}
			HTIndex = (HTIndex +1) & (hashTable.length-1);
		}
	}
    /**
     * Method put to add a new entry to the hashtable
     * @param key the value of the key of the new entry
     * @param value the value associated with the key
     * @return the old value of the entry if an entry is found for key
     *         or the new value if a new entry was added to the hashtable
	 * Time complexity: O(1) on average, but can reach O(n) if rehashing is required
     */
	public V put(K key, V value) {
		if (get(key) != null) {
			int HTIndex = hash(key.hashCode());
			MapEntry<K, V> entry = hashTable[HTIndex];
			while(entry != null){
			if (entry.getKey().equals(key)) {
				V old = entry.getValue();
				entry.setValue(value);
				return old;
			}
			HTIndex = (HTIndex +1) & (hashTable.length-1);
			entry = hashTable[HTIndex];
			}

		}
		if (size >= hashTable.length * loadFactor)
			rehash(); // O(n)
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex] == null) {
			hashTable[HTIndex] = new MapEntry<>(key, value);
		} else {
			while (hashTable[HTIndex] != null) {
				HTIndex = (HTIndex +1) & (hashTable.length-1);
			}
			hashTable[HTIndex] = new MapEntry<>(key, value);
			collisions++;
		}
		size++;
		return value;
	}



    /**
     * Method rehash
     * creates a new hashtable with double capacity
     * puts all the entries from the old hashtable into the new table
	 * Time complexity: O(n)
     */
	protected void rehash() {
		ArrayList<MapEntry<K,V>> list = toList(); 
		hashTable = new MapEntry[hashTable.length << 1];
		size = 0;
		for(MapEntry<K,V> entry: list){
			put(entry.getKey(), entry.getValue());

		}
		
	}
    /**
     * Method toList
     * @return an arraylist with all the entries in the hashtable
	 * Time complexity: O(n)
     */
	public ArrayList<MapEntry<K,V>> toList(){
		ArrayList<MapEntry<K,V>> list = new ArrayList<>();
		for(int i=0; i< hashTable.length; i++) {
			if(hashTable[i]!= null) {
				MapEntry<K,V> entry = hashTable[i];
				list.add(entry);
			}
		} 
		return list;
	}
    /**
     * Method toString
     * @return a formatted string with all the entries in the hashtable
	 * Time complexity: O(n)
     */
	public String toString() {
		String out = "[";
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				MapEntry<K,V> entry = hashTable[i];
				out += entry.toString();
				out += "\n";
			}
		}
		out += "]"; 
		return out;
	}


	public ArrayList<V> values(){
		ArrayList<V> list = new ArrayList<>();
		for(int i=0; i< hashTable.length; i++) {
			if(hashTable[i]!= null){
				MapEntry<K,V> entry = hashTable[i];
				list.add(entry.getValue());
			}
		} 
		return list;
	}

public void printCharacteristics() {
    System.out.println("Hash Table capacity: " + hashTable.length);
	System.out.println("Hash Table size: " + size());
	System.out.println("Total number of collisions: " + collisions);

	int clusters = 0;
	int smallest = hashTable.length;
	int largest = 0;
	int size = 0;

	for (int j= 0; j < hashTable.length; j++) {
		size = 0;
		if(hashTable[j] != null){
		clusters++;
		while(hashTable[j] != null){
			size++;
			j++;
		}
		if(size > largest ){
			largest = size;
		}
		else if(size < smallest){
			smallest = size;
		}

		}

	}
	System.out.println("Number of clusters: " + clusters);
	System.out.println("Size of the largest cluster: " + largest);
	System.out.println("Size of the smallest cluster: " + smallest);

	
}


}
