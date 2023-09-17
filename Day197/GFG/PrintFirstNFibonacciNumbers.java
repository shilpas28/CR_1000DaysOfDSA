//GFG
//Print first n Fibonacci Numbers
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;

public class PrintFirstNFibonacciNumbers {

    public static void main(String[] args) {
        int N = 7;
        System.out.println(Arrays.toString(printFibb(N)));
    }

    // Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) {
        // Your code here
        long arr[] = new long[n];
        arr[0] = 1;
        if (n > 1)
            arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
}
