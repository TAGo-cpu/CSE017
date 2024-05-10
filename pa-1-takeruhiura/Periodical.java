/**
 * this is a class that extends from title to create a periodical object
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/31
 */


public class Periodical extends Title {

private Month month;
private int issue;

/**
 * this is the Periodical constructor for when it has no values
 * @param issue2 
 * @param month2 
 * @param copies 
 * @param year 
 * @param publisher 
 * @param bookTitle 
 * @param callN 
 */
public Periodical(String callN, String bookTitle, String publisher, int year, int copies, int month2, int issue2){
    super("none", "none", "none", 0, 0);
}

/**
 * this is a constructor to create a Periodical object
 * @param callN this is a string for the call number
 * @param title this is a string for the title
 * @param publisher this is a string for the publisher
 * @param year this is an integer for the year 
 * @param copies this is an integer for the number of copies
 * @param month this is a Month datatype for the month of the Periodical 
 * @param issue this is an integer for the issue of the Periodical 
 */
public Periodical(String callN, String title, String publisher, int year, int copies, Month month, int issue){
    super(callN, title, publisher, year, copies);
    this.month = month;
    this.issue = issue;
}

/**
 * this is a method to get the month 
 * @return returns a Month datatype 
 */
public Month getMonth(){return month;}

/**
 * this is a method to get the issue
 * @return returns an integer
 */
public int getIssue(){return issue;}

/**
 * this is an overridden method from the Title class which also now includes the month and issue in the string 
 */
@Override
public String toString(){

     return super.toString() + String.format("\t%-15s\t%-10s\t",
                   month, issue);
}

/**
 * this is a method to set the month
 * @param month this is a month datatype
 */
public void setMonth(Month month){
    this.month = month;
}

/**
 * this is a method to set the issue 
 * @param issue this is an integer
 */
public void setIssue(int issue){
    this.issue = issue;
}
}