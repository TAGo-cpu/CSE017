/**
 * this is a class to create a coordinate object used in the map class
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/2
 */
public class Coordinate{

    private int x, y;

    /**
     * this is a default constructor for coordinate that has x and y as 0 
     */
    public Coordinate(){
        this.x = 0;
        this.y = 0;

    }

    /**
     * this is constructor that takes in parameters for x and y 
     * @param x this is an integer for the x coordinate
     * @param y this is an integer for the y coordinate
     */
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;

    }

    /**
     * this is the get method used to return the x coordinate
     * @return this returns an integer
     */
    public int getX(){
        return this.x;
    }

    /**
     * this is the get method used to return the y coordinate 
     * @return this returns an integer
     */
    public int getY(){
        return this.y;
    }

    /**
     * this is a method used to set the x coordinate 
     * @param x this is an integer used to set the x coordinate
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * this is a method used to set the y coordinate
     * @param y this is an integer used to set the y coordinate
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * this is a method used to output the x and y coordinates as a string 
     */
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }



}
