/**
 * this is a class used to test different recursion functions
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/23
 */
import java.util.Scanner;

public class Recursion {
    /**
     * this is a method to check the number of a specific letter are in a string
     * @param str this is the string that is checked 
     * @param c this is the character that the method searches in the string
     * @return returns an integer for the number of characters in the string that matched the character the method was looking for 
     */
    public static int count (String str, char c){
        //base case
        if(str.length() == 0){
            return 0;
        }
        if(str.charAt(0) == c){
            return 1 + count(str.substring(1), c);
        }

        return 0 + count(str.substring(1), c);
    }

    /**
     * this is a method to output the number of permutations of a string
     * @param s this is the string that is used to fidn the permutations 
     */
    public static void permutations(String s){
        permutations(" ", s);
        
    }
    /**
     * this is the helper method used to create all the permutations of the string 
     * @param s1 this is the string for each permutation
     * @param s2 this is the string with the remaining letters in the original string 
     */
    public static void permutations(String s1, String s2){
        //base case
        if(s2.length() == 0){
            System.out.println(s1);
            return;
        }
        for(int i = 0; i < s2.length(); i++){
            String newStr1 = s1 + s2.charAt(i); //add the character i to str1
            String newStr2 = s2.substring(0, i) + s2.substring(i+1); //remove character i from str2
            //recursive case
            permutations(newStr1, newStr2);
        }
    }


 

    public static void main(String[] args){
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter a string: ");
        String str = keyboard.nextLine();
        System.out.println("Enter a character: ");
        char c = keyboard.nextLine().charAt(0);
        System.out.println("Character " + c + " appears " + count(str,c) + " times in \"" + str + "\"");
        System.out.println("Enter a string: ");
        str = keyboard.nextLine();
        permutations(str);
        keyboard.close();
    }

}
