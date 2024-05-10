/**
 * this class extends from the shape class to act as a circle object
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/9
 */


public class Circle extends Shape{
    private double radius;

    /**
     * this is the constructor for a circle with default values
     */
    public Circle(){
        super();
        radius = 1.0;

    }

    /**
     * this is the constructor for a circle with parameters
     * @param c this is a string for the color of the circle
     * @param r this is a double for the radius of the circle
     */
    public Circle(String c, double r){
        super(c);
        radius = r;
    
    }

    /**
     * this is the method to return the radius
     * @return this is a double
     */
    public double getRadius(){return radius;}

    /**
     * this is the method to set the radius of a circle
     * @param r this is a double
     */
    public void setRadius(double r){radius = r;}

    /**
     * this is a method toString which is an override used to format the info of a circle into a string
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%-10s\t%-40.2f\t%-10.2f\t%-10.2f", "Circle", getColor(), radius, getArea(), getPerimeter());
    }

    /**
     * this is a method that calculates the area of a circle and is a double
     */
    public double getArea(){
        return Math.PI * radius * radius;
    }

    /**
     * this is a method that calculates the parameter of the circle as a double
     */
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    /**
     * this is the method which is an override from the Scalable interface used to scale the radius of the circle
     */
    @Override
    public void scale(double f){
        radius *= f;
    }

    /**
     * this is a overridden method that creates a deep clone of the circle object 
     */
    @Override
    public Object clone(){
        return new Circle(getColor(), radius);
    }


}