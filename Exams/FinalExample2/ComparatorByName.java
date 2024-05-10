/**
 * this is a class for the comparator by name
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/11
 */
import java.util.Comparator;
public class ComparatorByName implements Comparator<Student>{

    /**
     * this is a method that returns an integer depending on the comparison of two student names
     */
    public int compare(Student s1, Student s2){
        String name1 = s1.getName();
        String name2 = s2.getName();
        return name1.compareTo(name2);
    };

}