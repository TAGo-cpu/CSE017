/**
 * this is a class for the linked list that was modified with new methods 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/30
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;
/**
    LinkedList Generic Class
 */
public class LinkedList<E> implements List<E>{
    // Data members
    private Node head, tail;
    private int size;
    /**
        Inner class Node
    */
    private class Node {
        E value;
        Node next;
        Node previous;
        Node(E initialValue) {
            value = initialValue;
            next =  null;
            previous = null;
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
        size method
        @return the number of nodes in the list
        Time complexity: O(1)
    */
    public int size() {
        return size;
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
     * Linear search method
     * @param o the object being searched
     * @return true if o was found in this list, false otherwise
     * Time complexity: O(n)
     */
    public boolean contains(Object o){
        Iterator<E> iter = iterator();
        while(iter.hasNext()){
            E element = iter.next();
            if(element.equals(o)){
                return true;
            }
        }
        return false;
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
            head.previous = newNode;
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
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
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
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(item);
        }
        else if (index == size){
            addLast(item);
        }
        else{
            Node current = head;
            Node previous = null;
            for(int i=0; i<index; i++){
                previous = current;
                current = current.next;
            }
            Node newNode = new Node(item);
            previous.next = newNode;
            newNode.next = current;
            current.previous = newNode;
            newNode.previous = previous;
            size++;
        }
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
        if (head == null) 
            tail = null;
        else 
            head.previous = null;
        size--;
        return true;
    }
    /**
        Removes the node at the tail of the list
        @return true if the remove operation was successful and decrements the size
        @throws NoSuchElementException if the list is empty
        Time complexity: O(1)
    */
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if (size == 1)
            return removeFirst();
        Node current = tail;
        tail = current.previous;
        tail.next = null;
        size--;
        return true;
    }
    /**
     * Remove an object o from the list
     * @param o the object to be removed
     * @return true if o was found and removed, false if o not found
     * Time complexity: O(n)
     */
    public boolean remove(Object o){
        Node current = head;
        Node previous = null;
        while(current != null  && !current.value.equals(o)){
            previous = current;
            current = current.next;
        }
        if(current == null){
            return false;
        }
        if((previous) == null){ 
            return removeFirst();
        }
        previous.next = current.next;
        current.next.previous = previous;
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
        while (node.next != null) {
            output += node.value + " ";
            node = node.next;
        }
        output += node.value + "]";
        return output;
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
    
    // New methods to be added

    //time complexity O(n)
    /**
     * this is a method used to add elements from a collection to a linked list
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
     * this is a method used to see if an object equals the element used with this method 
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
     * this is a method that is usesd to get an element from a list using the index 
     */
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Iterator<E> iter = this.iterator();
        E element = null;
        int i = 0;
        while(i <= index){
            element = iter.next();
            i++;
        }
        return element;
    }

    //time complexity O(n)
    /**
     * this is a method used to set an element to a certain index in the list
     */
    public E set(int index, E newVal) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldVal = current.value;
        current.value = newVal;
        return oldVal;
    }
    
    //time complexity O(n)
    /**
     * this is a method used to return the index of an object in the list 
     */
    public int indexOf(Object o){
        int i = 0;
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
          E element = iter.next();
          if(element.equals(o)){
            return i;
          }
          i++;
        }
        return -1;
    }

    //time complexity O(n)
    /**
     * this is a method used to get the last index of an element in a list
     */
    public int lastIndexOf(Object o){
        int i = 0;
        int last = 0;
        int check = 0;
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
          E element = iter.next();
          if(element.equals(o)){
            last = i;
            check++;
          }
          i++;
        }
        if(check > 0){
            return last;
        }
        return -1;
    }


    //time complexity O(n)
    /**
     * this is a method used to remove an element at a certain index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
            Node current = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            E removedValue = current.value;
            if (current == tail) {
                tail = current.previous;
            }
            if (previous != null) {
                current.previous.next = current.next;
                current.next.previous = previous;
            }
            size--;
            return removedValue;
        }

    

    //time complexity O(n)
    /**
     * this is a method used to convert the list into an array 
     */
    public Object[] toArray(){
        Object[] array = new Object[this.size()];
        int i = 0;
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
            E element = iter.next();
            array[i] = element;
            i++;
            }
            return array;
          }
    
    //timem complexity O(n^2)
    /**
     * this is a method used to sort the list using a selection sort method 
     */
    public void sort(Comparator<E> c) {
        for (Node i = head; i != null; i = i.next) {
            Node smallest = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (c.compare(j.value, smallest.value) < 0) {
                    smallest = j;
                }
            }
            E temp = i.value;
            i.value = smallest.value;
            smallest.value = temp;
        }
    }

    public void reverse(){
        List<E> tempList = new LinkedList<>();
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
            E element = iter.next();
            tempList.add(0,element);

            }

        clear();
        addAll(tempList);
    }
    
    }

    
    