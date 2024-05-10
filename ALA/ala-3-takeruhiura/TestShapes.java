
/**
 * this class used to test each shape class
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/9
 */
public class TestShapes{
    public static void main(String[] args){
        Shape[] shapes = new Shape[8];
        shapes[0] = new Circle("Black", 2.5);
        shapes[1] = new Triangle("Green ", 6.0,6.0,6.0);
        shapes[2] = new Rectangle("Red", 5.0, 3.0);
        shapes[3] = new Pentagon("Yellow", 7.0);
        shapes[4] = (Shape) (shapes[0].clone());
        shapes[5] = (Shape) (shapes[1].clone());
        shapes[6] = (Shape) (shapes[2].clone());
        shapes[7] = (Shape) (shapes[3].clone());
        shapes[4].scale(2.0);
        shapes[5].setColor("Orange");
        ((Rectangle)shapes[6]).setLength(10.0);
        ((Pentagon)shapes[7]).setSide(4.0);
        System.out.println("Before sorting");
        printArray(shapes);
        java.util.Arrays.sort(shapes);
        System.out.println("\nAfter sorting");
        printArray(shapes);
        System.out.printf("\nAverage Perimeter: %.2f\n", getAveragePerimeter(shapes));


    }



    /**
     * this method prints out the array of shapes
     * @param list this is the array of shapes that is printed
     */
    public static void printArray(Shape[] list){
        System.out.println(String.format("%-10s\t%-10s\t%-40s\t%-10s\t%-10s", "Shape", "Color", "Dimenions", "Area","Perimeter"));

        for(Shape s: list){
            System.out.println(s);
        }
    }

    /**
     * this is a method used to get the average perimeter of the shapes
     * @param list this is the list of shapes used to calculate the average
     * @return returns a double
     */
    public static double getAveragePerimeter(Shape[] list){
        double p = 0;
        for(Shape s: list){
            p += s.getPerimeter();

        }

        return p / list.length;
    }
}