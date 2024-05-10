/**
 * this is a class that is used to create patient objects used in the program 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/6
 */


public class Patient implements Comparable<Patient>{
    private String name;
    private int age;
    private int type;

    /**
     * this is a constructor for the patient
     * @param n this is a string for the name of the patient
     * @param a this is an integer for the age of the patient
     * @param t this is an integer for the type of the patient 
     */
    public Patient(String n, int a, int t){
        name = n;
        age = a;
        type = t;

    }

    /**
     * this is a method used to return the name of a patient
     * @return this returns a string 
     */
    public String getName(){
        return name;
    }

    /**
     * this is a method used to return the age of a patiet
     * @return this returns an integer
     */
    public int getAge(){
        return age;
    }

    /**
     * this is a method used to return the type of a patient
     * @return returns an integer
     */
    public int getType(){
        return type;
    }

    /**
     * this is a method used to set the name of a patient
     * @param n it is a string for the name
     */
    public void setName(String n){
        name = n;
    }

    /**
     * this is a method used to set the age of a patient
     * @param a this is an integer for the age
     */
    public void setAge(int a){
        age = a;
    }

    /**
     * this is a method used to set the type of a patient
     * @param t this is an integer for the type
     */
    public void setType(int t){
        type = t;
    }

    /**
     * this is a method used to format a string for a patient's info
     */
    public String toString(){
        return String.format("(%-20s, %-2d, %-1d)", name, age, type);
    }

    /**
     * this is a method that checks if the name of two patients match
     */
    public boolean equals(Object o){
        if(o instanceof Patient){
            Patient p = (Patient)o;
            return this.name.equals(p.name);
                }
        return false;
    }

    /**
     * this is a compareTo method used to compare the types of two patients and returns an integer
     */
    public int compareTo(Patient p){
        return this.type - p.type;
    }
}
