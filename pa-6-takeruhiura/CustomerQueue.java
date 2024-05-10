/**
 * this is a class that uses queues to create a customer queue with the customer object
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/24
 */


import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue{

private Queue<Customer> customers;

/**
 * this is a default constructer to create a customer queue
 */
public CustomerQueue(){
    customers = new LinkedList<>();
}

/**
 * this will return the customer at the front of the queue and null if the queue is empty
 * @return returns the next customer object or null if empty
 */
public Customer getNextCustomer() {
    if(customers.isEmpty()){
        return null;
    }
    else{
        return customers.poll();
    }
}

/**
 * this is a method used to increment waiting time of a queue
 */
public void updateWaitingTime(){
    for(Customer c: customers){
        c.incrementWaitingTime();
    }
}

/**
 * this is a method used to add a customer to the queue at the back
 * @param c this is the customer object that is added
 */
public void addCustomer(Customer c){
 customers.offer(c);
}

/**
 * this is a method used to check if a queue is empty
 * @return this returns a boolean true if empty and false if not 
 */
public boolean isEmpty(){
    return customers.isEmpty();
}

/**
 * this is a method used to return the size of the queue
 * @return returns an integer for the size
 */
public int size(){
    return customers.size();
}

/**
 * used to return a string for the queue
 */
public String toString(){
    return "Customer Queue: " + customers;
}


}
