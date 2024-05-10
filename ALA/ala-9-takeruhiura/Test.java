/**
 * this is a class used to analyze how the add, contains, and remove methods in a BST with a list of animals, also used to test the height and balanced methods
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/16
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        BST<String> animalBST = new BST<>();
        ArrayList<String> aList = new ArrayList<>(500);
        testAdd(animalBST, aList, "animals.txt");
        testContains(animalBST, aList);
        testRemove(animalBST, aList);
        System.out.println("BST properties (random data)");
        System.out.println("Height: " + animalBST.height());
        System.out.println("BST is balanced? " + animalBST.isBalanced());
        System.out.println();
        //this is the BST after sorting the animals first
        animalBST.clear();
        aList.sort(null);
        for(String animal: aList){
            animalBST.add(animal);
        }
        System.out.println("BST properties (sorted data)");
        System.out.println("Height: " + animalBST.height());
        System.out.println("BST is balanced? " + animalBST.isBalanced());
        

}

    /**
     * this is a method used to store the data in a file to a BST and array list, also stores the total number of iterations to add to the BST
     * @param bst this is the BST where the data is added to
     * @param al this is the array list where the data is added to
     * @param filename this is the file the data is read from
     */
    public static void testAdd(BST<String> bst, ArrayList<String> al, String filename){
        System.out.println("Testing the method add(E)");
        System.out.printf("%-25s\t%-10s\n", "Animal name", "Iterations");
        int total = 0;
        try{
            Scanner read = new Scanner(new File(filename));
            int count = 0;
            while(read.hasNextLine()){
                String name = read.nextLine();
                bst.add(name);
                al.add(name);
                if(count % 25 == 0){
                    System.out.printf("%-30s\t%-10d\n", name, BST.addIterations);
                }
                count++;
                total += BST.addIterations;
            }
            System.out.printf("%-25s\t%-10d\n", "Average", total/count);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        System.out.println();

    }

    /**
     * this is a method used to test the contains method in BST
     * @param bst this is the BST used to test the contains method 
     * @param al this is an array list used to get a random animal to find in the BST
     */
    public static void testContains(BST<String> bst, ArrayList<String> al){
        System.out.println("Testing the method contains()");
        System.out.printf("%-25s\t%-10s\n", "Animal name", "Iterations");
        int total = 0;
        for(int i = 0; i < 20; i ++){
            int randomIndex = (int)(Math.random() * al.size());
            String name = al.get(randomIndex);
            bst.contains(name);
            total += BST.containsIterations;
            System.out.printf("%-30s\t%-10d\n", name, BST.containsIterations);
        }
        System.out.printf("%-25s\t%-10d\n", "Average", total/20);
        System.out.println();

    }

    /**
     * this is a method used to test the remove method from BST
     * @param bst this the BST that is used to test the remove method
     * @param al this is an array list used to get a random animal to remove from the BST
     */
    public static void testRemove(BST<String> bst, ArrayList<String> al){
        int total = 0;
        System.out.println("Testing the method remove(E)");
        System.out.printf("%-25s\t%-10s\n", "Animal name", "Iterations");
        for(int i = 0; i < 20; i++){
            int randomIndex = (int)(Math.random() * al.size());
            String name = al.get(randomIndex);
            bst.remove(name);
            total += BST.removeIterations;
            System.out.printf("%-30s\t%-10d\n", name, BST.removeIterations);
        }
        System.out.printf("%-25s\t%-10d\n", "Average", total/20);
        System.out.println();
    }

    //DISCUSSION:
    //The number of iterations for the add, contains, and remove method should be similar
    //and it should be close to 9. This is because the time complexity on average for all 
    //three of these methods is O(log(n)) because the lists are not sorted and log base 2 
    //of 500 (number of animals) is approximately 9 which is why the average number of iterations 
    //for each of these methods is around 9 iterations. Since sorted values are not used for these methods
    //the tree does not act like a linked list which is why the time complexity is not O(n).

    //The height of a tree is the number of levels in the binary tree. This is done
    //using a recursion height method where starting from each left subtree, the method
    // compares the left and right subtrees until the leaf node is reached so the left 
    //and right subtrees of a leaf node are zero, then the height of this is the height (zero) plus 1. 
    //This is done for each left subtree and right subtree where they are compared and 
    //the greater of the two plus one is the height of that portion, this is done until 
    //the method reaches the root. So, the random data has 17 levels and the sorted data
    //has 462 levels which makes sense because a sorted tree acts like a linkedlist with no branches. 
    //The balance method checks every node in a tree and compares the left and right subtrees 
    //to see the height difference. If any two subtrees have a height difference
    //greater than 1, the tree is not balanced. So, for these two trees the height difference
    //for all the subtrees are not all at most 1. All in all, the BST with random data has a 
    //time complexity of O(log(n)) for its add, contains, and remove methods. However, the BST
    //with the sorted data has a height of one for a linked list and therefore these methods
    //will now be O(n).
}