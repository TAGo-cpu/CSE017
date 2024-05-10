/**
 * this is the test class to test the sort methods learned in class
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/29
 */

import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        final int SIZE = 10000;
        System.out.println("Dataset Size: " + SIZE + "\n");
        System.out.printf("%-20s\t%-10s\t%-10s\t%-10s\n", "Sorting Algorithm", "Random", "Sorted", "Reversed");
        ArrayList<Integer> randomList = new ArrayList<>(SIZE);
        for(int i = 0; i < SIZE; i++){
            randomList.add((int)(Math.random() * SIZE));
        }
        ArrayList<Integer> sortedList = (ArrayList<Integer>)(randomList.clone());
        java.util.Collections.sort(sortedList);

        ArrayList<Integer> reversedList = (ArrayList<Integer>)(sortedList.clone());
        java.util.Collections.reverse(reversedList);

        Sort.selectionSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Selection Sort", Sort.iterations[0]);
        Sort.selectionSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[0]);
        Sort.selectionSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[0]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        Sort.insertionSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Insertion Sort", Sort.iterations[1]);
        Sort.insertionSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[1]);
        Sort.insertionSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[1]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        Sort.bubbleSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Bubble Sort", Sort.iterations[2]);
        Sort.bubbleSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[2]);
        Sort.bubbleSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[2]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        Sort.iterations[3] = 0;
        Sort.mergeSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Merge Sort", Sort.iterations[3]);
        Sort.iterations[3] = 0;
        Sort.mergeSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[3]);
        Sort.iterations[3] = 0;
        Sort.mergeSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[3]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        Sort.quickSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Quick Sort", Sort.iterations[4]);
        Sort.quickSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[4]);
        Sort.quickSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[4]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        Sort.heapSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Heap Sort", Sort.iterations[5]);
        Sort.heapSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[5]);
        Sort.heapSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[5]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        Sort.bucketSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Bucket Sort", Sort.iterations[6]);
        Sort.bucketSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[6]);
        Sort.bucketSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[6]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

        Sort.radixSort(randomList);
        System.out.printf("%-20s\t%-10d\t", "Radix Sort", Sort.iterations[7]);
        Sort.radixSort(sortedList);
        System.out.printf("%-10d\t", Sort.iterations[7]);
        Sort.radixSort(reversedList);
        System.out.printf("%-10d\n", Sort.iterations[7]);

        java.util.Collections.shuffle(randomList);
        java.util.Collections.reverse(reversedList);

    }

/**
 * Selection sort: For selection sort the loop iterates through the list to find the smallest
 * value in the list then goes through the rest of the values and keeps going through to find 
 * the smallest value. This is why the time complexity is O(n^2) and it does not matter the order
 * of the list because it must go through the entire unsorted portion of the list each time
 * to find the smallest value.
 * 
 * Insertion sort: In this method, each item is sorted by comparing it with numbers before itself
 * then it will be inserted based on which values are greater or less than it. This is why for
 * a sorted list it has a time complexity of n because it simply inserts where it already was. 
 * In reversed the time complexity is O(n^2) and worst case because it has to go through the entire unsorted list each
 * time to sort it and random has less iterations than reversed for this reason as it is not as bad
 * compared to a reversed list because the values are placed randomly.
 * 
 * Bubble sort: It has n iterations when it is already sorted because no items need to be sorted.
 * It has a time complexity of (n^2) when it has to go through random and reversed lists. It is 
 * worst case scenario for reversed because it must swap each value for every single value of the list.
 * But for random values, it must go through the entire list each time to check if it is completely sorted 
 * even if it is random which is why it has a similar number of iterations as a reversed list.
 * 
 * Merge sort: It has a time complexity of O(nlog(n)). This is due to how sublist splits the list
 * so it has a structure of a balanced binary tree and merge for each sublist causes it to have
 * n iterations for each level of the tree-like structure which is why the time complexity is O(nlog(n)).
 * Because every list of 1 value must be compared to one another regardless of them being partially sorted or not
 * is why the number of iterations for random, sorted, and reversed is the same. This shows Merge sort is a
 * very stable algorithm.
 * 
 * Quick sort: It has a time complexity of O(nlog(n)) with a worst case of O(n^2). The time complexity is worst
 * when the list is sorted because quick sort requires a pivot which is compared to each value in the list. 
 * Therefore when it is sorted the pivot, set to the first value, is never moved because it is already sorted 
 * so sorted the time complexity is O(n^2). For reversed it is the similar reason however, the pivot is switched
 * with the final value of the list and so on which is why it is still O(n^2) but not as bad as a sorted list. When the list is random
 * it is the most efficient because the pivot will be compared and switched with values throughout the list making it
 * O(nlog(n)).
 * 
 * Heap Sort: It has a time complexity of O(nlog(n)). The number of iterations tends to be worse for a sorted list
 * because it is using a max heap to sort the list, this requires having to go through the list each time to get the 
 * last value and put it as the first value of the heap and so on. Therefore, having a reverse list would tend to have
 * the least number of iterations and random will also have less iterations than a sorted list.
 * 
 * Bucket Sort: It has a time complexity of O(n+t), this is due to the number of elements that is sorted and the number
 * of buckets needed to be created to sort. This method creates t + 1 buckets where t is the largest value in the 
 * list. Then each value from the list is stored into each bucket with the same index and then puts it back into the original
 * list. This is why the number of iterations is the same regardless of the arrangement of the list.
 * 
 * Radix Sort: It has a time complexity of O(d.n). This method sorts each value in the list based off the specific digit
 * for each number and not the actual value which is why the number of iterations for random, sorted, and reversed is the same.
 * 
 * Comparision:
 * Overall, on average merge sort and heap sort seem to be the most efficent regardless of the sorting of the list.
 * Quick sort has similar efficiency as merge sort and heap sort for random data sets but is very inefficient when the list
 * is sorted or reversed. Bucket sort seems to have the least number of iterations but it can be very inefficient for large data sets and radix sort can 
 * be inefficient if large digits are in the list. Selection sort has time complexity O(n^2) in any case making it the least efficient. Insertion sort
 * and bubble sort are also very inefficient compared to the other sorting methods but they are efficient when the list is already sorted.
 * 
 * All in all, data will most likely be random for when it must be sorted using a method. In this case, merge sort, quick sort, and heap sort
 * are the most efficient algorithms for any size of random lists. 
 */
}