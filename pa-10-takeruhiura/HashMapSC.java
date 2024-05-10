/**
 * this is a class for HashMapSC which is for separate chaining 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/28
 */

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Class HashMap: An implementation of the hash table using separate chaining
 */
public class HashMapSC <K, V> extends HashMap<K, V> {
    // data members
	private int size;
	private LinkedList<MapEntry<K,V>>[] hashTable;
	public static int collisions;
	public static int getIterations;
	public static int removeIterations;

    /**
     * Default constructor 
     * default capacity: 100
     * default load factor: 0.9
	 * Time complexity: O(1)
     */
	public HashMapSC() {
		this(100, 0.9);
		collisions = 0;
	}
    /**
     * Constructor with one parameter
     * @param c for the capacity
     * default load factor: 0.9
	 * Time complexity: O(log n)
     */
	public HashMapSC(int capacity) {
		this(capacity, 0.9);
		collisions = 0;

	}
	

	public HashMapSC(int capacity, double lf) {
		super(lf);
		hashTable = new LinkedList[trim2PowerOf2(capacity)];
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
			if(hashTable[i] != null)
				hashTable[i].clear();
		}

    /**
     * Method get to find an entry in the hashtable
     * @param key the value of the key being searched for
     * @return the value associated with the key if key is found, null otherwise
	 * Time complexity: O(1)
     */
	public V get(K key) {
		getIterations = 0;
		int HTIndex = hash(key.hashCode());
		if(hashTable[HTIndex] != null) {
			LinkedList<MapEntry<K,V>> ll = hashTable[HTIndex];
			for(MapEntry<K,V> entry: ll) {
				getIterations++;
				if(entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}
    /**
     * Method remove to remote an entry from the hashtable
     * @param key the key to be removed
     * if the key is found, the pair (key and it associated value) will be removed from the hashtable
     * the hashtable is not modified if key is not found
	 * Time complexity: O(1)
     */
	public void remove(K key) {
		removeIterations = 0;
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex]!=null) { //key is in the hash map
			LinkedList<MapEntry<K,V>> ll = hashTable[HTIndex];
			for(MapEntry<K,V> entry: ll) {
				removeIterations++;
				if(entry.getKey().equals(key)) {
					ll.remove(entry);
					size--;
					break;
				}
			}
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
	    if(get(key) != null) {
		    int HTIndex = hash(key.hashCode());
		    LinkedList<MapEntry<K,V>> ll;
            ll = hashTable[HTIndex];
		    for(MapEntry<K,V> entry: ll) {
			    if(entry.getKey().equals(key)) {
                    V old = entry.getValue();
                    entry.setValue(value); 
                    return old;
			    }
		    }
        }
        if(size >= hashTable.length * loadFactor)
		    rehash(); // O(n)
        int HTIndex = hash(key.hashCode());
        if(hashTable[HTIndex] == null){
		    hashTable[HTIndex] = new LinkedList<>();
        }else{
			collisions++;

		}
        hashTable[HTIndex].add(new MapEntry<>(key, value));
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
		hashTable = new LinkedList[hashTable.length << 1];
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
				LinkedList<MapEntry<K,V>> ll = hashTable[i];
				for(MapEntry<K,V> entry: ll){
					list.add(entry);
				}
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
				for(MapEntry<K,V> entry: hashTable[i])
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
			if(hashTable[i]!= null) {
				LinkedList<MapEntry<K,V>> ll = hashTable[i];
				for(MapEntry<K,V> entry: ll){
					list.add(entry.getValue());
				}
			}
		} 
		return list;
	}

	public void printCharacteristics(){
    System.out.println("Hash Table capacity: " +hashTable.length);
	System.out.println("Hash Table size: " + size());
	System.out.println("Total number of collisions: " + collisions);
	int buckets = 0;
	int largest = 0;
	int smallest = hashTable.length;

	for (int i = 0; i < hashTable.length; i++) {
    if (hashTable[i] != null && !hashTable[i].isEmpty()) {
		buckets++;
		LinkedList<MapEntry<K,V>> ll = hashTable[i];
		if(ll.size() > largest){
			largest = ll.size();
		}
		if(ll.size() < smallest){
			smallest = ll.size();
		}

	}
	else if(hashTable[i] != null){
		buckets++;

	}
	}
	System.out.println("Number of buckets: " + buckets);
	System.out.println("Size of the largest bucket: " + largest);
	System.out.println("Size of the smallest bucket: " + smallest);
	}




}

