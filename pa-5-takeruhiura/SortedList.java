/**
 * this is a class that is used to create a sorted list for the geolocations 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/12
 */

 import java.util.ArrayList;
 import java.util.Comparator;
 
 
 public class SortedList<E>{
     private ArrayList<E> list;
     private Comparator<E> comparator;
 
     /**
      * time complexity O(1)
      * this is a default constructor used to create a sortedlist
      */
     public SortedList(){
         this.list = new ArrayList<>();
         comparator = null;
     }
 
     /**
      * time complexity O(1)
      * this is a constructor used to create a sortedlist with a comparator
      * @param comparator this is the parameter for the comparator of the list
      */
     public SortedList(Comparator<E> comparator){
         this.list = new ArrayList<>();
         this.comparator = comparator;
     }
 
     /**
      * time complexity O(1)
      * this is a method used to return the size of the list
      * @return this returns an integer
      */
     public int size(){
         return list.size();
     }
 
     /**
      * time complexity O(n)
      * this is a method used to add the parameter to the list and keep it sorted
      * @param val this is what is added to the list
      */
     public void add(E val) {
         if (this.comparator == null) {
             int i = 0;
             while (i < list.size() && ((Comparable)val).compareTo(list.get(i)) >= 0) {
                 i++;
             }
             list.add(i, val); 
         } else {
             int i = 0;
             while (i < list.size() && comparator.compare(val, list.get(i)) >= 0) {
                 i++;
             }
             list.add(i, val); 
         }
     }
     
     
     /**
      * time complexity O(log(n))
      * this is used to find something in the list
      * @param key this is what is trying to be found in the list
      * @return returns a value either null if the key is not found or the value if found in the list
      */
     public E find(E key) {
         return find(key, 0, list.size()-1);
     }
 
     /**
      * time complexity O(log(n))
      * this is the helper method for find used to find the key in the list
      * @param key this is what is trying to be found in the list
      * @param low this is the lower bound of the list to be searched
      * @param high this is the higher bound of the list to be searched
      * @return this returns either null if nothing is found or the object if it is found in the list
      */
     private E find(E key, int low, int high) {
         if (low <= high) {
             int mid = low + (high - low) / 2;
             if (comparator == null) {
                 if (((Comparable)key).compareTo(list.get(mid)) == 0) {
                     return list.get(mid);
                 } else if (((Comparable)key).compareTo(list.get(mid)) < 0) {
                     return find(key, low, mid - 1); 
                 } else {
                     return find(key, mid + 1, high);
                 }
             } else {
                 if (comparator.compare(key, list.get(mid)) == 0) {
                     return list.get(mid); 
                 } else if (comparator.compare(key, list.get(mid)) < 0) {
                     return find(key, low, mid - 1); 
                 } else {
                     return find(key, mid + 1, high); 
                 }
             }
         }
 
         return null; 
     }
 
     /**
      * time complexity O(n^2)
      * this is a method used to set the comparator and sorts the list
      * @param comparator this is the comparator that is used to set the comparator 
      */
     public void setComparator(Comparator<E> comparator) {
         this.comparator = comparator;
         sort();
     }
 
     /**
      * time complexity O(n^2)
      * this is a method that uses insertion sort to sort a list and is sorted either with a comparator or without 
      */
     private void sort() {
         if (comparator == null) {
             for (int i = 1; i < list.size(); i++) {
                 int j = i - 1;
                 while (j >= 0 && ((Comparable)list.get(i)).compareTo(list.get(j)) < 0) {
                     list.set(j + 1, list.get(j));
                     j--;
                 }
                 list.set(j + 1, list.get(i));
             }
         } else {
             for (int i = 1; i < list.size(); i++) {
                 E key = list.get(i);
                 int j = i - 1;
                 while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                     list.set(j + 1, list.get(j));
                     j--;
                 }
                 list.set(j + 1, key);
             }
         }
     }
 
 
     
     /**
      * time complexity O(n)
      * this is a method used to make the value in the list into a string 
      */
     @Override
     public String toString() {
         String result = "";
         for (int i = 0; i < list.size(); i++) {
             result += list.get(i) + "\n";
         }
         return result;
     }
     
     
 }