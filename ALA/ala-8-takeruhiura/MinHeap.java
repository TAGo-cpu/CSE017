/**
 * this is a modified class of the heap class called minheap
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/6
 */


import java.util.NoSuchElementException;
import java.util.Comparator;
import java.util.ArrayList;
public class MinHeap<E> {
    // ArrayList where the nodes of the heap are stored
    private ArrayList<E> list;
    private Comparator<E> c;
    public static int addIterations, removeIterations;
    /**
     * Default Constructor
     */
    public MinHeap(){
        list = new ArrayList<>();
        c = null;
    }

    /**
     * Constructor with one parameter
     */
    public MinHeap(Comparator<E> c){
        list = new ArrayList<>();
        this.c = c;
    }
    /**
     * Method size
     * @return the number of nodes in the heap
     */
    public int size(){
        return list.size(); 
    }
    /**
     * Method isEmpty
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
     * Method to empty the heap
     */
    public void clear(){
        list.clear(); 
    }
    /**
     * Method toString
     * @return a formatted string containing the values of the nodes of the heap
     */
    public String toString(){
        return list.toString();
    }
    /**
     * Method getRoot
     * @return the value of the root
     */
    public E getRoot(){
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.get(0);
    }
    /**
     * Method contains
     * @param value the value being searched in the heap
     * @return true if the value is found, false otherwise
     */
    public boolean contains(E value) {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(value))
                return true;
        }
        return false;
    }
    /**
     * Method add
     * @param value to be added to the heap
     * reconstructs the heap to keep the MaxHeap properties
     */
    public void add(E value) {
        addIterations  = 0;
        list.add(value);
        int currentIndex = list.size()-1; 
        while(currentIndex > 0) {
            addIterations++;
            int parentIndex = (currentIndex-1)/2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            int comp = 0;
            if(c == null){
                comp = ((Comparable<E>)current).compareTo(parent);
            }else{
                comp = c.compare(current, parent);
            }
            if(comp < 0) {
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            }
            else
                break;
            currentIndex = parentIndex;
        }
    }
    /**
     * Method remove
     * @return the value of the root, null if the heap is empty
     * reconstructs the heap to keep the MaxHeap properties
     */
    public E remove() {
        removeIterations = 0;
        if(list.isEmpty()) 
            return null;
        E removedItem = list.get(0);
        list.set(0, list.get(list.size()-1)); // value of the root = value of the last node in the heap
        list.remove(list.size()-1);// remove the last node
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            removeIterations++;
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            int result = 0;
            if (left >= list.size()) 
                break;
            int minIndex = left;
            E min = list.get(minIndex);
            if (right < list.size()){
                if(c == null){
                    result = ((Comparable<E>)min).compareTo(list.get(right));
                }else{
                    result = c.compare(min, list.get(right));
                }if(result > 0){
                    minIndex = right;
                }

            }
            E current = list.get(currentIndex);
            min = list.get(minIndex);
            if(c == null){
                result = ((Comparable<E>)current).compareTo(min);
            }else{
                result = c.compare(current, min);
            }
            if(result > 0){
                list.set(minIndex, current);
                list.set(currentIndex, min);
                currentIndex = minIndex;
            }
            else
                break;
        }
        return removedItem;
    }
}