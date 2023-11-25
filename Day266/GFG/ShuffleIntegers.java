//GFG
//Shuffle integers
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class ShuffleIntegers {

    public static void main(String[] args) {
        int n = 4;
        long[] arr = { 1, 2, 9, 15 };
        shuffleArray(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void shuffleArray(long arr[], int n) {
        // Your code goes here
        int k = n / 2 - 1;
        for (int i = n - 1; i >= n / 2; i--) {
            arr[i] = arr[i] <<= 10;
            arr[i] = arr[i] |= arr[k];
            k--;
        }
        k = 0;
        for (int i = n / 2; i < n; i++) {
            arr[k++] = arr[i] & 1023;
            arr[k++] = arr[i] >> 10;
        }
    }
}
