/**
 * this is an abstract class which acts as the parent class for other shapes
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/9
 */
public abstract class Shape implements Comparable<Shape>, Scalable, Cloneable{
    private String color;

    /**
     * this is a constructor for a shape with a default value for shape
     */
    protected Shape(){
        color = "White";
    }

    /**
     * this is a constructor for a shape that takes in a parameter for the color
     * @param c this is a string 
     */
    protected Shape(String c){
        color = c;
    }

    /**
     * this method returns the color of the shape
     * @return this is a string
     */
    public String getColor() {return color;}

    /**
     * this method is used to set the color of the shape
     * @param c this is a string 
     */
    public void setColor(String c){color = c;}

    /**
     * this is a method which is an override to return a formatted string for the color of a shape
     */
    @Override
    public String toString(){
        return String.format("%-10s", color);
    }

    /**
     * this is a method to return the area of a shape
     * @return returns a double
     */
    public abstract double getArea();

    /**
     * this is a method to return the perimeter of a shape
     * @return returns a double
     */
    public abstract double getPerimeter();

    /**
     * this is a overridden method used to clone a shape
     */
    @Override
    public abstract Object clone();

    /**
     * this is a overridden method used to scale a shape
     */
    @Override
    public abstract void scale(double f);


    /**
     * this is an overriden method used to compare the area of two shapes to see if they match
     */
    @Override
    public int compareTo(Shape s){

        Double a1= this.getArea();
        Double a2 = s.getArea();
        return a1.compareTo(a2);

    }

}