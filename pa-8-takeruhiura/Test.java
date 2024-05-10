/**
 * this is a class used to test the sorting algorithm on students 
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/11
 */

import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> studentAL = new ArrayList<>();
        LinkedList<Student> studentLL = new LinkedList<>();

        File file = new File("students.txt");
        //this is the try and catch block to put the file data of students into both lists
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String s = readFile.nextLine();
                String[] studentData = s.split(",");
                int id = Integer.parseInt(studentData[0]);
                String name = studentData[1];
                double gpa = Double.parseDouble(studentData[2]);
                Student student = new Student(id, name, gpa);
                studentAL.add(student);
                studentLL.add(student);
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
        }

    //printing out the sorted students by ID in the arrayList
    System.out.println("ArrayList sorted by ID");
    studentAL.sort(null);
    Iterator<Student> arrayListIterator = studentAL.iterator();
    while (arrayListIterator.hasNext()) {
        System.out.println(arrayListIterator.next().toString());
     }
    int arrayListIdIters = ArrayList.sortIterations;
    System.out.println();

    //printing out the sorted students by ID in the linkedList
    System.out.println("LinkedList sorted by ID");
    studentLL.sort(null);
    Iterator<Student> linkedListIterator = studentLL.iterator();
    while (linkedListIterator.hasNext()) {
        System.out.println(linkedListIterator.next().toString());
     }
    int linkedListIdIters = LinkedList.sortIterations;
    System.out.println();

    //printing out the sorted students by name in the arrayList
    arrayListIterator = studentAL.iterator();
    System.out.println("ArrayList sorted by name");
    studentAL.sort(new ComparatorByName());
    while (arrayListIterator.hasNext()) {
       System.out.println(arrayListIterator.next().toString());
    }
    int arrayListNameIters = ArrayList.sortIterations;
    System.out.println();

    //printing out the sorted students by name in the linkedList
    System.out.println("LinkedList sorted by name");
    studentLL.sort(new ComparatorByName());
    linkedListIterator = studentLL.iterator();
    while (linkedListIterator.hasNext()) {
       System.out.println(linkedListIterator.next().toString());
    }
    int linkedListNameIters = LinkedList.sortIterations;
    System.out.println();

    //printing out the sorted students by GPA in the arrayList
    arrayListIterator = studentAL.iterator();
    System.out.println("ArrayList sorted by GPA");
    studentAL.sort(new ComparatorByGPA());
    while (arrayListIterator.hasNext()) {
        System.out.println(arrayListIterator.next().toString());
     }
    int arrayListGPAIters = ArrayList.sortIterations;
    System.out.println();

    //printing out the sorted students by GPA in the linkedList
    System.out.println("LinkedList sorted by GPA");
    studentLL.sort(new ComparatorByGPA());
    linkedListIterator = studentLL.iterator();
    while (linkedListIterator.hasNext()) {
       System.out.println(linkedListIterator.next().toString());
    }
    int linkedListGPAIters = LinkedList.sortIterations;
    System.out.println();

    //printing out the number of iterations from each sorting method for both lists
    System.out.println("Performance of the sort method (# iterations)");
    System.out.println(String.format("%-16s%-16s%-16s%-15s", "List", "by ID", "by Name", "by GPA"));
    System.out.println(String.format("%-16s%-16s%-16s%-15s", "ArrayList", arrayListIdIters, arrayListNameIters, arrayListGPAIters));
    System.out.println(String.format("%-16s%-16s%-16s%-15s", "LinkedList", linkedListIdIters, linkedListNameIters, linkedListGPAIters));

    MinHeap<Student> heap = new MinHeap<>();

    for(int i = 0; i < 20; i++){
        heap.add(studentAL.get(i));
    }  
    heap.print();
    }
    

//DISCUSSION:
//Overall, the time complexity for the sorting method in LinkedList and ArrayList 
//were O(nlog(n)). This is due to the while loop in the sort method and the add
//method inside the while loop which has a time complexity O(log(n)). Because
//the add method is called n times in two while loops the time complexity is 
//O(2nlog(n)) but the constant is ignored so the time complexity is O(nlog(n)).
//The number of iterations from the sort method in both lists ranges from 915-922.
//Both arraylist and linkedlist had the same number of iterations for each sort
//because both lists used the same sort method and had the same time complexity.
//Because the number of students is 100 and log base 2 of 100 is approximately 7,
//the number of iterations should be close to 700. If the time complexity was O(2nlog(n)),
//the time complexity should be around 1400 but that number is never reached so 
//it is supported from the performance that the time complexity should be O(nlog(n)).

}