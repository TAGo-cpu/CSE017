import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Implementation of a list using linked nodes
 */
public class LinkedList<E> {
    // Data members
    private Node head, tail;
    private int size;
    public static int containsIterations, removeIterations, addIterations;
    // Inner class Node
    private class Node {
        E value;
        Node next;
        Node(E initialValue) {
            value = initialValue;
            next = null;
        }
    }
    /**
     * Default constructor
     * Time complexity: O(1)
     */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    /**
     * Add a value at the head of the list
     * @param item the value of the new node
     * @return true if the addition was successful
     * Time complexity: O(1)
     */
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
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
     * Add a value at the tail of the list
     * @param item the value of the new node
     * @return true if the addition was successful
     * Time complexity: O(1)
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
     * Add a value at the end of the list (inherited from the interface List)
     * @param item the value of the new node
     * @return true if the addition was successful
     * Time complexity: O(1)
     */
    public boolean add(E item) {
        return addLast(item);
    }
    /**
     * Get the value of the first node of the list
     * @return the value of the first node in the list
     * @throws NoSuchElementException if the list is empty
     * Time complexity: O(1)
     */
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }
    /**
     * Get the value of the last node of the list
     * @return the value of the last node in the list
     * @throws NoSuchElementException if the list is empty
     * Time complexity: O(1)
     */
    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }
    /**
     * Removes the first node from the list
     * @return true if the removal was successful
     * @throws NoSuchElementException if the list is empty
     * Time complexity: O(1)
     */
    public boolean removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return true;
    }
    /**
     * Removes the last node of the list
     * @return true if the removal was successful
     * @throws NoSuchElementException if the list is empty
     * Time complexity: O(n)
     */
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if (size == 1)
            return removeFirst();
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        size--;
        return true;
    }
    /**
     * toString method
     * @return A formatted string with the values of all the nodes in the list
     * Time complexity: O(n)
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
     * clear the list
     * Time complexity: O(1)
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }
    /**
     * isEmpty method
     * @return true if the list is empty
     * Time complexity: O(1)
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * Get the size of the list
     * @return the number of nodes in the list
     * Time complexity: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Get an iterator for the list
     * @return an iterator object
     * Time complexity: O(1)
     */
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    /**
     * Inner class to implement the interface Iterator<E>
     */
    private class LinkedListIterator implements Iterator<E> {
        // data member
        private Node current = head;
        /**
         * Check if there is a next node in the list
         * @return true if the end of the list is not reached
         * Time complexity: O(1)
        */
        public boolean hasNext() {
            return (current != null);
        }
        /**
         * returns the value of the current node in the list and moves the iterator to the next node
         * @return the value of the current node or null if the end of the list is reached
         * Time complexity: O(1)
        */
        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }
    }

    /**
     * Search method
     * @param o the value being searched in the list
     * @return true a node with value o is found, false otherwise
     * Time complexity: O(n)
    */
    public boolean contains(Object o){
        containsIterations = 0;
        E value = (E) o;
        Iterator<E> iter = iterator();
        while(iter.hasNext()){
            containsIterations++;
            if(iter.next().equals(value))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Remove method
     * @param o the value to remove from the list
     * @return true if a node with value o was found and removed, false otherwise
     * Time complexity: O(n)
    */
    public boolean remove (Object o){
        removeIterations = 0;
        Node current = head;
        Node previous = null;
        E value = (E) o;
        while(current != null && !current.value.equals(value)){
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
        previous.next = current.next;
        if(current == tail){
            tail = previous;
        }
        size--;
        return true;
    }
    /**
     * Method to add a new node at a given position
     * @param index the position at which a new node will be added
     * @param item the value of the new node
     * @return true a node with value o was added successfully to the list
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * Time complexity: O(n)
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
        for(int i=0; i<index; i++){
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