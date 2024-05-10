/**
 * this is a class that creates the objects for each location of the city
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-3/12
 */

 public class GeoLocation implements Comparable<GeoLocation>{ 
    private String city, state;
    private double latitude, longitude;


    /**
     * this is a default constructor for a location that has default values for each variable
     */
    public GeoLocation(){
        this.city= "";
        this.state="";
        this.latitude=0;
        this.longitude=0;
    }

    /**
     * this is a constructor for a geolocation object with parameters for each variable
     * @param city this is a string for the city of the location 
     * @param state this is a string for the state of the location
     * @param latitude this is a double for the latitude of the location
     * @param longitude this is a double for the longitude of the location 
     */
    public GeoLocation(String city, String state, double latitude, double longitude){
        this.city=city;
        this.state=state;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    /**
     * this method is used to return the city of the location
     * @return the city is returned as a string
     */
    public String getCity(){
        return city;

    }

    /**
     * this method is used to return the state of the location
     * @return the state is returned as a string 
     */
    public String getState(){
        return state;
    }

    /**
     * this method is used to return the latitude of the location
     * @return the latitude is returned as a double
     */
    public double getLatitude(){
        return latitude;

    }
    
    /**
     * this method is used to return the longitude of the location
     * @return the longitude is returned as a double
     */
    public double getLongitude(){
        return longitude;

    }

    /**
     * this method is used to set the city of a location
     * @param city this is a string for the parameter
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * this method is used to set the state of a location
     * @param state the parameter is a string 
     */
    public void setState(String state){
        this.state= state;
    }

    /**
     * the method is used to set the latitude of a location
     * @param latitude this is a double
     */
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    /**
     * this method is used to set the longitude of the location
     * @param longitude this is a double 
     */
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }


    /**
     * this is a method used to compare two geolocations based on the name of the city
     */
    public int compareTo(GeoLocation g2){
       return this.getCity().compareTo(g2.getCity());

    }

    /**
     * this is a method used to return a formatted string for a geolocation 
     */
    public String toString() {
        return String.format("%-25s%-7s%-15.5f%-15.5f", city, state, latitude, longitude);
    }
}
    
