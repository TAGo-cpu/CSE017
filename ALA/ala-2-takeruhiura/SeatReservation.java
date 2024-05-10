/**
 * this is the file for the seat reservation program 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/3
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class SeatReservation{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Airplane myAirplane = new Airplane("seatsmap.txt");
        int operation = 0;

    /**
     * this is the do while loop to run the seat selection program 
     */
    do{
        System.out.println(myAirplane);
        System.out.println("Select an operation:");
        System.out.println("1: reserve a seat");
        System.out.println("2: free a seat");
        System.out.println("3: quit");
        try{
        operation = keyboard.nextInt();
        String seatNumber;
        switch(operation){
            /**
             * this is the case to reserve a seat
             */
            case 1:
                System.out.println("Enter a seat number: ");
                seatNumber = keyboard.next();
                if(myAirplane.reserveSeat(seatNumber)){
                    System.out.println("Seat " + seatNumber + " successfully reserved.");
                }
                else{
                    System.out.println("Seat " + seatNumber + " " + "already reserved.");
                }
                break;
            /**
             * this is the case to free a seat
             */
            case 2:
                System.out.println("Enter a seat number: ");
                seatNumber = keyboard.next();
                if(myAirplane.freeSeat(seatNumber)){
                    System.out.println("Seat " + seatNumber + " successfully freed.");
                }else{
                    System.out.println("Seat " + seatNumber + " already free.");

                }
                break;
            /**
             * when the case is 3, the program ends and the file for the seat map is saved
             */
            case 3:
                myAirplane.saveMap("seatsmap.txt");
                System.out.println("Thank you for using my airplane seat reservation program");
                break;
            default:
                System.out.println("Invalid operation (1 to 3).");

        }
        }
        catch(InvalidSeatException e){
            System.out.println(e.getMessage());

        }
        catch(InputMismatchException e){
            System.out.println("Invalid input operation");
        }

    } while(operation != 3);
    }
}