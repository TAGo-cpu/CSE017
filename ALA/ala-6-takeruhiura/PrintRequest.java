/**
 * this is a class that is used for print requests 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/12
 */
public class PrintRequest implements Comparable<PrintRequest>{
    private int id;
    private String group;
    private long size;

    /**
     * default constructor for printrequest with default values
     */
    public PrintRequest(){
        id = 0;
        group = "batch";
        size = 0;
    }

    /**
     * constructor for printrequest with parameters for the id, gr, and size
     * @param id this is the integer for the id
     * @param gr this is the string for the group
     * @param size this is the size for the print request
     */
    public PrintRequest(int id, String gr, long size){
        this.id = id;
        group = gr;
        this.size = size;
    }

    /**
     * this is a method that returns the id of the print request
     * @return returns an integer
     */
    public int getID(){return id;}

    /**
     * this is a method that returns the group of the print request
     * @return this returns an integer
     */
    public String getGroup(){return group;}

    /**
     * this is a method that returns the size of the print request
     * @return this returns a long 
     */
    public long getSize() {return size;}

    /**
     * this is a method that sets the id of the print request
     * @param id this is the id used to set which is an integer
     */
    public void setID(int id){this.id = id;}

    /**
     * this is a method to set the group of the print request
     * @param gr this is the string used to set the group
     */
    public void setGroup(String gr){group = gr;}

    /**
     * this is a method used to set the size of the print request
     * @param size this is a long for the size 
     */
    public void setSize(long size){this.size = size;}

    /**
     * this is a method used to convert the printrequest into a formatted string with a converted size
     */
    public String toString() {
        double temp = size;
        String out = "";
        String temp2 ="";
        if (size > 1000000000) {
            temp = temp / 1000000000;
            temp2 = String.format("%.1f", temp);
            out = temp2 + "GB";
        } else if (size > 1000000) {
            temp = temp / 1000000;
            temp2 = String.format("%.1f", temp);
            out = temp2 +  "MB";
        } else if (size > 1000) {
            temp = temp / 1000;
            temp2 = String.format("%.1f", temp);
            out = temp2 + "KB";
        } else {
            temp2 = String.format("%.1f", temp);
            out = temp2 + "Bytes";
        }
    
        return String.format("%-10d\t%-10s\t%-10s", id, group, out);
    }
    

    /**
     * this is a method used to get the priority of the print request 
     * @return returns an integer for the index of the group
     */
    private int getPriority(){
        String[] priorities = {"root", "admin", "user", "batch"};
        for(int i = 0; i < priorities.length; i++){
            if(this.group.equals(priorities[i])){
                return i;

            }
        }
        return -1;
    }

    /**
     * this is a method that compares the print requests bu their priorities 
     */
    public int compareTo(PrintRequest pr){
        return this.getPriority() - pr.getPriority();
    }

}