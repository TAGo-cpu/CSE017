/**
 * this is a class for the priority queue used for the patients ordering
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/24
 */

import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<E> {
    private MinHeap<E> elements;

    /**
     * this is a default constructor for a queue 
     */
    public PriorityQueue(){
        elements = new MinHeap<>();
    
    }

    /**
     * this is a constructor for a queue which takes in a comparator
     * @param c this is a comparator that is used to make the minheap in the constructor 
     */
    public PriorityQueue(Comparator<E> c){
        elements = new MinHeap<>(c);
    
    }

    /**
     * this is a method that is used to see if a queue contains a certain value
     * @param value this is the value that is searched
     * @return this returns a boolean based on the results
     */
    public boolean contains(E value){
        return elements.contains(value);
    }

    // Time Complexity: O(log(n))
    /**
     * this is a method used to add a patient into a queue
     * @param value this is the value for the patient 
     */
    public void offer(E value){
        elements.add(value);
    }
    //Time Complexity: O(log(n))
    /**
     * this is a method used to remove a patient from a queue 
     * @return returns the patient that was removed
     */
    public E poll(){
        if(elements.isEmpty()){
            throw new NoSuchElementException();
        }
        return elements.remove();
    }
    
    //Time Complexity: O(1)
    /**
     * this is a method used to display the first item in the queue 
     * @return
     */
    public E peek(){
        return elements.getRoot();
    }

    //Time Complexity: O(1)
    /**
     * this is a method used to return the size of a queue
     * @return returns an integer for the number of elements 
     */
    public int size(){
        return elements.size();
    }

    //Time Complexity: O(1)
    /**
     * this is a method used to check if a queue is empty
     * @return this returns a boolean based on the results 
     */
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    //Time Complexity: O(1)
    /**
     * this is a method used to clear the entire queue 
     */
    public void clear(){
        elements.clear();
    }
    
    //Time Complexity: O(1)
    /**
     * this is a method used to return the queue as a string 
     */
    public String toString(){
        return elements.toString();
    }


}

