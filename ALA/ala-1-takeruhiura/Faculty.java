/**
 * this is the class for the constructor for the Faculty object extended from the Employee class
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/25
 */

public class Faculty extends Employee{
    private String rank;

    /**
     * this is a constructor for when there are no values for Faculty 
     */
    public Faculty(){
        super(0, "none", "none", "none", "none", "none", 0);
    }

    /**
     * this is the constructor to create a Faculty object 
     * @param id this is an integer for the id of the person 
     * @param n this is the name of the person stored as a string
     * @param a this is a string for the address of the person 
     * @param p this is the phone number as a string 
     * @param e this is a string that stores the email 
     * @param position this is a string that stores the position of the faculty
     * @param salary this is a double used to store the salary of the faculty 
     * @param rank this is a string that stores the rank of the faculty 
     */
    public Faculty(int id, String n, String a, String p, String e, String position, double salary, String rank){
        super(id, n, a, p, e, position, salary);
        this.rank = rank;
    }

    /**
     * this is a method that returns the rank of the faculty 
     * @return this returns a string 
     */
    public String getRank(){return rank;}

    /**
     * this method is used to set the rank of a faculty
     * @param rank this is a string parameter
     */
    public void setRank(String rank){
        this.rank = rank;
    }

    /**
     * this method is an overriden version from the Employee class which also stores the rank of the faculty 
     */
    @Override
    public String toString(){
    return super.toString() + "Rank: " + getRank() +"\n";
}
}
