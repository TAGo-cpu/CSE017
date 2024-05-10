/**
 * this is a class for the comparator to compare by GPA
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/11
 */
import java.util.Comparator;
public class ComparatorByGPA implements Comparator<Student>{

    /**
     * this is a method that returns an integer depending on the comparison of the GPA of two students
     */
    public int compare(Student s1, Student s2){
        Double gpa1 = s1.getGPA();
        Double gpa2 = s2.getGPA();
        return gpa1.compareTo(gpa2);
    };

}