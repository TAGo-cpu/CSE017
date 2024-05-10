/**
 * this is a class for the movie object 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/28
 */

public class Movie implements Comparable<Movie>{

    private int id;
    private String title;
    private String genre;
    private int ratings;
    private double rating;

    public Movie(int id, String title, String genre){
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public int getID(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getGenre(){
        return this.genre;
    }

    public int getRatings(){
        return this.ratings;
    }

    public double getRating(){
        return this.rating;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setRatings(int rs){
        this.ratings = rs;
    }

    public void addRating(double r){
        ratings++;
        rating = (rating * (ratings-1) + r)/ratings;

    }

    public String toString(){
        return String.format("%-5d\t%-50s\t%-20d\t%-20.1f", id, title, ratings, rating);
    }

public int compareTo(Movie m) {
    if (this.getRatings() < m.getRatings()) {
        return -1;
    } else if (this.getRatings() > m.getRatings()) {
        return 1;
    } else {
        return 0;
    }
}

}