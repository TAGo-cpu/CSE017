
/**
 * this is a class used for a Book constructor which is extended from Title 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/31
 */


public class Book extends Title {

private String author;
private String ISBN;

/**
 * this is a book constructor for when there are no values for it 
 */
public Book(){
    super("none", "none", "none", 0, 0);
}

/**
 * this is a book constructor and is overloaded, used when there are values for a book 
 * @param callN this is a string for the call number
 * @param title this is a string for the title
 * @param publisher this is a string for the publisher
 * @param year this is an integer for the year 
 * @param copies this is an integer for the number of copies
 * @param author this is a string value for the author
 * @param ISBN this is a string value for the ISBN
 */
public Book(String callN, String title, String publisher, int year, int copies, String author, String ISBN){
    super(callN, title, publisher, year, copies);
    this.author = author;
    this.ISBN = ISBN;
}

/**
 * this is a method to return the author 
 * @return returns a string 
 */
public String getAuthor(){return author;}

/**
 * this is a method that returns the ISBN
 * @return returns a string 
 */
public String getISBN(){return ISBN;}


/**
 * this is a overridden method from the Title class which now includes the author and ISBN in the formatted string 
 */
@Override
public String toString(){
     return super.toString() + String.format("\t%-15s\t%-10s\t",
                   author, ISBN);
}

/**
 * this is a method to set the author
 * @param author the parameter is a string 
 */
public void setAuthor(String author){
    this.author = author;
}

/**
 * this is a method to set the ISBN
 * @param ISBN the parameter is a string 
 */
public void setISBN(String ISBN){
    this.ISBN = ISBN;
}
}