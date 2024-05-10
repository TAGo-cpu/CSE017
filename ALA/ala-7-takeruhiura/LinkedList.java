/**
 * this is a class that is used for LinkedList data structure which has additional methods to compare with arraylist
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/12
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
    LinkedList Generic Class
 */
public class LinkedList<E> {
    public static int containsIterations, removeIterations, addIterations;
    // Data members
    private Node head, tail;
    private int size, iterations;
    /**
        Inner class Node
    */
    private class Node {
        E value;
        Node next;
        Node(E initialValue) {
            value = initialValue;
            next = null;
        }
    }
    /**
        Default Constructor
        creates an empty linkedlist
        Time complexity: O(1)
    */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    /**
        Adding a value at the head of the list
        @param value to be added
        @return true if the operation was successful
        Time complexity: O(1)
    */
    public boolean addFirst(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }
    /**
        Adding a value at the tail of the list
        @param value to be added
        @return true if the operation was successful
        Time complexity: O(1)
    */
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }
    /**
        Adding a value at the tail of the list
        calls addLast
        @param value to be added
        @return true if the operation was successful
        Time complexity: O(1)
    */
    public boolean add(E item) {
        return addLast(item);
    }
    /**
        Get the value of the node at the head of the list
        @return value of the node at the head
        @throws NoSuchElementException if the list is empty
        Time complexity: O(1)
    */
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }
    /**
        Get the value of the node at the tail of the list
        @return value of the node at the tail
        @throws NoSuchElementException if the list is empty
        Time complexity: O(1)
     */
    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }
    /**
        Removes the node at the head of the list
        @return true if the remove operation was successful and decrements the size
        @throws NoSuchElementException if the list is empty
        Time complexity: O(1)
     */
    public boolean removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head = head.next;
        if (head == null) // removed the only node in the LL
            tail = null;
        size--;
        return true;
    }
    /**
        Removes the node at the tail of the list
        @return true if the remove operation was successful and decrements the size
        @throws NoSuchElementException if the list is empty
        Time complexity: O(n)
    */
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if (size == 1)
            return removeFirst();
        Node current = head;
        while(current.next != tail){
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
        return true;
    }
    /**
        toString method
        @return a formatted string that contains the values of all the nodes in the list
        Time complexity: O(n)
    */
    public String toString() {
        String output = "[";
        Node node = head;
        while (node != null) {
            output += node.value + " ";
            node = node.next;
        }
        output += "]";
        return output;
    }
    /**
        clear method
        restes size to 0 and head and tail to null
        Time complexity: O(1)
    */
    public void clear() {
        head = tail = null;
        size = 0;
    }
    /**
        isEmpty method
        @return true if the list is empty
        Time complexity: O(1)
    */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
        size method
        @return the number of nodes in the list
        Time complexity: O(1)
    */
    public int size() {
        return size;
    }

    /**
        iterator method
        @override iterator() from the interface Collection
        @return an iterator object pointing to the first value in the list
        Time complexity: O(1)
    */
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    /**
        Inner class that implements the interface Iterator
    */
    private class LinkedListIterator implements Iterator<E> {
        private Node current = head;
        /**
            hasNext method
            @return true if the current is not null
            Time complexity: O(1)
         */
        public boolean hasNext() {
            return (current != null);
        }
        /**
            next method
            @return the value of the node referenced by current and 
                    modifies current to hold the reference of the next node
            @throws NoSuchElementException if current is null
            Time complexity: O(1)
         */
        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }
    }

    //time complexity O(n)
    /**
     * this is a method used to find an object and returns a boolean
     * @param o this is the object that is searched
     * @return returns true if the object is found and false otherwise
     */
    public boolean contains(Object o){
        containsIterations = 0;
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
            containsIterations++;
            iterations++;
          E element = iter.next();
          if(element.equals(o)){
            return true;
          }
        }
        return false;
      }

      //time complexity O(n)
      /**
       * this is a method that removes an object and returns true if the object was found and false otherwise 
       * @param o this is the object that the method is trying to remove
       * @return returns a boolean true if found and removed and false otherwise
       */
      public boolean remove(Object o){
        iterations = 0;
        Node current = head;
        Node previous = null;
        removeIterations = 0;
        while(current != null && !current.value.equals(o)){
            removeIterations++;
            previous = current;
            current = current.next;
        }
        if(current == null){
            return false;
        }
        if(previous == null){
            return removeFirst();
        }
        else{
            previous.next = current.next;
            size--;
        }
        return true;
      }
      //time complexity O(n)
      /**
       * this is a method used to add an item at a position  
       * @param index this is the index to insert the object
       * @param item this is the item that is inserted into the list
       * @return this returns true if the item is successfully added
       */
      public boolean add(int index, E item){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        addIterations = 0;
        if(index == 0){
            return addFirst(item);
        }
        if(index == size){
            return addLast(item);
        }
        Node current = head;
        Node previous = null;
        for(int i = 0; i < index; i++){
            addIterations++;
            previous = current;
            current = current.next;
        }
        Node newNode = new Node(item);
        previous.next = newNode;
        newNode.next = current;
        size++;
        return true;
      }
}