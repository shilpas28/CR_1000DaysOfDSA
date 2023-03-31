//GFG - using Iteration
//Even Swap- using Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class EvenSwap_2 {

    public static void main(String[] args) {
        int N = 3;
        int a[] = { 1, 3, 5 };
        System.out.println(Arrays.toString(lexicographicallyLargest(a, N)));
    }

    static int[] lexicographicallyLargest(int[] arr, int n) {
        // Write your code here
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1] && (arr[i] + arr[i + 1]) % 2 == 0) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return arr;
    }
}
