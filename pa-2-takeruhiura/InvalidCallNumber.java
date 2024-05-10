/**
 * this is a class used for a Book constructor which is extended from Title 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/4
 */

public class InvalidCallNumber extends Exception{

    /**
     * this is a default constructor for the exception that returns a static error message
     */
    public InvalidCallNumber(){
        super("Invalid Call Number");
    }

    /**
     * this is a constructor that can display a different error message based on the parameter
     * @param message this is a string for the error message
     */
    public InvalidCallNumber(String message){
        super(message);
        
    }
}