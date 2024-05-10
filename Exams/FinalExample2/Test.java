import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args){
    ArrayList<Student> students = new ArrayList<>(); 

    File file = new File("students.txt");
    try{
    Scanner readFile = new Scanner(file);
    while(readFile.hasNext()){
        String s = readFile.nextLine();
        String[] tokens = s.split(" "); 
        String name = tokens[0];
        Double grade = Double.parseDouble(tokens[1]);
        Student student = new Student(name, grade);
        students.add(student);
    }
    readFile.close();
    }
    catch(FileNotFoundException e){
        System.out.println("Cannot open file");
    }

    Iterator<Student> arrayListIterator = students.iterator();
    Double total = 0.0;
    students.sort(new ComparatorByName());
    arrayListIterator = students.iterator();
    while (arrayListIterator.hasNext()) {
       System.out.println(arrayListIterator.next().toString());
    }

    arrayListIterator = students.iterator();

    Student max = students.get(0);
    Student currentStudent = students.get(0);
    Student min = students.get(0);
    while (arrayListIterator.hasNext()) {
        currentStudent = arrayListIterator.next();
        total = total + currentStudent.getGrade();
        if(currentStudent.getGrade() > max.getGrade()){
            max = currentStudent;

        }
     }

     System.out.println("Max grade: " + max.toString());

     arrayListIterator = students.iterator();
     while (arrayListIterator.hasNext()) {
        currentStudent = arrayListIterator.next();
        if(currentStudent.getGrade() < min.getGrade()){
            min = currentStudent;
        }
     }
     System.out.println("Min grade: " + min.toString());

     System.out.printf("Average: %.2f%n", total / (double) students.size());

     //way one
     arrayListIterator = students.iterator();
     ArrayList<Student> passing = new ArrayList<>(); 
     ArrayList<Student> failing = new ArrayList<>(); 

     while (arrayListIterator.hasNext()) {
        currentStudent = arrayListIterator.next();
        if(currentStudent.getGrade() >= 60.0){
            passing.add(currentStudent);
        }else{
            failing.add(currentStudent);
        }
     }

     Iterator passIterator = passing.iterator();
     Iterator failIterator = failing.iterator();
     System.out.println();
     System.out.println("Passers:");
     while (passIterator.hasNext()) {
        System.out.println(passIterator.next().toString());
     }
     System.out.println();
     System.out.println("Failures:");
     while (failIterator.hasNext()) {
        System.out.println(failIterator.next().toString());
     }



     System.out.println("Solution B");
     arrayListIterator = students.iterator();
     ArrayList<Student> failing2 = new ArrayList<>(); 
     while (arrayListIterator.hasNext()) {
        currentStudent = arrayListIterator.next();
        if(currentStudent.getGrade() < 60.0){
            failing2.add(currentStudent);
        }
        }
    
        Iterator<Student> failIterator2 = failing2.iterator();
        while (failIterator2.hasNext()) {
            currentStudent = failIterator2.next();
            System.out.println(currentStudent.toString());
            students.remove(currentStudent);
         }

    System.out.println();
    System.out.println("LinkedList Versions!!");
     }


    }

    



