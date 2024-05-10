/**
 * this is the class for the constructor for the Employee object which extended from the Person class
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/25
 */

public class Employee extends Person{
    private String position;
    private double salary;

    /**
     * this is a constructor for when there is no values for Employee
     */
    public Employee(){
        super(0, "none", "none", "none", "none");
    }

    /**
     * this is a constructor used to create an employee constructor 
     * @param id this is an integer for the id of the person 
     * @param n this is the name of the person stored as a string
     * @param a this is a string for the address of the person 
     * @param p this is the phone number as a string 
     * @param e this is a string that stores the email 
     * @param position this is a string that stores the position of the employee
     * @param salary this is a double that stores the salary of the employee
     */
    public Employee(int id, String n, String a, String p, String e, String position, double salary){
        super(id, n, a, p, e);
        this.position = position;
        this.salary = salary;
    }

    /**
     * this method returns the position of the employee
     * @return this returns a string 
     */
    public String getPosition(){return position;}

    /**
     * this returns the salary of the employee
     * @return this returns a double 
     */
    public double getSalary(){return salary;}

    /**
     * this method is overriden from the person class which also stores the position and salary of the employee into a string 
     */
    @Override
    public String toString(){
        return super.toString() + String.format("Position: %s\nAnnual salary: $%.2f\n", position, salary); }


    /**
     * this method is used to set the position of an employee
     * @param position this is a string for the parameter
     */
    public void setPosition(String position){
        this.position = position;
    }

    /**
     * this method is used to set the salary of an employee 
     * @param salary this parameter is a double 
     */
    public void setSalary(double salary){
        this.salary = salary;
    }

}
