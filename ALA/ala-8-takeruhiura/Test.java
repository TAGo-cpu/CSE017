/**
 * this is a class that is used to display the results of the priority queue and its number of iterations 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/6
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args){
        PriorityQueue<Patient> emergencyRoom = new PriorityQueue<>();
        readPatients(emergencyRoom, "patients.txt");
        System.out.println();
        int counter = 0, total = 0;
        System.out.println("Performance of the method poll(E)");
        while(!emergencyRoom.isEmpty()){
            Patient p = emergencyRoom.poll();
            total+= MinHeap.removeIterations;
            if(counter % 25 == 0){
                System.out.printf("%s\t %-10d\n", p.toString(), MinHeap.removeIterations);
            }
            counter++;
        }
        System.out.printf("%s\t\t %-10d\n", "Average # iterations", total/counter);
    }

    /**
     * this is a method used to read a file and display each patient and the number of iterations for the offer method from the priority queue
     * @param er this is the priority queue that each patient from the file is added into
     * @param filename this is the file that is read to get each patient 
     */
    public static void readPatients(PriorityQueue<Patient> er, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            int counter = 0, total = 0;
            System.out.println("Performance of the method offer(E)");
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] tokens = line.split(",");
                int age = Integer.parseInt(tokens[1]);
                int type = Integer.parseInt(tokens[2]);
                Patient p = new Patient(tokens[0], age, type);
                er.offer(p);
                total += MinHeap.addIterations;
                if(counter % 25 == 0){
                    System.out.printf("%s\t %-10d\n", p.toString(), MinHeap.addIterations);
                }
                counter++;
            }
            System.out.printf("%10s\t\t %-10d\n", "Average # iterations", total/counter);
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
//DISCUSSION:
//Overall, the offer() and poll() methods have time complexities of O(log(n)) so regardless
//of the 500 patients, the number of iterations should be very small. In the offer() method
//the number of iterations is small and average out to be 1. The number of iterations for poll()
//however, is 6 which is somewhat greater than the number of iterations for offer(). The number of
//iterations for poll() can only go up to 9 because 9 is the closest integer to the time complexity
//of log(500) where log is base 2. This is the number of iterations to go down a single path in a 
//tree. Overall, these small number of iterations supports the time complexity of these values which
// is O(log(n)) and that the the offer() method has less iterations than the poll() method. 
}
