/**
 * this class extends from the shape class to act as a pentagon
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/9
 */

public class Pentagon extends Shape{
    private double side;


    /**
     * this is the constructor for a pentagon with default values
     */
    public Pentagon(){
        super();
        side = 1.0;
    }

    /**
     * this is a constructor for a pentagon with parameters
     * @param c this is the color of the pentagon as a string
     * @param side this is the length of the side of the pentagon as a double
     */
    public Pentagon(String c, double side){
        super(c);
        this.side = side;
    }

    /**
     * this is a method that returns the side of a pentagon
     * @return this is a double
     */
    public double getSide(){return side;}

    /**
     * this is a method that sets the side of a pentagon
     * @param side this is a double
     */
    public void setSide(double side){this.side = side;}


    /**
     * this is an override method that returns a formatted string for the info of a pentagon object
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%-10s\t%-40.2f\t%-10.2f\t%-10.2f", "Pentagon", getColor(), side, getArea(), getPerimeter());
    }


    /**
     * this method calculates and returns a double for the area of a pentagon 
     */
    public double getArea(){
        double a = 1/4.0 * Math.sqrt(5* (5+2*Math.sqrt(5)));
        a *= side * side;
        return a;


    }

    /**
     * this is a method that calculates and returns the perimeter as a double of a pentagon 
     */
    public double getPerimeter(){
        return side * 5;
    }

    /**
     * this is an overridden method from the Scalable class used to scale the sides of the pentagon 
     */
    @Override
    public void scale(double factor){
        side *= factor;
    }

    /**
     * this is a overridden method used to create a deep clone of a pentagon 
     */
    @Override
    public Object clone(){
        return new Pentagon(getColor(), getSide());
    }






}