

public class Student implements Comparable<Student>{

    private String name;
    private Double grade;


    public Student(){
        name = "";
        grade = 0.0;
    }

    public Student(String n, Double g){
        name = n;
        grade = g;
    }

    public double getGrade(){
        return grade;
    }

    public String getName(){
        return name;

    }

    public int compareTo(Student s){
        if(this.getGrade() > s.getGrade()){
            return 1;
        }
        else if(this.getGrade() < s.getGrade()){
            return -1;
        }
        return 0;
    }

    public String toString(){
        return "Name: " + name + " Grade: " + grade;
    }

}