/**
 * this is a class for the simulation of the program which uses customers and servers for the airline program 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/24
 */

public class Simulation{
    public static void main(String[] args){
        System.out.println("\nTest case 1: 1 server, 15 customers/hour, 5mn service time");
        simulation(100, 1, 5, 15);
        System.out.println("\nTest case 2: 1 server, 20 customers/hours, 5mn service time");
        simulation(100, 1, 5, 20);
        System.out.println("\nTest case 3: 2 servers, 15 customers/hours, 5mn service time");
        simulation(100, 2, 5, 15);
        System.out.println("\nTest case 4: 2 servers, 20 customers/hours, 5mn service time");
        simulation(100, 2, 5, 20);
        System.out.println("\nTest case 5: 1 server, 15 customers/hour, 10mn service time");
        simulation(100, 1, 10, 15);
        System.out.println("\nTest case 6: 1 server, 20 customers/hour, 10mn service time");
        simulation(100, 1, 10, 20);
        System.out.println("\nTest case 7: 2 servers, 15 customers/hour, 10mn service time");
        simulation(100, 2, 10, 15);
        System.out.println("\nTest case 8: 2 servers, 20 customers/hour, 10mn service time");
        simulation(100, 2, 10, 20);
    }
    /**
     * Method to run the simulation of a queueing systems (queue of customers and list of servers)
     * @param time duration of the simulation in minutes
     * @param servers number of servers in the list of servers
     * @param serviceTime the average time a server takes to serve one customer
     * @param arrivalRate the rate at which customers arrive in an hour
     */
    public static void simulation(int time, int servers, int serviceTime, int arrivalRate){
        ServerList serverList = new ServerList(servers);
        CustomerQueue customerQueue = new CustomerQueue();
        int totalC = 0;
        int totalTime = 0;

        for (int clock = 0; clock < time; clock++) {
            serverList.updateServiceTime();

            if(!customerQueue.isEmpty()){
            customerQueue.updateWaitingTime();
            }

            double p = Math.random();
            if (p < (arrivalRate/60.0)) {
                Customer newC = new Customer(totalC, clock,0); 
                customerQueue.addCustomer(newC); 
                totalC++;
            }
            
            while ((serverList.getFreeServer() != -1) && (!customerQueue.isEmpty())) {
                int freeIndex = serverList.getFreeServer();
                Customer c = customerQueue.getNextCustomer();
                totalTime += c.getWaitingTime();
                serverList.setServerBusy(freeIndex, c, serviceTime);
                
            } 
            
            
        }

        int customersServed = totalC - customerQueue.size() - serverList.getBusyServers();
        System.out.println("Simulation Parameters");
        System.out.println("\tSimulation time: " + time + " minutes");
        System.out.println("\tNumber of servers: " + servers);
        System.out.println("\tCustomer Arrival Rate: " + arrivalRate + " customers per hour");
        System.out.println("\tService time: " + serviceTime + " minutes");
        System.out.println();
        System.out.println("Simulation started...");
        System.out.println("Simulation completed.");
        System.out.println();
        System.out.println("\nSimulation Results");
        System.out.println("\tTotal number of customers: " + totalC);
        System.out.println("\tNumber of customers served: " + customersServed);
        System.out.println("\tNumber of customers still being served: " + serverList.getBusyServers());
        System.out.println("\tNumber of customers left in the queue: " + (totalC-customersServed-serverList.getBusyServers()));
        while (!customerQueue.isEmpty()) {
            Customer c = customerQueue.getNextCustomer();
            totalTime += c.getWaitingTime();
        }
        double averageT = (double) totalTime / totalC;
        System.out.printf("\tAverage waiting time per customer: %.2f\n", averageT);
   }
}