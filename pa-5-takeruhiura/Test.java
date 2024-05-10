/**
 * this is the test class used to test all the classes with geolocation and comparator
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/12
 */

 import java.util.Comparator;
 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 
 public class Test{
     public static void main(String[] args){
         SortedList<GeoLocation> cities = new SortedList<>();
         readCities(cities, "cities.txt");
         System.out.println("\nTest case 1: Sorted List created");
         System.out.println(cities.size() + " cities read from the file");
         System.out.println(cities.toString());  
 
         System.out.println("\nTest case 2: Find an element (successful)");
         GeoLocation gl = cities.find(new GeoLocation("San Francisco", "", 0.0, 0.0));
         if(gl == null){
             System.out.println("San Francisco not found");
         }
         else{
             System.out.println("San Francisco found:\n" + gl);  
         }
 
         System.out.println("\nTest case 3: Find an element (failed)");
         gl = cities.find(new GeoLocation("Tokyo", "", 0.0, 0.0));
         if(gl == null){
             System.out.println("Tokyo not found");
         }
         else{
             System.out.println("Tokyo found:\n" + gl);  
         }   
 
         System.out.println("\nTest case 4: Sort by state");
         // Define the class ComparatorByState here
         // the class implements the interface Comparator for GeoLocation
         // the method compare order two GeoLocation objects based on the state 
         class ComparatorByState implements Comparator<GeoLocation> {
             /**
              * this is a method used to compare two geolocations based on the state 
              */
             public int compare(GeoLocation gl1, GeoLocation gl2) {
                 return gl1.getState().compareTo(gl2.getState());
             }
         }
         
         // invoke setComparator on cities using an instance of ComparatorByState
         cities.setComparator(new ComparatorByState());
 
         
         System.out.println(cities.toString());
 
         System.out.println("\nTest case 5: Sort by latitude");
         // Define the class ComparatorByLatitude here
         // the class implements the interface Comparator for GeoLocation
         // the method compare order two GeoLocation objects based on the latitude 
         class ComparatorByLatitude implements Comparator<GeoLocation> {
             /**
              * this is a method used to compare two geolocations based on the latitude
              */
             public int compare(GeoLocation gl1, GeoLocation gl2) {
                 Double lat1 = gl1.getLatitude();
                 Double lat2= gl2.getLatitude();
                 return lat1.compareTo(lat2);
             }
         }      
         // invoke setComparator on cities using an instance of ComparatorByLatitude
         cities.setComparator(new ComparatorByLatitude());
 
         System.out.println(cities.toString());
 
         System.out.println("\nTest case 6: Sort by longitude");
         // Define the class ComparatorByLongitude here
         // the class implements the interface Comparator for GeoLocation
         // the method compare order two GeoLocation objects based on the longitude 
         class ComparatorByLongitude implements Comparator<GeoLocation> {
             /**
              * this is a method used to compare two geolocations based on longitude 
              */
             public int compare(GeoLocation gl1, GeoLocation gl2) {
                 Double long1 = gl1.getLongitude();
                 Double long2= gl2.getLongitude();
                 return long1.compareTo(long2);
             }
         }
         // invoke setComparator on cities using an instance of ComparatorByLongitude
         cities.setComparator(new ComparatorByLongitude());
 
         System.out.println(cities.toString());
 
     }
 
     /**
      * this is a method used to read in a file and store it into a sortedlist
      * @param list this is the list the info is stored into
      * @param filename this is the file that is read to extract the data 
      */
     public static void readCities(SortedList<GeoLocation> list, String filename){
         File file = new File(filename);
         try {
             Scanner read = new Scanner(file);
             while (read.hasNextLine()) {
                 String line = read.nextLine();
                 String[] tokens = line.split(",");
                 String city = tokens[0];
                 String state = tokens[1];
                 double latitude = Double.parseDouble(tokens[2]);
                 double longitude = Double.parseDouble(tokens[3]);
                 GeoLocation location = new GeoLocation(city, state, latitude, longitude);
                 list.add(location);
             }
             read.close();
         } catch (FileNotFoundException e) {
             System.out.println("File not found");
         }
     }
 }