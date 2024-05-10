/**
 * this is a class used to create the restored titles in the program 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/14
 */


import java.time.LocalDate;

public class RTitle {

    private Title title;
    private LocalDate date;

    /**
     * this is the constructor to create the RTitle object
     * @param t this is the Title of the object
     * @param d this is the date of the object
     */
    public RTitle(Title t, LocalDate d){
        this.title =t;
        this.date = d;
    }

    /**
     * this gets the title of the object
     * @return returns a title object
     */
    public Title getTitle(){
        return title;

    }

    /**
     * this method gets the date of the object
     * @return returns a LocalDate value
     */
    public LocalDate getDate(){
        return date;

    }



}