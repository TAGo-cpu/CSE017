/**
 * this is a class that extends from title to create a periodical object
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/14
 */


public class Periodical extends Title {

private int month;
private int issue;

/**
 * this is the Periodical constructor for when it has no values
 */
public Periodical(){
    super("none", "none", "none", 0, 0);
}

/**
 * this is a constructor to create a Periodical object
 * @param callN this is a string for the call number
 * @param title this is a string for the title
 * @param publisher this is a string for the publisher
 * @param year this is an integer for the year 
 * @param copies this is an integer for the number of copies
 * @param month this is a int datatype for the month of the Periodical 
 * @param issue this is an integer for the issue of the Periodical 
 */
public Periodical(String callN, String title, String publisher, int year, int copies, int month, int issue){
    super(callN, title, publisher, year, copies);
    this.month = month;
    this.issue = issue;
}

/**
 * this is a method to get the month 
 * @return returns a Month datatype 
 */
public int getMonth(){return month;}

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
    String[] months = {"January", "February", "March", "April", "June", 
                       "July", "August", "September", "October", 
                       "November", "December"};
    return super.toString() + 
              String.format("\t%-15s\t%-10d", months[month-1], issue);
}

/**
 * this is a method to set the month
 * @param month this is a int datatype
 */
public void setMonth(int month){
    this.month = month;
}

/**
 * this is a method to set the issue 
 * @param issue this is an integer
 */
public void setIssue(int issue){
    this.issue = issue;
}

/**
 * this is an override from the title class which also includes the month and issue of the string 
 */
@Override
public String simpleToString(){
    return super.simpleToString() + "|" + month + "|" + issue;
}
}