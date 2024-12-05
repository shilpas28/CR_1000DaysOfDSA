//GFG
//Sort 0s, 1s and 2s - Optimal Approach
//Time complexity: O(N), where N = size of the given array. We are using a single loop that can run at most N times.
//Space complexity: O(1) as we are not using any extra space.

import java.util.Arrays;

public class Sort0s1sAnd2s_3 {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 0, 1, 2 };
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Function to sort an array of 0s, 1s, and 2s
    public static void sort012(int[] arr) {
        // code here
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1; // 3 pointers

        while (mid <= high) {
            if (arr[mid] == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;

            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }
}
