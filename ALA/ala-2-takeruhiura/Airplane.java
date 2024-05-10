/**
 * this is the class for the airplane which is used to construct the seat map to show the user 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/3
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Airplane{
    private char[][] seatMap;

    /**
     * this is the default constructor of the airplane that will have all free seats
     */
    public Airplane(){
        seatMap = new char[9][8];
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 8; j++){
                seatMap[i][j] = '.';
            }
        }
    }

    /**
     * this is a constructor for the airplane that will have a seat map from a file
     * @param filename this is a string which is for the file name that will be used to open a file
     */
    public Airplane(String filename){
        seatMap = new char[9][8];
        readMap(filename);
    }


    /**
     * this is the method used to read a map of a plane from a file
     * @param filename this is a string from a filename of the file the map is read from 
     */
    public void readMap(String filename){
        try{
        //step 1
        File file = new File(filename); //creating a file object
        Scanner readFile = new Scanner(file); //opening the file for reading

        //Step 2: reading from the file
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 8; j++){
                seatMap[i][j] = readFile.next().charAt(0); //reading one char from the file 
            }
        }

        //Step 3: Close the file
        readFile.close();


    }
    catch(FileNotFoundException e){
         for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 8; j++){
                seatMap[i][j] = '.';
            }
        }
    }


    }

    /**
     * this is a method used to check if a seat number the user entered has a valid input 
     * @param seatNumber this is a string that is checked with this method to see if it is a valid seat number
     * @return this methods returns a boolean 
     * @throws InvalidSeatException this will throw an exception if the seatNumber is not valid 
     */
    private boolean checkSeatNumber (String seatNumber) throws InvalidSeatException{ 
            if(!seatNumber.matches("[1-9][A-H]")){
                throw new InvalidSeatException("Invalid Seat Number. Must be [1-9][A-H]");

            }
            return true;
        
    }

    /**
     * this method is used to reserve seats on a plane 
     * @param seatNumber this is a string that is the seat number that wants to be reserved
     * @return this returns a boolean 
     * @throws InvalidSeatException an exception is thrown when the seat number is not valid
     */
    public boolean reserveSeat(String seatNumber) throws InvalidSeatException{ 
        if(checkSeatNumber(seatNumber)){
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if(seatMap[row][col] == '.'){ 
                seatMap[row][col] = 'X';
                return true;
            }
            else{ 
                return false; 
            }


        }
        return false;
    }   


    /**
     * this is a method used to free a seat on the plane
     * @param seatNumber this is a string that is the seat number that wants to be freed
     * @return this will return a boolean 
     * @throws InvalidSeatException this will throw an exception when the seat number is invalid 
     */
    public boolean freeSeat(String seatNumber) throws InvalidSeatException{ 
        if(checkSeatNumber(seatNumber)){
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if(seatMap[row][col] == 'X'){ //reserved seat
                seatMap[row][col] = '.';
                return true;
            }
            else{ //not seat
                return false; 
            }


        }
        return false;
    }   

    /**
     * this is a method used to save a map in a file 
     * @param filename this is the string for the filename of the file that the map will be saved to 
     */
    public void saveMap(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i = 0; i< seatMap.length; i++){
                for(int j = 0; j<seatMap[i].length; j++){
                    writeFile.print(seatMap[i][j] + " ");
                }
                writeFile.println();
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write to " + filename);
        }
    }


    /**
     * this is a method of an overriden toString which will display the seat map 
     */
    @Override
    public String toString(){
        String out = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for(int i = 0; i < seatMap.length; i++){
            out += (i + 1) + "\t";
            for(int j = 0; j < seatMap[i].length; j++){
                out += seatMap[i][j] + "\t";

            }
            out += "\n";
        }
        return out;
    }


}