import java.util.Comparator;
public class Test{
    public static void main(String[] args){
        List<Integer> alist = new ArrayList<>();
        List<Integer> llist = new LinkedList<>();
        //Populating alist
        alist.add(57);
        alist.add(25);
        alist.add(27);
        alist.add(0, 6);
        alist.add(39);
        alist.add(3, 11);
        alist.add(57);
        alist.add(33);
        // populating llist
        llist.add(200);
        ((LinkedList<Integer>)llist).addFirst(157);
        ((LinkedList<Integer>)llist).addLast(182);
        llist.add(0, 194);
        llist.add(100);
        llist.add(5, 100);
        llist.add(2, 115);
        // Testing the ArrayList
        System.out.println("\nTesting the ArrayList");
        System.out.println("Test case 1: The add methods in the ArrayList");
        System.out.println(alist);
        System.out.println("\nTest case 2: The equals method in the ArrayList");
        System.out.println(alist + " == " + llist + " ? " + alist.equals(llist));
        System.out.println(alist + " == " + alist + " ? " + alist.equals(alist));

        System.out.println("\nTest case 3: The indexOf methods in the ArrayList");
        System.out.println("Index of 57 = " + alist.indexOf(57));
        System.out.println("Index of 100 = " + alist.indexOf(100));

        System.out.println("Last index of 57 = " + alist.lastIndexOf(57));
        System.out.println("Last index of 25 = " + alist.lastIndexOf(25));

        System.out.println("\nTest case 4: The sort method in the ArrayList");
        Comparator<Integer> c = Comparator.comparing(Integer::intValue);
        alist.sort(c);
        System.out.println(alist);

        System.out.println("\nTest case 5: The toArray method in the ArrayList");
        Object[] array = alist.toArray();
        if(array != null){
            System.out.print("[");
            for(Object o: array){
                System.out.print(o + " ");
            }
            System.out.println("]");
        }
        System.out.println("\nTest case 6: The addAll method in the ArrayList");
        alist.addAll(llist);
        System.out.println(alist);


        // Testing the LinkedList
        System.out.println("\nTesting the LinkedList");
        System.out.println("Test case 7: The add methods in the LinkedList");
        System.out.println(llist);
        System.out.println("\nTest case 8: The equals method in the LinkedList");
        System.out.println(llist + " == " + alist + " ? " + llist.equals(alist));
        System.out.println(llist + " == " + llist + " ? " + llist.equals(llist));

        System.out.println("\nTest case 9: The indexOf methods in the LinkedList");
        System.out.println("Index of 300 = " + llist.indexOf(300));
        System.out.println("Index of 100 = " + llist.indexOf(100));

        System.out.println("Last index of 115 = " + llist.lastIndexOf(115));
        System.out.println("Last index of 100 = " + llist.lastIndexOf(100));

        System.out.println("\nTest case 10: The sort method in the LinkedList");
        llist.sort(c);
        System.out.println(llist);

        System.out.println("\nTest case 11: The toArray method in the LinkedList");
        array = llist.toArray();
        if(array != null){
            System.out.print("[");
            for(Object o: array){
                System.out.print(o + " ");
            }
            System.out.println("]");
        }

        System.out.println("\nTest case 12: The get/set methods in the LinkedList");
        System.out.println("Element at index 3 = " + llist.get(3));
        System.out.println("Element at index 0 old value = " + llist.set(0, 150) + ", new value = 150");
        System.out.println(llist);
        System.out.println("\nTest case 13: The remove methods in the LinkedList");
        ((LinkedList<Integer>)llist).removeFirst();
        System.out.println(llist);
        ((LinkedList<Integer>)llist).removeLast();
        System.out.println(llist);
        Integer v = 115;
        llist.remove(v);
        System.out.println(llist);
        llist.remove(2);
        System.out.println(llist);
        System.out.println("\nTest case 14: The addAll method in the LinkedList");
        llist.addAll(alist);
        System.out.println(llist);
        
        llist.reverse();
        System.out.println(llist);
    }
}