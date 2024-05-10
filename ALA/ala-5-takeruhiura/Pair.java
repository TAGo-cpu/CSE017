/**
 * this is a class that creates a pair 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/4
 */

public class Pair<E1, E2>{
    private E1 first;
    private E2 second;

    /**
     * this is a default constructor for a pair
     */
    public Pair(){
        first = null;
        second = null;
    }

    /**
     * this is a constrcutor for a pair that takes in two elements for pairs
     * @param f this is the first element for the pair
     * @param s this is the second element for the pair
     */
    public Pair(E1 f, E2 s){
        first = f;
        second = s;
    }

    /**
     * this is a method that returns the first element E1
     * @return
     */
    public E1 getFirst(){ return first;}


    /**
     * this is a method that returns the second element E2
     * @return
     */
    public E2 getSecond(){ return second;}

    /**
     * this is a method used to set the first element of a pair 
     * @param f this is the element E1 for the first element in a pair
     */
    public void setFirst(E1 f){ first = f;}

    /**
     * this is a method used to set the second element of a pair
     * @param s this is the element E2 for the second element in a pair 
     */
    public void setSecond(E2 s){ second = s;}

    /**
     * this is a method used to return a a string for a pair 
     */
    public String toString(){
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    /**
     * this is a method used to see if two pairs equal each other and returns a boolean 
     */
    public boolean equals(Object o){
        if(o instanceof Pair){
            Pair<E1, E2> p = (Pair) o;
            return this.first.equals(p.first) && 
                   this.second.equals(p.second);
        }
        return false;
    }
}