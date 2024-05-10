/**
 * this class extends from the shape class to act as a class for a rectangle object
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/9
 */

public class Rectangle extends Shape{
    private double length, width;

    /**
     * this is a constructor used to create a rectangle with default values
     */
    public Rectangle(){
        super();
        length = width = 1.0;
    }

    /**
     * this is a constructor used to create a rectangle with parameters 
     * @param c
     * @param l
     * @param w
     */
    public Rectangle(String c, double l, double w){
        super(c);
        length = l;
        width = w;

    }
    /**
     * this method returns the length of the rectangle
     * @return it returns a double
     */
    public double getLength() {return length;}

    /**
     * this method returns the width of the rectangle
     * @return it is a double
     */
    public double getWidth() {return width;}

    /**
     * ths method is used to set the length of the rectangle
     * @param l the parameter is a double
     */
    public void setLength(double l){length = l;}
    

    /**
     * the method is used to set the width of the rectangle
     * @param w the parameter is a double
     */
    public void setWidth(double w){width = w;}

    /**
     * this is an overridden method that is used to format a string for the info of a rectangle
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%-10s\t%-10.2f\t%-30.2f\t%-10.2f\t%-10.2f", "Rectangle", getColor(), length, width, getArea(), getPerimeter());
    }

    /**
     * this is a method used to calculate and return the area of a rectangle as a double
     */
    public double getArea(){
        return length * width;
    }

    /**
     * this is a method used to calculate and return the perimeter of a rectangle as a double
     */
    public double getPerimeter(){
        return 2 * (length + width);

        
    }

    /**
     * this is an overridden method used to scale the length and width of a rectangle
     */
    @Override
    public void scale(double f){
        length *= f;
        width *= f;

    }

    /**
     * this is a overridden method which creates a deep clone of a rectangle
     */
    @Override
    public Object clone(){
        return new Rectangle(getColor(), length, width);
    }
}