/**
 * this is a class that is for a map entry in the tree with a pair of values 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/17
 */
public class MapEntry<K,V>{

private K key;
private V value;

/**
 * this is a constructor for a map entry
 * @param k this is the key for the entry
 * @param v this is the value for the entry
 */
public MapEntry(K k, V v){
    key = k;
    value = v;
}

/**
 * this is a method used to get the key of an entry
 * @return this returns a K value
 */
public K getKey(){
    return key;
}

/**
 * this is a method used to get the value of an entry
 * @return this returns a V value
 */
public V getValue(){
    return value;
}

/**
 * this is a method used to set the key of an entry
 * @param k this is a parameter of value K used to set the key
 */
public void setKey(K k){
    key = k;
}

/**
 * this is a method used to set the value of an entry
 * @param V this is a parameter of value V used to set the value
 */
public void setValue(V v){
    value = v;
}

/**
 * this is a method used to return a string for an etnry
 */
@Override
public String toString(){
 return "("+ key + ","  + value + ")";
}


}