/**
 * this is a class for arrayList which implements a heap algorithm to sort the list
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/11
 */
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.PriorityQueue;

/**
    Generic class to impelment an array based list
 */
public class ArrayList<E>{
  public static int containsIterations, removeIterations, addIterations;
  public static int sortIterations = 0;

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
        Method to add a new item at the end of the list
        @param item the value of the item to be added
        @return true if item was added successfully, false otherwise
        Time complexity: O(1) or O(n) if the array capacity needs to grow
    */
    public boolean add(E item) {
		  return add(size, item);
    }

    //Time complexity: O(n)
    /**
        Method to add a new item a given position index
        @param index the position where item should be added
        @param item the value of the element to be added
        @return true if item was added successfully, false otherwise
        @throws ArrayIndexOutOfBoundsException if index < 0 or index > size
    */
    public boolean add(int index, E item){
      if(index > size || index < 0)
        throw new ArrayIndexOutOfBoundsException();
      addIterations = 0;
      ensureCapacity();
      for(int i=size-1; i>=index; i--){
        addIterations++;
        elements[i+1] = elements[i];
      }
      elements[index] = item;
      size++;
      return true;
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
        Remove the element at a given index
        @param index the position of the element to be removed
        @return true if the elements was removed successfully, false otherwise
        @throws ArrayIndexOutofBoundsException if index < 0 or index >= size
        Time complexity: O(n)
     */
    public boolean remove(int index) {
      checkIndex(index);
      for(int i=index; i<size-1; i++){
        removeIterations++;
			  elements[i] = elements[i+1];

      }
      size--;
      return true;
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
            addIterations++;
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

    //time complexity O(n)
    /**
     * this is a method used to find an object in the list
     * @param o this is the object that is trying to be looked for
     * @return returns a boolean true if found and false otherwise
     */
    public boolean contains(Object o){
      containsIterations = 0;
      Iterator<E> iter = this.iterator();
      while(iter.hasNext()){
        containsIterations++;
        E element = iter.next();
        if(element.equals(o)){
          return true;
        }
      }
      return false;
    }

    //time complexity O(n)
    /**
     * this is a method used to remove an object from a list and returns a boolean depending on if it was removed or not
     * @param o this is the object that is trying to be removed
     * @return returns true if the object was found and removed and false if not 
     */
    public boolean remove(Object o){
      removeIterations = 0;
      for(int i = 0; i < size; i++){
        removeIterations++;
        if(elements[i].equals(o)){
          remove(i);
          return true;
        }
      }
      return false;
    }

    //time complexity: O(nlog(n))
    /**
     * this is a method used to sort the list using a heap sort algorithm with a MinHeap object
     * @param comp this is the comparator used to determine how to sort the list
     */
    public void sort(Comparator<E> comp){
        sortIterations = 0;
        MinHeap<E> heap = new MinHeap<>(comp);
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
          sortIterations++;
          heap.add(iter.next());
          sortIterations += MinHeap.addIterations;
        }
        this.clear();
        while (!heap.isEmpty()) {
          sortIterations++;
            this.add(heap.remove());
            sortIterations += MinHeap.removeIterations;

        }
    }


}