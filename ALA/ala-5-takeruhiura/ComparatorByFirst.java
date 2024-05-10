/**
 * this is a class that uses the comparator class to compare the first thing in a pair 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/4
 */

import java.util.Comparator;
public class ComparatorByFirst<E1 extends Comparable<E1>, E2> implements Comparator<Pair<E1, E2>>{

    /**
     * this is a method that returns an integer depending on the comparison of the first thing in a pair
     */
    public int compare(Pair<E1, E2> p1, Pair<E1, E2> p2){
        E1 first1 = p1.getFirst();
        E1 first2 = p2.getFirst();
        
        return first1.compareTo(first2);
    };

}

//        E1 first1 = p1.getFirst();
 //       E1 first2 = p2.getFirst();
   //     String f1 = (String) (first1);
     //   String f2 = (String) (first2);

//        return f1.compareTo(f2);