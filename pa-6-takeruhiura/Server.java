/**
 * this is a class that creates a server for the simulation
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/24
 */


public class Server{
    private Customer currentCustomer;
    private boolean status;
    private int serviceTime;
 
    /**
     * this is a default constructor for the server
     */
    public Server(){
        this.currentCustomer = null;
        this.status = true;
        this.serviceTime = 0;
    }

    /**
     * this is used to see if a server is free or not
     * @return returns a boolean true if free and false if not
     */
    public boolean isFree(){
        return status;
    }

    /**
     * this is a method used to set the status of a server to false to make it busy 
     */
    public void setBusy(){
        this.status = false;
    }

    /**
     * this is a method used to set the status of a server to true to make it free
     */
    public void setFree(){
        this.status = true;
    }

    /**
     * this gets the service time of a server
     * @return returns an integer for the service time
     */
    public int getServiceTime(){
        return serviceTime;
    }
    
    /**
     * this is a method used to set the service time
     * @param sTime this is an integer for the service time
     */
    public void setServiceTime(int sTime){
        this.serviceTime = sTime;
    }

    /**
     * this is a method used to decrement the service time and makes status true if the time is zero
     */
    public void decrementServiceTime(){
        this.serviceTime--;
        if(this.serviceTime == 0){
            status = true;
        }
    }

    /**
     * this is a method used to set the current customer
     * @param c a customer object is the parameter used to set
     */
    public void setCurrentCustomer(Customer c){
        this.currentCustomer = c;
    }

    /**
     * this is a method used to get the current customer
     * @return returns a customer object
     */
    public Customer getCurrCustomer(){
        return currentCustomer;
    }

    /**
     * this is a toString to return a string for the server
     */
    public String toString(){
        return "Current customer: " + currentCustomer + " Status: " + status + " Service Time: " + serviceTime;
    }

}