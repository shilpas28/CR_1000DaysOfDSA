//GFG - using Recursion
//Even Swap- using Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class EvenSwap_1 {

    public static void main(String[] args) {
        int N = 3;
        int a[] = { 1, 3, 5 };
        System.out.println(Arrays.toString(lexicographicallyLargest(a, N)));
    }

    static int[] lexicographicallyLargest(int[] arr, int n) {
        // Write your code here
        boolean swap = false;
        for (int i = 0; i < n - 1; i++) {
            if ((arr[i] + arr[i + 1]) % 2 == 0 && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                swap = true;
            }
        }
        if (!swap)
            return arr;
        return lexicographicallyLargest(arr, n);
    }
}
