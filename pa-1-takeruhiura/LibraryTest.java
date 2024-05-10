/**
 * this is a class that is used to test the classes created in this assignment
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/31
 */

public class LibraryTest{
    public static void main(String[] args){
        // Create an instance of the class Catalog
        Catalog myLibrary = new Catalog();
        System.out.println("Test case 1: create a new catalog");
        System.out.println("A new catalog was created with " + myLibrary.getCount() + " titles");
        System.out.println();
        // Testing addTitle()
        System.out.println("\nTest case 2: add new titles");
        myLibrary.addTitle(new Periodical("P-111-222-333", "ACM Transactions on Algorithms", "ACM", 2005, 5, Month.values()[8], 2));
        myLibrary.addTitle(new Book("B-111-111-111", "Introduction to Java Programming", "Pearson",2021, 10, "M. Savitch", "9876579310"));
        myLibrary.addTitle(new Book("B-222-111-111", "Programming and Data Structures", "McGraw Hill",2018,  5, "Brian Lang", "9878879310"));
        myLibrary.addTitle(new Periodical("P-111-111-333", "ACM Transactions on Communications", "ACM", 2005, 2, Month.values()[6], 1));
        myLibrary.addTitle(new Periodical("P-111-111-111", "IEEE Software", "IEEE Computer Society", 1983, 1, Month.values()[5], 3));
        myLibrary.addTitle(new Periodical("P-222-111-333", "IEEE Spectrum", "IEEE Computer Society", 2020, 1, Month.values()[8], 1));
        myLibrary.addTitle(new Book("B-222-333-111", "Introduction to C Language", "Wiley", 2005, 2, "James Foster", "1203324661"));
        myLibrary.addTitle(new Book("B-222-222-222", "Introduction to Java Programming", "Cengage", 2018, 2, "G. Albert", "9876759310"));
        System.out.println(myLibrary.getCount() + " titles added to myLibrary");
        System.out.println();

        // view the list of titles
        System.out.println("Test case 3: view all titles");
        System.out.println(myLibrary.toString());
        System.out.println();

        // find a title by call number (successful search)
        System.out.println("Test case 4: find title by call number (succesfull)");
        testFindCallN(myLibrary, "B-111-111-111");
        System.out.println();
        // find a title by call number (failed search)
        System.out.println("Test case 5: find title by call number (fail)");
        testFindCallN(myLibrary, "B-333-333-333");
        System.out.println();

        System.out.println("Test case 6: find titles by title (one title found)");
        // find titles with the same title (search returns one title)
        testFindTitle(myLibrary, "Programming and Data Structures");
        System.out.println();
        // find titles with the same title (search returns more than one title)
        System.out.println("Test case 7: find titles by title (more than one title found)");
        testFindTitle(myLibrary, "Introduction to Java Programming");
        System.out.println();
        // find titles with the same title (search returns no title)
        System.out.println("Test case 8: find titles by title (no title found)");
        testFindTitle(myLibrary, "Introduction to Python");
        System.out.println();

        System.out.println("Test case 9: find titles by year (one title found)");
         // find titles with the same publication year (search returns one title)
        testFindYear(myLibrary, 2021);
        System.out.println();
        System.out.println("Test case 10: find titles by year (more than one title found)");
        // find titles with the same publication year (search returns more than one title)
        testFindYear(myLibrary, 2005);
        System.out.println();
        // find titles with the same publication year (search returns no title)
        System.out.println("Test case 11: find titles by year (no title found)");
        testFindYear(myLibrary, 2019);
        System.out.println();

        System.out.println("Test case 12: sort the titles by year");
        // sort the titles by year
        myLibrary.sort();
        System.out.println(myLibrary.toString());
    }
    public static void testFindCallN(Catalog catalog, String calln){
        Title title = catalog.findCallN(calln);
        if(title == null){
            System.out.println("No title found with call number " + calln);
        }
        else{
            System.out.println("Title found with call number " + calln + ":");
            System.out.println(title);
        }
    }
    public static void testFindTitle(Catalog catalog, String title){
        Title[] titles = catalog.findTitle(title);
        if (titles == null){
            System.out.println("No titles found with the title: " + title);
        }
        else{
            if (titles.length > 1){
                System.out.println(titles.length + " titles found with the title: " + title);
                for(Title t: titles){
                    System.out.println(t);
                }
            }
            else{
                System.out.println("One title found with the title: " + title);
                System.out.println(titles[0]);
            }
        }
        System.out.println();
    }
    public static void testFindYear(Catalog catalog, int year){
        Title[] titles = catalog.findYear(year);
        if (titles == null){
            System.out.println("No titles found for the year " + year);
        }
        else{
            if (titles.length > 1){
                System.out.println(titles.length + " titles found for the year " + year + ":");
                for(Title t: titles){
                    System.out.println(t);
                }
            }
            else{
                System.out.println("One title found for the year " + year + ":");
                System.out.println(titles[0]);
            }
        }
        System.out.println();
    }
}