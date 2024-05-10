
/**
 * this is a class to create a student object used to test the sorting algorithm 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/11
 */
public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double gpa;


    /**
     * this is a default constructor for a student
     */
    public Student(){
        this.id = 0;
        this.name = "";
        this.gpa = 0.0;
    }

    /**
     * this is a constructor for a student with custom parameters
     * @param id this is the integer for the id of the student
     * @param name this is a string for the name of the student
     * @param gpa this is a double for the gpa of the student
     */
    public Student(int id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    /**
     * this is a method used to return the id of a student
     * @return this will return a int
     */
    public int getID(){
        return id;
    }

    /**
     * this is a method used to get the name of a student
     * @return this returns a string 
     */
    public String getName(){
        return name;
    }

    /**
     * this is a method used to get the gpa of a student
     * @return this returns a double
     */
    public double getGPA(){
        return gpa;
    }

    /**
     * this is a method used to set the id of a student
     * @param id this is the int for the id 
     */
    public void setID(int id){
        this.id = id;
    }

    /**
     * this method is used to set the name of a student
     * @param name this takes in a string for the name 
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * this is a method used to set the gpa of a student
     * @param gpa this is a double for the gpa
     */
    public void setGPA(double gpa){
        this.gpa = gpa;


    }

    /**
     * this is a method used to return a formatted string for a student's info
     */
    public String toString(){
        return String.format("%-17d%-20s\t%20.2f", id, name, gpa);
    }

    /**
     * this is a method that returns an integer based on the difference of id numbers of two students 
     */
    public int compareTo(Student s){
        return this.id - s.id;
    }

}
