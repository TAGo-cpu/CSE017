/**
 * this is the class for the constructor for the student object
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/25
 */

 public class Student extends Person{
    private String major;

    /**
     * this is a constructor for when there are no values for student 
     */
    public Student(){
        super(0, "none", "none", "none", "none");
    }

    /**
     * this is the constructor that creates the studen
     * @param id this is a integer value that is the ID for the person
     * @param n this is a string that is for the name of the person
     * @param a this is a string that is for the address of the person 
     * @param p this is a string for the phone number of the person 
     * @param e this is a string for the email of the person 
     * @param major this is a string for the major of the perosn 
     */
    public Student(int id, String n, String a, String p, String e, String major){
        super(id, n, a, p, e);
        this.major = major;
    }


    /**
     * this returns the major of the student
     * @return a string for the major of the person is returned 
     */
    public String getMajor(){return major;}

    /**
     * this method overrides the toString() method from the person class to create a string with the info of the student
     */
    @Override
    public String toString(){
        return super.toString() + "Major: " + this.getMajor() + "\n";
     }

     /**
      * this is a method used to set the major of a person 
      * @param major this parameter is a string for the major of the person 
      */
    public void setMajor(String major){
        this.major = major;
    }
}