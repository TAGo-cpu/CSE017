import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Class HashMap: An implementation of the hash table using separate chaining
 */
public class HashMap <K, V> {
    // data members
	private int size;
	private double loadFactor;
	private LinkedList<MapEntry<K,V>>[] hashTable;
	public static int iterations = 0;
    /**
     * Default constructor 
     * default capacity: 100
     * default load factor: 0.9
	 * Time complexity: O(1)
     */
	public HashMap() {
		this(100, 0.9);
	}
    /**
     * Constructor with one parameter
     * @param c for the capacity
     * default load factor: 0.9
	 * Time complexity: O(log n)
     */
	public HashMap(int c) {
		this(c, 0.9);
	}
    /**
     * Constructor with two parameters
     * @param c for the capacity
     * @param lf for the load factor
	 * Time complexity: O(log n)
     */
	public HashMap(int c, double lf) {
		hashTable = new LinkedList[trimToPowerOf2(c)];
		loadFactor = lf;
		size = 0;
	}
    /**
    * Method trimToPowerOf2
    * @param c the capacity of the hashtable
    * @return the closest power of 2 to c
	* Time complexity: O(log n)
    */
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity  = capacity << 1;
		return capacity;
	}
    /**
     * Method hash
     * @param hashCode
     * @return a valid index in the hashtable
	 * Time complexity: O(1)
     */
    private int hash(int hashCode) {
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
     * Method isEmpty
     * @return true if the hashtable is empty, false otherwise
	 * Time complexity: O(1)
     */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
     * Method contains to search for a key in the hashtable
     * @param key the value of the key being searched for
     * @return true if key was found, false otherwise
	 * Time complexity: O(1)
     */
	public boolean containsKey(K key) {
		if(get(key) != null)
			return true;
		return false;
	}
    /**
     * Method get to find an entry in the hashtable
     * @param key the value of the key being searched for
     * @return the value associated with the key if key is found, null otherwise
	 * Time complexity: O(1)
     */
	public V get(K key) {
		iterations = 0;
		int HTIndex = hash(key.hashCode());
		if(hashTable[HTIndex] != null) {
			LinkedList<MapEntry<K,V>> ll = hashTable[HTIndex];
			for(MapEntry<K,V> entry: ll) {
				iterations++;
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
		iterations = 0;
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex]!=null) { //key is in the hash map
			LinkedList<MapEntry<K,V>> ll = hashTable[HTIndex];
			for(MapEntry<K,V> entry: ll) {
				iterations++;
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
		iterations = 0;
        // check if the key is already in the hashtable
        // modify its associated value if key is found
	    if(get(key) != null) {
		    int HTIndex = hash(key.hashCode());
		    LinkedList<MapEntry<K,V>> ll;
            ll = hashTable[HTIndex];
		    for(MapEntry<K,V> entry: ll) {
				iterations++;
			    if(entry.getKey().equals(key)) {
                    V old = entry.getValue();
                    entry.setValue(value); 
                    return old;
			    }
		    }
        }
        // key was not found. Check if rehashing is needed before adding a new entry
        if(size >= hashTable.length * loadFactor)
		    rehash(); // O(n)
        // Add a new entry to the hashtable
        int HTIndex = hash(key.hashCode());
        if(hashTable[HTIndex] == null){
		    hashTable[HTIndex] = new LinkedList<>();
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
	private void rehash() {
		ArrayList<MapEntry<K,V>> list = toList(); 
		hashTable = new LinkedList[hashTable.length << 1];
		size = 0;
		for(MapEntry<K,V> entry: list){
			iterations++;
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
			iterations++;
			if(hashTable[i]!= null) {
				LinkedList<MapEntry<K,V>> ll = hashTable[i];
				for(MapEntry<K,V> entry: ll){
					iterations++;
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

	public int collisions(){
		int max = 0;
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null){
				int size = hashTable[i].size();
				if(size > max){
					max = size;
				}
			}
		}
		return max;
	}

	public ArrayList<K> keys(){
		ArrayList<K> keyList = new ArrayList<>();
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				for(MapEntry<K,V> entry: hashTable[i]){
					keyList.add(entry.getKey());
				}


			}
		}
		return keyList;
	}

	public boolean containsValue(V val){
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				for(MapEntry<K,V> entry: hashTable[i]){
					if(entry.getValue().equals(val)){
						return true;
					}
				}


			}
		}
		return false;
	}

}
