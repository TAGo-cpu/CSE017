/**
 * acts like a Title where it is an abstract class with data for a book 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/4
 */


public abstract class Title {
    private String callN;
    private String title;
    private String publisher;
    private int year;
    private int copies;

    /**
     * this is a constructor used to make an abstract Title class with no values for it
     */
    protected Title(){
        this("none", "none", "none", 0, 0);

    }

    /**
     * this is a constructor that takes in variables for the title to make a Title object
     * @param callN this is a string for the call number
     * @param title this is a string for the title
     * @param publisher this is a string for the publisher
     * @param year this is an integer for the year 
     * @param copies this is an integer for the number of copies
     */
    protected Title(String callN, String title, String publisher, int year, int copies){
        this.callN = callN;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
   
    }


    /**
     * method used to return the call number 
     * @return returns a string
     */
    public String getCallN(){return callN;}


    /**
     * this is a method  used to return the title 
     * @return returns a string
     */
    public String getTitle(){return title;}

 
    /**
     * this is a method used to return the publisher 
     * @return returns a string
     */
    public String getPublisher(){return publisher;}


    /**
     * this is a method used to return the year
     * @return returns an integer
     */
    public int getYear(){return year;}


    /**
     * this is a method used to return the number of copies 
     * @return returns an integer
     */
    public int getCopies(){return copies;}


    /**
     * this method overrides the toString method and now returns a formated string to output the info of a book 
     */
    @Override
    public String toString(){
        return String.format("%-12s\t%-35s\t%-25s\t%-5d\t%-7d",
                       callN, title, publisher, year, copies);
}

    /**
     * this method is used to change the call number of an object
     * @param callN this is a string
     */
    public void setCallN(String callN){
        this.callN = callN;
    }

    /**
     * this is a method used to change the title of an object
     * @param title this is a string 
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * this is a method used to change the publisher of an object
     * @param publisher this is a string 
     */
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }


    /**
     * this is a method used to change the year of an object
     * @param year this is an integer
     */
    public void setYear(int year){
        this.year = year;
    }

    /**
     * this is a method used to change the number of copies in an object
     * @param copies this is an integer
     */
    public void setCopies(int copies){
        this.copies = copies;
    }

    /**
     * this method is a method to return a string of the info of one entry 
     * @return this returns a string
     */
    public String simpleToString(){
        return callN + "|" + title + "|" + publisher + "|" + year + "|" + copies;
    }


}