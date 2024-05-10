/**
 * this is a class to create a customer object which is used for the simulation program 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/24
 */

public class Customer{

        private int customerNo;
        private int arrivalTime;
        private int waitingTime;


    /**
     * this is the constructor used to create a customer object
     * @param cn this is an integer for the customer number
     * @param at this is an integer for the arrival time
     * @param wt this is an integer for the waiting time 
     */
    public Customer(int cn, int at, int wt){
        this.customerNo = cn;
        this.arrivalTime = at;
        this.waitingTime = wt;
    }

    /**
     * this is a method used to return the customer number
     * @return this returns an integer
     */
    public int getCustomerNo(){
        return customerNo;
    }

    /**
     * this is a method used to return the arrival time
     * @return this returns an integer
     */
    public int getArrivalTime(){
        return arrivalTime;
    }


    /**
     * this is a method used to return the waiting time 
     * @return this returns an integer
     */
    public int getWaitingTime(){
        return waitingTime;
    }

    /**
     * this is a method used to set the customer number of a customer
     * @param cn this parameter is an integer for the customer number 
     */
    public void setCustomerNo(int cn){
        this.customerNo = cn;
    }

    /**
     * this is a method used to set the arrival time for a customer
     * @param at this is the integer for the arival time
     */
    public void setArrivalTime(int at){
        this.arrivalTime = at;
    }

    /**
     * this is a method used to set the waiting time for a customer
     * @param wt this is an integer for the waiting time
     */
    public void setWaitingTime(int wt){
        this.waitingTime = wt;
    }

    /**
     * this is a method used to increment the waiting time 
     */
    public void incrementWaitingTime(){
        waitingTime++;
    }

    /**
     * this is a to string for the customer 
     */
    public String toString(){
        return "Customer Number: " + customerNo + " Arrival Time: " + arrivalTime + " Waiting Time: " + waitingTime;
    }
}
