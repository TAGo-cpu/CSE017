/**
 * this is a class that is for the map of the cities which uses the coordinate.java
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/2
 */

public class Map{

    private String[][] map;

    //time complexity O(1)
    /**
     * this is a default constructor to make a 10x10 map
     */
    public Map(){
        map = new String[10][10];
        
    }

    //time complexity O(1)
    /**
     * this is a constructor that takes in parameters to create a map 
     * @param rows this is an integer for the number of rows of the map
     * @param cols this is an integer for the number of cols of the map
     */
    public Map(int rows, int cols){
        map = new String[rows][cols];
    }

    //time complexity O(n^2)
    /**
     * this is a constructor that takes in a map to create a map 
     * @param initMap this is the 2d string array that is copied to make a map 
     */
    public Map(String[][] initMap){
        this.map = new String[initMap.length][initMap[0].length];
        for(int r = 0; r < initMap.length; r++){
            for(int c = 0; c < initMap[r].length; c++){
                this.map[r][c] = initMap[r][c];
            }
        }

    }

    //time complexity O(1)
    /**
     * this method gets the number of rows of the map
     * @return returns an integer
     */
    public int getRows(){
        return map.length;
    }

    //time complexity O(1)
    /**
     * this method gets the number of columns of the map
     * @return returns an integer 
     */
    public int getColumns(){
        return map[0].length;
    }

    //time complexity O(1)
    /**
     * this is a method used to get a specific element from the map 
     * @param row this is an integer for the row number of the map
     * @param col this is an integer for the column number of the map
     * @return this returns a string for the name of the place in the map with the specific coordinates
     * @throws ArrayIndexOutOfBoundsException this methdo will throw this exception when the row number or column number is out of range
     */
    public String getElement(int row, int col) throws ArrayIndexOutOfBoundsException{
        if((row >= map.length) || (row < 0)){
            throw new ArrayIndexOutOfBoundsException("Invalid index for the row " + row + ", length = " + map.length);
        }else if ((col >= map[row].length) || (col < 0)){
            throw new ArrayIndexOutOfBoundsException("Invalid index for the column " + col + ", length = " + map.length);
        }
        else{
            return map[row][col];
        }
    }


    //time complexity O(n^2)
    /**
     * this method is used to find a specific city in the map
     * @param city this is a stirng for the city that is trying to be found
     * @return this returns a coordinate for the city in the array if found and if not returns null
     */
    public Coordinate findElement(String city){
        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[r].length; c++){
                if(city.equals(map[r][c])){
                    return new Coordinate(r,c);
                }
                }
            }
            return null;
        }

    //time complexity O(n^2)
    /**
     * this is a method that is used to output a string for a path from one place to another
     * @param element1 this is a string for the starting place in the map
     * @param element2 this is a string for the ending place in the map
     * @return this returns a string for the path to get from element1 to element2
     */
    public String findPath(String element1, String element2){
        Coordinate start = findElement(element1);
        Coordinate end = findElement(element2);
        return findPath(start, end);

    }

    //time complexity O(n)
    /**
     * this is the helper method of findPath that goes right and down in the array to try and find a path to the end destination
     * @param start this is a coordinate that is the starting point
     * @param end this is a coordinate that is the ending point
     * @return this will return a string that is the path from start to end and returns an empty string if there is no valid path 
     */
    private String findPath(Coordinate start, Coordinate end){
        String path = " - " +  map[start.getX()][start.getY()];
        if(start.getY() < end.getY()){
            start.setY(start.getY() + 1);
             Coordinate right = findElement(map[start.getX()][start.getY()]);
             return path + findPath(right, end);
        } if(start.getX() < end.getX()){
           start.setX(start.getX() + 1);
              Coordinate down = findElement(map[start.getX()][start.getY()]);
              return path + findPath(down, end);
            } 
        if(map[start.getX()][start.getY()].equals(map[end.getX()][end.getY()])){
            return " - " + map[end.getX()][end.getY()] ;
         }
         return "";
         }


    //time complexity, n^2+n^2+2^n -> O(2^n)
    /**
     * this is a method used to find the total possible paths from two points
     * @param element1 this is a string for the name of the starting point
     * @param element2 this is a string for the name of the ending point
     * @return this will return an integer for the number of possible paths 
     */
    public int countPaths(String element1, String element2) {
        Coordinate start = findElement(element1);
        Coordinate end = findElement(element2);
        return countPaths(start, end);
        }
            
    //time complexity O(2^n)
    /**
     * this is the helper method to countPaths that counts the total number of paths from start to end
     * @param start this is the coordinate that is the starting coordinate
     * @param end this is the end coordinate which is the destination
     * @return this retuns an integer for the number of possible paths 
     */
    private int countPaths(Coordinate start, Coordinate end) {    
            int paths = 0;
            if (start.getY() < end.getY()) {
                Coordinate right = new Coordinate(start.getX(), start.getY() + 1);
             paths = paths + countPaths(right, end);
              }
            
             if (start.getX() < end.getX()) {
                Coordinate down = new Coordinate(start.getX() + 1, start.getY());
                paths = paths + countPaths(down, end);
             }
             if (map[start.getX()][start.getY()].equals(map[end.getX()][end.getY()])) {
             return 1;
            }
            
              return paths;
            }

    //time complexity O(n^2)
    /**
     * this is a method used to return a formatted string for the cities in the map 
     */
    public String toString(){
        String cities = "";
        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[r].length; c++){
                cities = cities +  String.format("%-20s\t", map[r][c]);    
            }
            cities = cities + "\n";
           
           }   

        return cities;     
                                    
        }


            }
        
    



