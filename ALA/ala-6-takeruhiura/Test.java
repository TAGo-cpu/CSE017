/**
 * this is the test class used to evaluate the postfix expressions and outputs the methods from printrequest
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/12
 */

import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.io.File;
import java.io.FileNotFoundException;;
public class Test {
    public static void main(String[] args){
    //keeps running until no is entered
    while(true){
        Stack<Integer> postfixStack = new Stack<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a postfix expression:");
        String postfix = keyboard.nextLine();
        String[] tokens = postfix.split(" ");
        //checks the imput from the user to see if they are valid
        try{
        for(String token: tokens){
            if(token.matches("\\d{1,}")){
                int operand = Integer.parseInt(token);
                postfixStack.push(operand);

            }
            else{

                int operand1 = postfixStack.pop();
                int operand2 = postfixStack.pop();
                //does each operation based on the input 
                switch(token){
                    case "*":
                    postfixStack.push(operand1 * operand2);
                    break;
                    case "+":
                    postfixStack.push(operand1 + operand2);
                    break;
                    case "-":
                    postfixStack.push(operand2 - operand1);
                    break;
                    case "/":
                    postfixStack.push(operand2/operand1);
                    break;
                    default:
                    throw new NoSuchElementException();
                }
            }
        }

        int result = postfixStack.pop();
        if(postfixStack.isEmpty()){
            //prints the result to the user
            System.out.println("Result = " + result);

        }
        else{
            System.out.println("Malformed postfix expression");
        }
    }
    catch(NoSuchElementException e){
        System.out.println("Malformed postifx expression");
    }
    //asks to try another expression
    System.out.println("Do you want to evaluate another postfix expression? (yes/no):");
    String entry = keyboard.nextLine();
    
    if(entry.equals("no")) {
        break; 
    }
    

}
    System.out.println();
    String header = String.format("%-10s\t%-10s\t%-10s\t%-10s", "User ID", "Group", "Size", "Completion time");
    System.out.println(header); 
    PriorityQueue<PrintRequest> pQueue = new PriorityQueue<>();
    File file = new File("requests.txt");
    //used to read the provided file and stores it into a printrequest object
    try{
        Scanner read = new Scanner(file);
        while(read.hasNext()){
            int id = read.nextInt();
            String group = read.next();
            long size = read.nextLong();
            PrintRequest pr = new PrintRequest(id, group, size);
            pQueue.offer(pr);
        }
        read.close();
    }
    catch(FileNotFoundException e){
        System.out.println("File not found.");
    }
    long printSpeed = 10000;
    long totalTime = 0;
    //used to determine the time for each request and outputs to the user
    while(!pQueue.isEmpty()){
        PrintRequest pr = pQueue.poll();
        long time = pr.getSize()/printSpeed;
        totalTime += time;
        System.out.printf("%s\t%s\n", pr, formatTime(time));;

    }
    System.out.println();
    System.out.println();
    System.out.println("Total Printing Time: " + formatTime(totalTime));

    }

    /**
     * this is a method used to convert the time into a formatted output
     * @param time this is the time in seconds that is converted
     * @return returns a formatted string for the time 
     */
    public static String formatTime(long time) {
        long days =0;
        long hours =0;
        long minutes =0;
        long seconds =0;

        if(time > 24*3600){
            days = time/(24*3600);
            time = time - (days*24*3600);
        }if(time > 3600){
            hours = time/3600;
            time = time - hours*3600;
        }if(time > 60){
            minutes = time/60;
            time = time - 60*minutes;
        }
        seconds = time;
    
        return String.format("%02d:%02d:%02d:%02d", days, hours, minutes, seconds);
    }
    
}