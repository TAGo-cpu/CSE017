/**
 * this is the class that is extended from Exception to create the exceptions for an invalid seat number
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/3
 */

public class InvalidSeatException extends Exception{

    /**
     * this is a default constructor for the exception that returns a static error message
     */
    public InvalidSeatException(){
        super("Invalid Seat Number");
    }

    /**
     * this is a constructor that can display a different error message based on the parameter
     * @param message this is a string for the error message
     */
    public InvalidSeatException(String message){
        super(message);
        
    }
}