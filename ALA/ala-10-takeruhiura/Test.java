import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        HashMap<String, String> hashDictionary = new HashMap<>(50000);
        readDictionary(hashDictionary, "dictionary.txt");
        BST<String> bstWords = new BST<>();
        LinkedList<String> llWords = new LinkedList<>();
        ArrayList<MapEntry<String, String>> alDictionary = hashDictionary.toList();
        hashDictionary.clear();

        testAdd(alDictionary, llWords, bstWords, hashDictionary); 

        testContains(alDictionary, llWords, bstWords, hashDictionary); 

        testRemove(alDictionary, llWords, bstWords, hashDictionary); 
        
        System.out.println("Maximum number of collisions = " + hashDictionary.collisions());
        
    }

    public static void testAdd(ArrayList<MapEntry<String,String>> al, LinkedList<String> ll, BST<String> bst, HashMap<String,String> hm){
        int frequency = al.size()/20;
        int totalLL = 0, totalBST = 0, totalHash = 0;
        System.out.println("Testing the add method");
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Word", "LL add", "BST add", "HashMap put");

        for(int i = 0; i < al.size(); i++){
            String word = al.get(i).getKey();
            ll.add(word);
            bst.add(word);
            hm.put(word, al.get(i).getValue());
            if(i % frequency == 0){
                System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", word, LinkedList.addIterations, BST.addIterations, HashMap.iterations);
            }

            totalLL += LinkedList.addIterations;
            totalBST += BST.addIterations;
            totalHash += HashMap.iterations;


        }

        int size = al.size();
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average", totalLL/size, totalBST/size, totalHash/size);
        System.out.println();


    }

    public static void testContains(ArrayList<MapEntry<String,String>> al, LinkedList<String> ll, BST<String> bst, HashMap<String, String> hm){
        int totalLL = 0, totalBST = 0, totalHash = 0;
        System.out.println("\nTesting the search method");
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Word", "LL search", "BST search", "HashMap search");

       for(int i = 0; i < 1000; i++){
           int index = (int)(Math.random() * al.size());
           String word = al.get(index).getKey();
           hm.get(word);
           bst.contains(word);
           ll.contains(word);
           if(i % 50 == 0){
               System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", word, LinkedList.containsIterations, BST.containsIterations, HashMap.iterations);
           }
           totalLL += LinkedList.containsIterations;
           totalBST += BST.addIterations;
           totalHash += HashMap.iterations;
       }
       System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average", totalLL/1000, totalBST/1000, totalHash/1000);
       System.out.println();
    }

    public static void testRemove(ArrayList<MapEntry<String,String>> al, LinkedList<String> ll, BST<String> bst, HashMap<String,String> hm){
        int totalLL = 0, totalBST = 0, totalHash = 0;
        System.out.println("Testing the remove method");
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Word", "LL remove", "BST remove", "HashMap remove");

        for(int i = 0; i < 1000; i++){
            int index = (int)(Math.random() * al.size());
            String word = al.get(index).getKey();
            ll.remove(word);
            bst.remove(word);
            hm.remove(word);
            if(i % 50 == 0){
                System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", word, LinkedList.removeIterations, BST.removeIterations, HashMap.iterations);
            }

            totalLL += LinkedList.removeIterations;
            totalBST += BST.removeIterations;
            totalHash += HashMap.iterations;


        }
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average", totalLL/1000, totalBST/1000, totalHash/1000);
        System.out.println();

    }


    public static void readDictionary(HashMap<String, String> hash, String filename){
        try{
            Scanner read = new Scanner(new File(filename));
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] tokens = line.split("\\|");
                String word = tokens[0];
                String definition = tokens[1];
                hash.put(word, definition);

            }
            read.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }


    }


    //DISCUSSION:
    //For the add method, in the LinkedList, it is simply adding an entry at the end of the list
    //which is why it is zero iterations. For the BST, the time complexity is O(log(n)) and the number of 
    //entries is 34239 and log base 2 of 34239 is approximately 16 which is why the number of iterations
    //on average is close to 16. For the HashMap, the average number of iterations is 0 because on average
    //the time complexity for a hash map is O(1) because of hashing each entry into the hashtable. For the 
    //search method, the number of iterations for the linked list is about half the size of the list because
    //the contains method has a time complexity of O(n). The contains method for BST is O(log(n)), similar
    //to the add method, the average of number of iterations is close to 16. The search method for HashMap
    //has a time complexity of O(1) because of hashing to get the specific index of the value in the hashtable
    //is constant time and depending on the number of values in a specific linked list, the number of 
    //iterations is on average 1. The remove method for the three data structures has time complexities
    //of O(n) for linked list, O(log(n)) for the BST and O(1) for the HashMap on average because of the 
    //same reason for the search method. Overall, these comparisons show the efficiency of each data
    //structure and how efficient and powerful the HashMap data structure is because of its average
    //time complexity of O(1) for all three methods.

    //The maximum number of collisions is the maximum length of a specific linked list in a hashtable.
    //Because of the properties of hashing, there are times the index for a specific entry is the same
    //as another entry and therefore have the same index in a hashtable. This results in that index of the
    //hashtable to be a linkedlist with multiple values. Basically, the maximum number of collisions also mean the index of a 
    //hashmap with the most number of values stored because they hashed to the same index. 
}