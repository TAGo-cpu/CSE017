/**
 * this is a class that uses the comparator class to compare the second thing in a pair  
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/4
 */

import java.util.Comparator;
public class ComparatorBySecond<E1, E2 extends Comparable<E2>> implements Comparator<Pair<E1, E2>>{

    /**
     * this is a method that returns an integer based on the comparison of the second thing in a pair
     */
    public int compare(Pair<E1, E2> p1, Pair<E1, E2> p2){
        E2 second1 = p1.getSecond();
        E2 second2 = p2.getSecond();
        return second1.compareTo(second2);
    };

}