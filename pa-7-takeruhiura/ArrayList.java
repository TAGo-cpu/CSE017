/**
 * this is a class for the array list that was modified so there are new methods in the class
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/30
 */


import java.util.Iterator;
import java.util.Comparator;

/**
    Generic class to impelment an array based list
 */
public class ArrayList<E> implements List<E>{
   // data member: array for the list elements
   private E[] elements;
   // data member: size of the list
   private int size;
   /**
        Default constructor creates the array with a default length of 10 and sets size to 0
        Time complexity: O(1)
    */
   public ArrayList() {
	   elements = (E[]) new Object[10];
	   size = 0;
   }
   /**
        Constructor with one parameter creates the array with length equal to capacity and sets size to 0
        @param capacity length of the arrat elements
        Time complexity: O(1)
    */
   public ArrayList(int capacity) {
     elements = (E[]) new Object[capacity];
     size = 0;
   }
   /**
        Get the size of the list
        @return the number of elements in the list
        Time complexity: O(1)
     */
    public int size() {
      return size; 
    }
    /**
        Clear the list by setting size to 0
        Time complexity: O(1)
     */
    public void clear() {
      size = 0; 
    }
    /**
        Predicate to check if the list is empty
        @return true if the list is empty, false otherwise
        Time complexity: O(1)
     */
    public boolean isEmpty() {
      return (size == 0);
    }
   /**
        Method to add a new item at the end of the list
        @param item the value of the item to be added
        @return true if item was added successfully, false otherwise
        Time complexity: O(1) or O(n) if the array capacity needs to grow
    */
    public boolean add(E item) {
		  add(size, item);
          return true;
    }
    /**
        Method to add a new item at a given position index
        @param index the position where item should be added
        @param item the value of the element to be added
        @return true if item was added successfully, false otherwise
        @throws ArrayIndexOutOfBoundsException if index < 0 or index > size
        Time complexity: O(n)
    */
    public void add(int index, E item){
      if(index > size || index < 0)
        throw new ArrayIndexOutOfBoundsException();
      ensureCapacity();
      for(int i=size-1; i>=index; i--){
        elements[i+1] = elements[i];
      }
      elements[index] = item;
      size++;
    }
    /**
     * Linear search method
     * @param o the object being searched
     * @return true if o was found in this list, false otherwise
     * Time complexity: O(n)
     */ 
    public boolean contains(Object o){
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
            E element = iter.next();
            if(element.equals(o)){
                return true;
            }
        }
        return false;
    }
    /**
        Get the value of the element at index
        @param index of the element being accessed
        @return the value of the element at index
        @throws ArrayIndexOutofBounds if index < 0 or index >= size
        Time complexity: O(1)
     */
    public E get(int index) {
		  checkIndex(index);
		  return elements[index];
    }
    /**
        Set the value of the element at index
        @param index of the element being modified
        @param value new value of the element at index
        @return the old value of the element at index
        @throws ArrayIndexOutofBounds if index < 0 or index >= size
        Time complexity: O(1)
     */
    public E set(int index, E newValue) {
		  checkIndex(index);
		  E oldValue = elements[index];
		  elements[index] = newValue;
		  return oldValue;
    }
    /**
     * Remove an object from the list
     * @param o the object to remove from the list
     * @return true if o was found and removed or false if o was not found
     * Time complexity: O(n)
     */
    public boolean remove(Object o){
        for(int i=0; i<size; i++){
            if(elements[i].equals(o)){
                remove(i); 
                return true;
            }
        }
        return false;
    }
    /**
        Remove the element at a given index
        @param index the position of the element to be removed
        @return true if the elements was removed successfully, false otherwise
        @throws ArrayIndexOutofBoundsException if index < 0 or index >= size
        Time complexity: O(n)
     */
    public E remove(int index) {
      checkIndex(index);
      E val = elements[index];
      for(int i=index; i<size-1; i++){
			elements[i] = elements[i+1];
      }
      size--;
      return val;
    }
    /**
        Resize the length of the array 'elements' to the size of the list
        Time complexity: O(n) if trimming needed
     */
    public void trimToSize() {
		  if (size != elements.length) {
			    E[] newElements = (E[]) new Object[size];
			    for(int i=0; i<size; i++)
				    newElements[i] = elements[i];
			    elements = newElements;
		  }
    }
    /**
        Grow the length of the array 'elements' by 1.5 if it is full
        Time complexity: O(n) if the size reaches the capacity
    */
    private void ensureCapacity() {
	    if(size >= elements.length) {
          int newCap = (int) (elements.length * 1.5);
		      E[] newElements = (E[]) new Object[newCap];
		      for(int i=0; i<size; i++){
				    newElements[i] = elements[i];
              }
		      elements = newElements;
	    }
    }
    /**
        Check if the index is valid
        @param index to be checked
        @throws ArrayIndexOutOFBoundsException is index is out of bounds
        Time complexity: O(1)
     */
    private void checkIndex(int index){
		  if(index < 0 || index >= size)
			    throw new ArrayIndexOutOfBoundsException(
              "Index out of bounds. Must be between 0 and "+(size-1));
    }
    
    /**
        @override iterator() from the interface Collection
        @return iterator object pointing to the first element the list
        Time complexity: O(1)
     */
    public Iterator<E> iterator(){
		  return new ArrayIterator();
    }
    /**
        Inner class to implement the interface Iterator<E>
     */
    private class ArrayIterator implements Iterator<E>{
        // data member current: the index of the element at which the iterator is pointing
	    private int current = 0;
        /**
            @return true if current did not reach the end of the list, false otherwise
            Time complexity: O(1)
         */
	    public boolean hasNext() {
            return current < size; 
        }
        /**
            @return the value of the current element and moves the index current to the next element
            @throws ArrayIndexOutOfBoundsException if current is out of bounds
            Time complexity: O(1)
         */
	    public E next() {
            if(current < 0 || current >= size)
              throw new ArrayIndexOutOfBoundsException("No more elements");
            return elements[current++]; 
        }
    } 
    /**
        @override toString() from class Object
        @return a formatted string containing the elements of the list
        Time complexity: O(n)
     */
    public String toString() {
		  String output = "[";
		  for(int i=0; i<size-1; i++)
			    output += elements[i] + " ";
		  output += elements[size-1] + "]";
		  return output;
    }

    
    //time complexity O(n) or O(n^2) when add is O(n)
    /**
     * this is a method used to add all the items in a collection into an array list
     */
    public boolean addAll(Collection<E> c) {
        Iterator<E> iterator = c.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            add(element);
        }
        return true;
    }
    
    
    

    //time complexity O(n)
    /**
     * this is a method used to see if an object equals the collection that the method is called with 
     */
    public boolean equals(Object o){
        if(o instanceof List){
            List<E> l = (List<E>)o;
            if(l.size() != this.size()){
                return false;
            }else{
                Iterator<E> iter1 = this.iterator();
                Iterator<E> iter2 = l.iterator();
                while(iter1.hasNext()){
                    if(!iter1.next().equals(iter2.next())){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    //time complexity O(n)
    /**
     * this is a method that is used to return the index of an object
     */
    public int indexOf(Object o){
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).equals(o)){
                return i;
            }
        }
        return -1;
    }

    //time complexity O(n)
    /**
     * this is a method used to get the last index of an object in a list
     */
    public int lastIndexOf(Object o){
        for(int i = this.size()-1; i > -1; i--){
            if(this.get(i).equals(o)){
                return i;
            }
        }
        return -1;
    }

    //time complexiy O(n)
    /**
     * this is a method used to convert a list into an array
     */
    public Object[] toArray(){
        Object[] array = new Object[this.size()];
        for(int i = 0; i < this.size(); i++){
            array[i] = this.get(i);
        }
        return array;
    }


    //time complexity O(n^2)
    /**
     * this is a method used to sort a list using selection sort
     */
    public void sort(Comparator<E> c) {
        for (int i = 0; i < this.size() - 1; i++) {
            int indexSmallest = i;
            for (int j = i + 1; j < this.size(); j++) {
               if (c.compare(this.get(j), this.get(indexSmallest)) < 0) {
                  indexSmallest = j;
               }
            }
            E temp = this.get(i);
            this.set(i, get(indexSmallest));
            this.set(indexSmallest, temp);
         }

    }
    
    
    public void reverse(){
        List<E> tempList = new ArrayList();
        Iterator<E> iter = this.iterator();
        int i = size();
        while(iter.hasNext()){
            E element = iter.next();
            tempList.add(i,element);
            i--;

            }

        clear();
        addAll(tempList);
    }

}