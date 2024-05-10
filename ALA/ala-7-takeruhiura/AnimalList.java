/**
 * this is a class that is used to compare the three methods between arraylist and linkedlist
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/24
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AnimalList{
    public static void main(String[] args){
        ArrayList<String> animalAL = new ArrayList<>();
        LinkedList<String> animalLL = new LinkedList<>();

        readFile(animalAL, animalLL, "animals.txt");
        testContains(animalAL, animalLL);
        testAdd(animalAL, animalLL);
        testRemove(animalAL, animalLL);
    }

    /**
     * this is a method used to read in the animals text flie
     * @param al this is the array list where the animals are added 
     * @param ll this is the linked list where the animals are added
     * @param filename this is the filename of the file where the data is read from 
     */
    public static void readFile(ArrayList<String> al, LinkedList<String> ll, String filename){
        try{
            Scanner read = new Scanner(new File(filename));
            while(read.hasNextLine()){
                String animal = read.nextLine();
                al.add(animal);
                ll.add(animal);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    /**
     * this is a method used to test out the contains method
     * @param al this is the array list used to test the method
     * @param ll this si the linked list used to test the method 
     */
    public static void testContains(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0, totalLL = 0;
        System.out.println("\nComparing the methods contains(Object o)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal name", "Iterations(AL)", "Iterations(LL)");
        for(int i = 0; i < 20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            al.contains(randomAnimal);
            ll.contains(randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomAnimal, ArrayList.containsIterations, LinkedList.containsIterations);
            totalAL += ArrayList.containsIterations;
            totalLL += LinkedList.containsIterations;
            }
            System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);

        }
    
        /**
         * this is a method used to test the add method
         * @param al this is the array list to test the method
         * @param ll this si the linked list used to test the method 
         */
    public static void testAdd(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0, totalLL = 0;
        System.out.println("\nComparing the methods add(int index, E item)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal name", "Iterations(AL)", "Iterations(LL)");
        for(int i = 0; i < 20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            al.add(randomIndex, randomAnimal);
            ll.add(randomIndex, randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomAnimal, ArrayList.addIterations, LinkedList.addIterations);
            totalAL += ArrayList.addIterations;
            totalLL += LinkedList.addIterations;
        }
            System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);
    
            }
    
        /**
         * this is a method used to compare the remove methods for both types of lists
         * @param al this is a array list that uses the method
         * @param ll this is a linked list that uses the method
         */
    public static void testRemove(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0, totalLL = 0;
        System.out.println("\nComparing the methods remove(Object o)");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal name", "Iterations(AL)", "Iterations(LL)");
        for(int i = 0; i < 20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            al.remove(randomAnimal);
            ll.remove(randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomAnimal, ArrayList.removeIterations, LinkedList.removeIterations);
              totalAL += ArrayList.removeIterations;
            totalLL += LinkedList.removeIterations;
            }
         System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);    
         }
    
//DISCUSSION:
// For the method contains(Object o), both data structures use the iterator to iterate through 
// each animal in the list. If the object is found, it returns true. The method has time 
// complexity O(N) because the worst-case scenario is the total length of the list, which is N. 
// In this case, it depends on which animal is selected when running the contains method.
// The averages should be close to half the number of items in the list since the number of 
// iterations is random from the random animals selected. Both averages are the same for this 
// reason because they average out to be the same number of iterations from the animal positions 
// being the same for both lists and because the methods are identical. For 
// the add(int index, E item) method in ArrayList, the method will iterate through the list to 
// increment the index of each item that is after the index where the new element wants to be 
// added so there is space. Ultimately, the largest amount of iterations for this is N so the 
// time complexity is O(N). This method also uses ensureCapacity() to see if the list has space. 
// If it does not, then it must iterate through the list to transfer the data to a new larger 
// list which also has time complexity O(N). However, the overall time complexity for add is 
// still O(N). For LinkedList, the add(int index, E item) method is similar where each item before
// the index is shifted depending on the index where the item is added. Because of this, the time 
// complexity for this method is also O(N). Because both methods have O(N) time complexity, they 
// should have similar iterations. However, because the methods are different, they will not 
// always have the same number of iterations and they will vary on which has more than the 
// other. But because the time complexities are O(N), the number of iterations should average 
// out to somewhere around half the number of items in the list. Finally, the remove(Object o) 
// method in the LinkedList class iterates through the list by changing the pointers for the 
// previous and current node until it reaches the object. Ultimately, it will take a time 
// complexity of O(N) for the method to remove an object because the worst-case scenario is to 
// iterate through every value in the list. In ArrayList, the remove method iterates through 
// each element in the list. Once the element is found, it uses the other remove method to shift 
// every element to the left. In this remove method, it iterates through the list so the time 
// complexity is O(N). However, because the remove method iterates through the list to find the 
// object and then iterates through the rest of the list in the other remove(index) method, the 
// time complexity will always be N. This is why the results show the number of iterations for 
// remove to always be N for ArrayList. For LinkedList, it acts like all the other methods were 
// the overall number of iterations can vary from 1 to N so it averages out to about half the 
// number of elements in the list. In this case, remove(Object o) will tend to have fewer 
// iterations for the LinkedList than the method for the ArrayList.



    }
