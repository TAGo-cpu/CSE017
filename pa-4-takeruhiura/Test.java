/**
 * this is the test class used to test the methods created in the coordinate and test class
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/2
 */

public class Test{
    public static void main(String[] args){
        String[][] cities = 
        { 
            {"Tamaqua", "Lehighton", "Danielsville", "Liberty", "Hope"},
            {"Kempton", "NorthHampton", "Nazareth", "Lopatcong", "Washington"},
            {"Hamburg", "Allentown", "Bethlehem", "Easton", "Stewartsville"},
            {"Bernville", "Emmaus", "Hellertown", "Milford", "Alexandria"},
            {"Reading", "BoyerTown", "Herleysville", "Doylestown", "New Hope"}
        };
        System.out.println("\nTest case 1: Create a new map");
        Map LV = new Map(cities);
        System.out.println("New map created with " + LV.getRows() + " rows and " + LV.getColumns() + " columns");
        System.out.println("\nTest case 2: Print the map");
        System.out.println("Lehigh Valley Map");
        System.out.println(LV.toString());
        System.out.println("\nTest case 3: Find an element in the map (successful)");
        Coordinate c1 = LV.findElement("Bethlehem");
        if(c1 == null){
            System.out.println("Bethlehem not found in Lehigh Valley map");
        }
        else{
            System.out.println("Bethlehem found in Lehigh Valley map at position(" +
                               c1.getX() + ", " + c1.getY() + ")");
        }
        System.out.println("\nTest case 4: Find an element in the map (failed)");
        Coordinate c2 = LV.findElement("Easttown");
        if(c2 == null){
            System.out.println("Easttown not found in Lehigh Valley map");
        }
        else{
            System.out.println("Easttown found in Lehigh Valley map at position(" + 
                                c2.getX() + ", " + c2.getY() + ")");
        }
        System.out.println("\nTest case 5: Find an element at a position (successful)");
        try{
            String city = LV.getElement(0, 2);
            System.out.println(city + " is at the position(0,2) in the map");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nTest case 6: Find an element at a position (row out of bounds)");
        try{
            String city = LV.getElement(8, 2);
            System.out.println(city + " is at the position(8,2) in the map");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nTest case 7: Find an element at a position (col out of bounds)");
        try{
            String city = LV.getElement(1, -2);
            System.out.println(city + " is at the position(1,-2) in the map");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nTest case 8: Find a path (successful)");
        String path = LV.findPath("NorthHampton", "Alexandria");
        if(path.length() == 0)
        {
            System.out.println("No Path found from NorthHampton to Alexandria");
        }
        else{
            System.out.println("Path found: " + path);
        }
        System.out.println("\nTest case 9: Find a path (failed)");
        path = LV.findPath("New Hope", "Allentown");
        if(path.length() == 0)
        {
            System.out.println("No Path found from NewHope to Allentown");
        }
        else{
            System.out.println("Path found: " + path);
        }
        System.out.println("\nTest case 10: Find the number of paths (successful)");
        int paths = LV.countPaths("Tamaqua", "Washington");
        if(paths == 0){
            System.out.println("There are no paths from Tamaqua to Washingtone");
        }
        else{
            System.out.println("There are " + paths + " possible paths from Tamaqua to Washington");
        }
        System.out.println("\nTest case 11: Find the number of paths (successful)");
        paths = LV.countPaths("Tamaqua", "New Hope");
        if(paths == 0){
            System.out.println("There are no paths from Bernville to Hope");
        }
        else{
            System.out.println("There are " + paths + " possible paths from Tamaqua to New Hope");
        }
        System.out.println("\nTest case 12: Find the number of paths (failed)");
        paths = LV.countPaths("Alexandria", "Kempton");
        if(paths == 0){
            System.out.println("There are no paths from Alexandria to Kempton");
        }
        else{
            System.out.println("There are " + paths + " possible paths from Alexandria to Kempton");
        }
    }
}