/**
 * this is the test class used to test each implementation of HashMap with movie objects
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/28
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;


public class Test{
    public static void main(String[] args){
        ArrayList<MapEntry<Integer, Movie>> movieList = new ArrayList<>(70000);
        // Creating the hashmap
        HashMapLP<Integer, Movie> moviesHMLP = new HashMapLP<>(70000, 0.5);
        HashMapSC<Integer, Movie> moviesHMSC = new HashMapSC<>(70000, 0.9);

        // Populating the array list movieList with the data from the files
        readMovies(moviesHMLP,moviesHMSC, "/home/houdghiri/CSE017/movies.csv");
        System.out.println(moviesHMLP.size() + " movies read from the file");
        readRatings(moviesHMLP, "/home/houdghiri/CSE017/ratings.csv");
        
        // print the characetristics of the two implementations of the hashmap
        System.out.println("\nHash table characteristics (Separate Chaining)");
        moviesHMSC.printCharacteristics();

        System.out.println("\nHash table characteristics (Linear Probing)");
        moviesHMLP.printCharacteristics();

        // Test the performance of the get methods in the two implementations of the hashmap
        int ids[] = {1544, 2156, 31349, 3048, 4001, 356, 5672, 6287, 25738, 26};
        testGet(moviesHMLP, moviesHMSC, ids);

        // Test the performance of the remove methods in the two implementations of the hashmap
        testRemove(moviesHMLP, moviesHMSC, ids);


        // print the characetristics of the two implementations of the hashmap after adding more movies
        System.out.println("\nHash table characteristics (Separate Chaining)");
        moviesHMSC.printCharacteristics();

        System.out.println("\nHash table characteristics (Linear Probing)");
        moviesHMLP.printCharacteristics();
       
        // sort the movies
        System.out.println("\nSorting the movies from the hashtable with separate chaining");
        mergeSortMovies(moviesHMSC);
        System.out.println("\nSorting the movies from the hashtable with linear probing");
        mergeSortMovies(moviesHMLP);

    }
            static class ComparatorByRating implements Comparator<Movie> {
            public int compare(Movie movie1, Movie movie2) {
                if (movie1.getRating() < movie2.getRating()) {
                    return -1;
                } else if (movie1.getRating() > movie2.getRating()) {
                    return 1;
                } else {
                    return 0;
                }
            }

        }
    /**
     * read the list of movies from filename and adds the pairs (movieid, movie) to the two hash maps
     * @param hm1 the first hash table
     * @param hm2 the second hash table
     * @param filename the name of the file to read
     */
    public static void readMovies(HashMap<Integer, Movie> hm1, HashMap<Integer, Movie> hm2, String filename){
        File file = new File(filename);
        //this is the try and catch block to put the file data of students into both lists
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String s = readFile.nextLine();
                String[] tokens = s.split(",");
                int id = Integer.parseInt(tokens[0]);
                String title = tokens[1];
                String genre = tokens[2];
                Movie movie = new Movie(id, title, genre);
                hm1.put(id, movie);
                hm2.put(id, movie);
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
        }
    }

    /**
     * read the ratings of the movies from filename and update the number of ratings and the average rating of the movies in hm
     * @param hm the hash table of movies to be updated
     * @param filename the name of the file with the movie ratings
     */
    public static void readRatings(HashMap<Integer, Movie> hm, String filename){
        File file = new File(filename);
        //this is the try and catch block to put the file data of students into both lists
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String s = readFile.nextLine();
                String[] ratings = s.split(",");
                int movieID = Integer.parseInt(ratings[1]);
                double rating = Double.parseDouble(ratings[2]);
                Movie movie = hm.get(movieID);
                movie.addRating(rating);
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
        }
    }

    /**
     * calls the get method of a list of movie ids and displays the number of iterations for each hash tabel
     * @param hm1 the first hashtable
     * @param hm2 the second hashtable
     * @param ids an array of movie ids to lookup
     */
    public static void testGet(HashMap<Integer, Movie> hm1, HashMap<Integer, Movie> hm2, int[] ids){
        System.out.println("\nResults of the search operation in the two hashmaps");
        System.out.printf("%-5s\t%-50s\t%-20s\t%-20s\n", 
                          "Id", "Title","Iterations(SC:get)", "Iterations(LP:get)");
        for(int id: ids){
            Movie m = hm1.get(id);
            hm2.get(id);
            if(m == null){
                System.out.println("Movie id not found.");
            }
            else{
                System.out.printf("%-5d\t%-50s\t%-20d\t%-20d\n", 
                                  id, m.getTitle(),HashMapSC.getIterations, HashMapLP.getIterations);
            }
        }
    }
    /**
     * calls the remove method of a list of movie ids and displays the number of iterations for each hashtable
     * @param hm1 the first hashtable
     * @param hm2 the second hashtable
     * @param ids an array of movie ids to remove
     */
    public static void testRemove(HashMap<Integer, Movie> hm1, HashMap<Integer, Movie> hm2, int[] ids){
        System.out.println("\nResults of the remove operation in the two hashmaps");
        System.out.printf("%-5s\t%-50s\t%-20s\t%-20s\n", 
                          "Id", "Title","Iterations(SC:remove)", "Iterations(LP:remove)");
        for(int id: ids){
            Movie m = hm1.get(id);
            hm1.remove(id);
            hm2.remove(id);
            System.out.printf("%-5d\t%-50s\t%-20d\t%-20d\n", 
                            id, m.getTitle(), HashMapSC.removeIterations, HashMapLP.removeIterations);
        }
    }
    
    //time complexity: O(nlog(n))
    /**
     * sorts the list of movies by ratings first, then select the movies with more than 10,000 ratings and 
     * sort them by the average rating
     * The method uses the merge sort algorithm for the two sortings
     * displays the bottom/top ten rated movies in the hashmap
     */
    public static void mergeSortMovies(HashMap<Integer, Movie> hm) {
        ArrayList<Movie> movieList = hm.values();
        mergeSort(movieList, null);

        ArrayList<Movie> topRated = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getRatings() >= 10000) {
                topRated.add(movie);
            }
        }
        Comparator<Movie> comp = new ComparatorByRating();
        mergeSort(topRated, comp);
        System.out.println("Bottom Ten movies with at least 10,000 ratings");
        System.out.printf("%-5s\t%-50s\t%-20s\t%-20s\n", 
                          "Id", "Title","Number of ratings", "Average rating");

        for (int i = 0; i < 10; i++) {
            System.out.println(topRated.get(i).toString());
        }
        System.out.println("\nTop Ten movies with at least 10,000 ratings");
        System.out.printf("%-5s\t%-50s\t%-20s\t%-20s\n", 
                          "Id", "Title","Number of ratings", "Average rating");
        for (int i = topRated.size()-1; i > topRated.size()-11; i--) {
            System.out.println(topRated.get(i).toString());
        }
    }

    public static <E> void mergeSort(ArrayList<E> list, Comparator<E> comparator) {
        if (list.size() > 1) {
            ArrayList<E> firstHalf = subList(list, 0, list.size() / 2);
            ArrayList<E> secondHalf = subList(list, list.size() / 2, list.size());
            mergeSort(firstHalf, comparator);
            mergeSort(secondHalf, comparator);
            merge(firstHalf, secondHalf, list, comparator);
        }
    }

    public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end) {
        if (start < 0 || start >= list.size() || end < 0 || end > list.size() || start > end) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ArrayList<E> sub = new ArrayList<>();
        for (int i = start; i < end; i++) {
            sub.add(list.get(i));
        }
        return sub;
    }

    public static <E> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list, Comparator<E> comparator) {
        int list1Index = 0, list2Index = 0, listIndex = 0;
        while (list1Index < list1.size() && list2Index < list2.size()) {
            if (comparator == null) {
                if (((Comparable)list1.get(list1Index)).compareTo(list2.get(list2Index)) < 0) {
                    list.set(listIndex++, list1.get(list1Index++));
                } else {
                    list.set(listIndex++, list2.get(list2Index++));
                }
            } else {
                if (comparator.compare(list1.get(list1Index), list2.get(list2Index)) < 0) {
                    list.set(listIndex++, list1.get(list1Index++));
                } else {
                    list.set(listIndex++, list2.get(list2Index++));
                }
            }
        }
        while (list1Index < list1.size()) {
            list.set(listIndex++, list1.get(list1Index++));
        }
        while (list2Index < list2.size()) {
            list.set(listIndex++, list2.get(list2Index++));
        }
    }

