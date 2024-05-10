/**
 * this class extends from the shape class to act as a triangle object
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/9
 */
public class Triangle extends Shape{
    private double side1, side2, side3;

    /**
     * this is a constructor for a triangle with default values
     */
    public Triangle(){
        super();
        side1 = side2 = side3 = 1.0;
    }

    /**
     * this is a constructor to create a triangle object with parameters
     * @param c this is the color of the triangle as a string
     * @param s1 this is the first side of the triangle as a double 
     * @param s2 this is the second side of the triangle as a double
     * @param s3 this is the third side of the triangle as a double
     */
    public Triangle(String c, double s1, double s2, double s3){

        super(c);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    /**
     * this is a method to return the first side of a triangle
     * @return returns a double
     */
    public double getSide1() { return side1;}

    /**
     * this is a method to return the second side of a triangle
     * @return returns a double
     */
    public double getSide2() { return side2;}

    /**
     * this is a method to return the third side of a triangle
     * @return returns a double
     */
    public double getSide3() { return side3;}

    /**
     * this is a method used to set the first side of a triangle
     * @param s this is a double
     */
    public void setSide1(double s){side1 = s;}

    /**
     * this is a method used to set the second side of a triangle
     * @param s this is a double
     */
    public void setSide2(double s){side2= s;}

    /**
     * this is a method used to set the third side of a triangle
     * @param s this is a double
     */
    public void setSide3(double s){side3 = s;}



    /**
     * this is a overridden method used to format a string for the info of a triangle 
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%-10s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f", "Triangle", getColor(), side1, side2, side3, getArea(), getPerimeter());
    }

    /**
     * this is a method used to calculate and return the area of a triangle as a double
     */
    public double getArea(){
        double p = getPerimeter()/2;
        return Math.sqrt(p * (p-side1)* (p-side2) * (p-side3));
    }

    /**
     * this is a method used to calculate and return the perimeter of a triangle as a double
     */
    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    /**
     * this is an overridden method used to scale the sides of the triangle
     */
    @Override
    public void scale(double f){
        side1 *=f;
        side2 *= f;
        side3 *=f;
    }

    /**
     * this is an overridden method used to create a deep clone of a triangle object
     */
    @Override
    public Object clone(){
        return new Triangle(getColor(), side1, side2, side3);

    }
}

