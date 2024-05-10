/**
 * this is a class used to test different methods with the same purpose to compare time complexity
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-2/23
 */

public class GCD {

    public static int iter1, iter2, iter3, iter4;


    //time complexity = (n-2) * constant time -> O(n)
    /**
     * this is a method that finds the gcd by dividng both numbers by 1 and up 
     * @param m first integer to compare
     * @param n second integer to compare
     * @return returns the integer for the gcd
     */
    public static int gcd_1(int m, int n){
        iter1 = 0;
        int divisor = 1;
        for(int i=2; i<m && i<n; i++){ // (n-2) iterations
            iter1++;
           if(m%i == 0 && n%i == 0)
             divisor = i;
         }
      return divisor;
    }

    //time complexity = n * constant time -> O(n)
    /**
     * this is a method to find the gcd going from the second integer and down 1 
     * @param m first intger to compare
     * @param n second integer to compare
     * @return returns the integer for gcd
     */
    public static int gcd_2(int m, int n){
    iter2 = 0;
    int divisor = 1;
    for(int i = n; i >= 1; i--){ //n iterations
        iter2++;
        if(m%i == 0 && n%i == 0){
          divisor = i; 
          break;
          }
     }
     return divisor;
    }


    //time complexity = (n/2) * constant time -> O(n)
    /**
     * this is a method to find the gcd that is less than or equal to n/2
     * @param m first integer to compare
     * @param n second integer to compare
     * @return returns the integer for gcd
     */
    public static int gcd_3(int m, int n) {
    iter3 = 0;
    int divisor = 1;
    if(m%n == 0) 
          return n;
    for(int i = n/2; i >= 1; i--){   //(n/2) iterations
        iter3++;
           if(m%i == 0 && n%i == 0){
              divisor=i; 
              break;
        }
    }
    return divisor;
    }
    
    //time complexity = logn * constant time -> O(logn)
    /**
     * this is a method to find the gcd using Eucli'd GCD Recursive algorithm
     * @param m this is the first integer to compare
     * @param n this is the second integer to compare
     * @return returns the intger for gcd
     */
    public static int gcd_4(int m, int n){
        iter4++;
    if(m%n == 0) 
         return n;
    else
         return gcd_4(n, m%n);
    }

    
    /**
     * this is a method that compares the execution times for each method 
     */
    public static void compareExecutionTimes(){
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-5s", "Number1", "Number2", "Time_1", "Time_2", "Time_3", "Time_4\n");
        for(int i = 0; i < 20; i++){
            int number1 = (int)(Math.random() * 1000000);
            int number2 = (int)(Math.random() * 1000000);
            if(number2 > number1){
                int temp = number1;
                number1 = number2;
                number2 = temp;

            }

            long start = System.nanoTime();
            gcd_1(number1,number2);
            long end = System.nanoTime();
            long execTime1 = end - start;

            start = System.nanoTime();
            gcd_2(number1, number2);
            end = System.nanoTime();
            long execTime2 = end - start;


            start = System.nanoTime();
            gcd_3(number1, number2);
            end = System.nanoTime();
            long execTime3 = end - start;

            start = System.nanoTime();
             gcd_4(number1, number2);
             end = System.nanoTime();
             long execTime4 = end - start;

             System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10d\n", 
             number1, number2, execTime1, execTime2, execTime3, execTime4);        }

    }


    /**
     * this is a method used to compare the number of iterations for each method
     */
    public static void compareIterations(){
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s", "Number1", "Number2", "Iterations_1", "Iterations_2", "Iterations_3", "Iterations_4\n");
        for(int i = 0; i < 20; i++){
            int number1 = (int)(Math.random() * 1000000);
            int number2 = (int)(Math.random() * 1000000);
            if(number2 > number1){
                int temp = number1;
                number1 = number2;
                number2 = temp;

            }
            gcd_1(number1,number2);
            gcd_2(number1, number2);
            gcd_3(number1, number2);
            iter4 = 0;
            gcd_4(number1, number2);

            System.out.printf("%-10d %-10d %-12d %-12d %-12d %-10d\n", 
            number1, number2, iter1, iter2, iter3, iter4);
        }

    }

    public static void main(String[] args){
        System.out.println("Comparison of the execution times");
        compareExecutionTimes();
        System.out.println("\nComparison of the number of iterations");
        compareIterations();;
    }

    /**
     * The first three algorithms all have a time complexity of O(n) and the fourth algorithm has time complexity of O(logn)
     * when comparing the execution times of the first three, they all seem to have relatively the same execution times when 
     * comparing multiple results, however, the execution time for the fourth algorithm is significantly shorter than the others.
     * This makes sense because the fourth algorithm has a time complexity logn which is much more efficient than the others so it can go through
     * more iterations in a shorter amount of time. 
     */



}