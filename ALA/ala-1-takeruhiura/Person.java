/**
 * this is the abstract class which creates the person object used to create other types of people 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/25
 */



public abstract class Person{
    protected int id;
    protected String name, address, phone, email;

    /**
     * this is a constructor for when there are no values for Person 
     */
    protected Person(){
        this(0, "none", "none", "none", "none");

    }
    /**
     * this is the Person constructor used as the parent class for the other types of people 
     * @param id this is an integer for the id of the person 
     * @param n this is the name of the person stored as a string
     * @param a this is a string for the address of the person 
     * @param p this is the phone number as a string 
     * @param e this is a string that stores the email 
     */
    protected Person(int id, String n, String a, String p, String e){
        this.id =  id;
        name = n;
        address = a;
        phone = p; email = e;
    }

    /**
     * method that returns the person's id
     * @return this returns an integer 
     */
    public int getID(){ return id;}

    /**
     * this is a method that returns a name of a person 
     * @return this returns a string 
     */
    public String getName(){return name;}

    /**
     * this is a method that returns the address of a person 
     * @return this returns a string 
     */
    public String getAddress() {return address;}

    /**
     * this is a method for the phone number of a person 
     * @return this returns a string 
     */
    public String getPhone() {return phone;}

    /**
     * this method returns the email of a person 
     * @return this returns a string 
     */
    public String getEmail() {return email;}

    /**
     * this is an overriden method that will store the info of a person in a string 
     */
    @Override
    public String toString(){
        String str = String.format("ID: %d\nName: %s\nAddress: %s\nPhone: %s\nEmail: %s\n", 
                                   id, name, address, phone, email);
        return str;
    }
    /**
     * a method used to set a person's id
     * @param id this is an integer
     */
    public void setID(int id){
        this.id = id;
    }

    /**
     * this is a method to set a person's name 
     * @param name this is a string value
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * this is a method to set the address of a person 
     * @param address this is a string 
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * this is to set the phone number of a person 
     * @param phone this is a string 
     */
    public void setPhone(String phone){
        this.phone = phone;
    }


    /**
     * this is to set the email of a person 
     * @param email this is a string 
     */
    public void setEmail(String email){
        this.email = email;
    }




    }