//DISCUSSION:
/**
 * The time complexity for mergeSortMovies is O(nlog(n)). This is because the method
 * class the mergesSort method which has a dominant time complexity of n(logn). The
 * merge method splits the list in half recursively until each list is size 1, this
 * makes a structure of a binary tree which has a height of log(n). For each level of
 * this tree, the method merge is called which has a time complexity of O(n). Because
 * merge is called for each sublist the total time complexity of mergeSoort is O(nlog(n)).
 */

/**
 * For the get method of the two hashmaps the number of iterations is 1. This shows
 * that there are no collisions for these keys used to test the get method using 
 * linear probing and separate chaining. The number of iterations for remove in 
 * separate chaining is also 1 because of the same idea that there are no collisions
 * when finding the key. In the hashtable of linear probing you must get all the values
 * from the cluster that had the specific key you are trying to remove with the method. 
 * But this remove method in linear probing requires you to copy each map entry from the cluster 
 * into a temporary list and then put each value of that temporary list back into the 
 * hashtable using the put method. This is why there are a larger number of iterations
 * for the remove method in the hashtable for linear probing. 
 */

/**
 * Hashtable capacity is the total size of the hashtable array, it is a multiple of 2.
 * Hashtable size is the items with unique hash indexes added into the hashtable that fill 
 * up an index of the hashtable.
 * The number of clusters for a hashtable with linear probing is each group of map entries
 * that are next to each other and each cluster is separated by null values.
 * The largest cluster is the largest group of consecutive map entries.
 * The smallest cluster is the smallest group of consecutive map entries.
 * The number of collisions is the number of times a HTIndex is the same for different keys.
 * The number of buckets is the number of linked lists in a hashtable for separate chaining.
 * The largest bucket is the longest linked list.
 * The smallest bucket is the shortest linked list.
 * 
 * The number of collisions is greater for linear probing than separate chaining because in
 * linear probing each entry takes up an actual index of the hashmap but in separate chaining
 * collided map entries go into a linkedlist and so for linear probing the actual hashmap array
 * gets full quicker than separate chaining so there are more collisions in linear probing. 
 * 
 * The number of buckets is greater than the number of clusters because clusters can combine
 * into larger clusters which reduces the total number of clusters however, the number of buckets
 * cannot combine. This is also why the largest cluster tends to be greater because clusters can combine.
 */

}