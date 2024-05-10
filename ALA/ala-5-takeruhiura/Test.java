/**
 * this is a class used to test the pair
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/4
 */



import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test{
    /**
     * this is where the user will determine whether to run the program for trees or states
     * @param args this is the string for either trees or states
     */
    public static void main(String[] args){

        if(args.length == 0){
            System.out.println("No arguments provided (states or trees)");
            System.exit(0);
        }
        if(args.length > 1){
            System.out.println("Too many arguments (one argument trees or states)");
            System.exit(0);
        }
        String type = args[0];
        if(!type.equals("trees") && !type.equals("states")){
            System.out.println("Invalid data type. states and trees are the only types available.");
            System.exit(0);
        }
        switch(type){
            case "states":
            stateOperations();
            break;
            case "trees":
            treeOperations();
            break;
        }
    }

    /**
     * this is a method that will run for the states file 
     */
    public static void stateOperations(){
        ArrayList<Pair<String, String>> states = new ArrayList<>(50);
        readStates(states, "states.txt");
        Scanner keyboard = new Scanner(System.in);
        int operation = 0;
        do{
            printMenu("states");
            operation = Integer.parseInt(keyboard.nextLine());
            switch(operation){
                case 1:
                print(states);
                System.out.println();
                break;
                case 2:
                System.out.println("Enter a state name:");
                String name = keyboard.nextLine();
                int index = search(states, name);
                if (index == -1){
                    System.out.println("No state found.");
                }else{
                    System.out.println("State found: " + states.get(index));
                }
                System.out.println();
                break;
                case 3:
                states.sort(new ComparatorByFirst());
                break;
                case 4:
                states.sort(new ComparatorBySecond());
                break;
                case 5:
                break;
                default:
                System.out.println("Invalid operation (1 to 5)");
                System.out.println();

            }
        }while(operation !=5);
    }


    /**
     * this is the method that will run for the trees file
     */
    public static void treeOperations(){
        ArrayList<Pair<String, Integer>> trees = new ArrayList<>(50);
        readTrees(trees, "trees.txt");
        Scanner keyboard = new Scanner(System.in);
        int operation = 0;
        do{
            printMenu("trees");
            operation = Integer.parseInt(keyboard.nextLine());
            switch(operation){
                case 1:
                print(trees);
                System.out.println();
                break;
                case 2:
                System.out.println("Enter a tree name:");
                String name = keyboard.nextLine();
                int index = search(trees, name);
                if (index == -1){
                    System.out.println("No tree found.");
                }else{
                    System.out.println("Tree found: " + trees.get(index));
                }
                System.out.println();
                break;
                case 3:
                trees.sort(new ComparatorByFirst());
                System.out.println();
                break;
                case 4:
                trees.sort(new ComparatorBySecond());
                System.out.println();
                break;
                case 5:
                break;
                default:
                System.out.println("Invalid operation (1 to 5)");
                System.out.println();

            }
        }while(operation !=5);
    }

    /**
     * this is a method that prints each item in the  generic class arraylist 
     * @param <E> this is the generic class used for the method 
     * @param list this is the arraylist used to print out each item 
     */
    public static <E> void print(ArrayList<E> list){
        for(E element: list){
            System.out.println(element);

        }
        
    }



    /**
     * this is a method used to print the menu for the program 
     */
    public static void printMenu(String type){
        System.out.println("Select an operation:");
        System.out.println("1: View the list of " + type );
        System.out.println("2: Search " + type +  " by name ");
        System.out.println("3: Sort " + type + " by name");
        if(type.equals("states")){
            System.out.println("4: Sort " + type + " by capital");
        }else{
            System.out.println("4: Sort " + type + " by height");
        }
        System.out.println("5: Exit");

    }

    /**
     * this method is used to read a file and fill the arraylist, throws an exception if the filename is invalid 
     * @param list this is the arraylist that is used to store the name of the state and capital
     * @param filename this is the file that is read 
     */
    public static void readStates(ArrayList<Pair<String, String>> list, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] tokens = line.split("\\|");
                String name = tokens[0];
                String capital = tokens[1];
                Pair<String, String> state = new Pair<>(name, capital);
                list.add(state);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }

    /**
     * this is a method used to read the trees file to put into an ArrayList
     * @param list this is the list that the trees file will be stored into
     * @param filename this is the file that will be read by the method
     */
    public static void readTrees(ArrayList<Pair<String, Integer>> list, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] items = line.split("\\|");
                String name = items[0];
                Integer height = Integer.parseInt(items[1]);
                Pair<String, Integer> tree = new Pair<>(name, height);
                list.add(tree);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }

    /**
     * this is a method used to search a specific key in the arraylist and returns the index of it 
     * @param <E1> this is the type for the first element
     * @param <E2> this is the type for the second element
     * @param list this is the list that is searched
     * @param key this is what is being searched 
     * @return this will return the index of the key if found and -1 if not found 
     */
    public static <E1, E2> int search(ArrayList<Pair<E1, E2>> list, E1 key){
        for(int i = 0; i < list.size(); i++){
            Pair<E1, E2> pair = list.get(i);
            if(pair.getFirst().equals(key)){
                return i;
            }
        }
        return -1;
    }
}