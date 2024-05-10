
/**
 * this is a class used for the catalog of the system for books 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/31
 */


public class Catalog {

    private Title[] titles;
    private int count;

    /**
     * this method is the Catalog constructor which setups a catalog for different titles 
     */
    public Catalog(){
    
    titles = new Title[50];
    count = 0;

    }



    /**
     * this method gets the count in the catalog
     * @return returns an integer
     */
    public int getCount(){return count;}

    /**
     * this method will return true when it adds a title to the catalog and false when there is no space left
     * @param title this is a Title data value from the title class
     * @return this returns a boolean 
     */
    public boolean addTitle(Title title){

        if (count == 50){
            return false;
        }else{
            titles[count] = title;
            count++;
            return true;
        }

    }

    /**
     * this method returns a title if it finds it in the catalog and null if it cannot find it 
     * @param callN this is a string value for the call number
     * @return this returns a Title value or null 
     */
    public Title findCallN(String callN){
        for(int i = 0; i < count; i++){
            if(callN.equals(titles[i].getCallN())){
                return titles[i];
            }

        }
        return null;
    }

    /**
     * this method will find the titles in the catalog that matches the parameter and store them in an array, the array is returned if not null 
     * @param title this is a string value used to search for the title 
     * @return this returns an array of titles or null 
     */
    public Title[] findTitle(String title){
        int total = 0;
        for(int i = 0; i < count; i++){
            if(title.equals(titles[i].getTitle())){
                total++;
            }

        }

        if (total == 0){
            return null;
        }
        Title[] tempTitles = new Title[total];
        int index = 0;
        for(int i = 0; i < count; i++){
            if(title.equals(titles[i].getTitle())){
                tempTitles[index] = titles[i];
                index++;
            }
        }
        return tempTitles;
    }

    /**
     * this method finds the titles with the same year the user inputs and returns either an array of titles with that year or null if nothing is found
     * @param year this is an integer value 
     * @return this returns the array of titles or null 
     */
    public Title[] findYear(int year){
        int total = 0;
        for(int i = 0; i < count; i++){
            if(year == titles[i].getYear()){
                total++;
            }

        }
        if (total == 0){
            return null;
        }
        Title[] tempTitles = new Title[total];
        int index = 0;
        for(int i = 0; i < count; i++){
            if(year == titles[i].getYear()){
                tempTitles[index] = titles[i];
                index++;
            }
        }
        return tempTitles;
    }


    /**
     * this method uses insertion sort to sort the catalog by years in ascending order
     */
    public void sort(){
        for(int i=1; i<count; i++){
        Title titleName = titles[i];
        int currentVal = titleName.getYear();
        int j = i;
        while(j > 0 && currentVal < titles[j-1].getYear()){     
            titles[j] = titles[j-1];
                j--;
            }
            titles[j] = titleName;
        }
    }

/**
 * this method is overrided from the java toSring which is used to make a formatted string with headers for each specifc category and all the titles in the array 
 */
@Override
public String toString(){
    String str = String.format("%-12s\t%-35s\t%-25s\t%-5s\t%-7s\t%-15s\t%-10s\t",
                   "Call Number", "Title", "Publisher", "Year", "#Copies", "Author/Month", "ISBN/Issue");

    for (int i=0; i<count; i++){
        str = str + "\n" + titles[i].toString();
    }
    return str;
}


}