//GFG
//Sort 0s, 1s and 2s - Brute Force Approach
//Time complexity: O(N*logN)
//Space complexity: O(1)

import java.util.Arrays;

public class Sort0s1sAnd2s {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 0, 1, 2 };
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Function to sort an array of 0s, 1s, and 2s
    public static void sort012(int[] arr) {
        // code here
        Arrays.sort(arr);
    }
}
