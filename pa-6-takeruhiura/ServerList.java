/**
 * this is a class which uses the server object to create a list of servers using an arraylist
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/24
 */


import java.util.ArrayList;

public class ServerList {
    private ArrayList<Server> list;

    /**
     * this is a constructor for server list which makes a list depending on the count
     * @param count this is the integer parameter for the number of servers
     */
    public ServerList(int count) {
        list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new Server());
        }
    }

    /**
     * this is a method used to return the first free server in a list and -1 if none are free
     * @return returns an integer for the index of the first free server and -1 if all are busy
     */
    public int getFreeServer() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isFree()) {
                return i; 
            }
        }
        return -1; 
    }

    /**
     * this is a method used to set a server to busy and first checks the index to see if it is valid
     * @param i this is the index for the server to set it to busy
     * @param c this is a the customer that is used to set to current customer
     * @param st this is the service time used to set the time
     * @throws ArrayIndexOutOfBoundsException this is thrown if the index parameter is invalid according to the if statement
     */
    public void setServerBusy(int i, Customer c, int st) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Server server = list.get(i);
        server.setCurrentCustomer(c);
        server.setServiceTime(st);
        server.setBusy();
    }

    /**
     * this is a method that iterates through a server list and decrements the service time for busy servers
     */
    public void updateServiceTime() {
        for (Server server : list) {
            if (!server.isFree()) {
                server.decrementServiceTime();
            }
        }
    }

    /**
     * this method is used to return the number of busy servers in a list
     * @return returns an integer for the number of busy servers
     */
    public int getBusyServers() {
        int count = 0;
        for (Server server : list) {
            if (!server.isFree()) {
                count++;
            }
        }
        return count;
    }

    /**
     * returns a string for a server list
     */
    public String toString(){
        return "Server List: " + list;
    }
}
