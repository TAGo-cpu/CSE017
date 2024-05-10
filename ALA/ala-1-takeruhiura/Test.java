/**
 * the purpose of this code is to implement inheritance with multiple objects and then print out the info of each object and sort by name and id
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-1/25
 */

 public class Test {

    public static void main(String[]args){

    Person[] people = new Person[3];
    people[0] = new Student(123456789, "Paul Leister" ,"972 4th Street, Allentown","610-331-7177", "pleister@gmail.com", "CSE");
    people[1] = new Employee(334422110, "Beth Down","234 Main Street, Philadelphia", "484-222-4433", "bdown@gmail.com", "System Administrator", 75000.00);
    people[2] = new Faculty(222222222, "Mark Jones", "21 Orchid Street, Bethlehem", "610-333-2211", "mjones@gmail.com", "Faculty",100000.00, "Associate Professor");
    
    System.out.println("Original List:");
    printArray(people);


    System.out.println();
    System.out.println("List sorted by name:");
    sortArray(people, true);
    printArray(people);

    System.out.println();
    System.out.println("List sorted by id:");
    sortArray(people, false);
    printArray(people);

    }

    /**
     * method that prints each array in the list of people
     * @param list this is the array with all the people that are going to be printed 
     */
    public static void printArray(Person[]list){

        for(int i = 0; i < list.length; i++){
            System.out.println(list[i].toString());
        }
    }


    /**
     * method used to sort arrays in ascending order by name and id
     * @param list this is the Person array that is sorted using this method
     * @param type the type is a boolean, if the boolean is true then the array is sorted by name and if false it is sorted by ID 
     */
    public static void sortArray(Person[] list, boolean type){
        for(int i = 0; i < list.length; i++){
            int minIndex = i;
            for(int j = i+1; j < list.length; j++){
                if (type){
                    if(list[j].getName().compareTo(list[minIndex].getName()) < 0 )
                    minIndex = j;
                }
                else{
                    if(list[j].getID() < list[minIndex].getID())
                    minIndex = j;
                }
            }

            Person temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
}
