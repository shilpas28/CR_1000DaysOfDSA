//GFG
//Maximize the minimum difference between k elements
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class MaximizeTheMinimumDifferenceBetweenKElements {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 9, 0, 2, 13, 3 };
        int k = 4;
        System.out.println(maxMinDiff(arr, k));
    }

    public static int maxMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr); // Step 1: Sort array

        int low = 0;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;
        // Binary search on the answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                ans = mid; // Mid is possible, try for a bigger one
                low = mid + 1;
            } else {
                high = mid - 1; // Mid is not possible, try smaller
            }
        }
        return ans;
    }

    // Helper method to check if we can select k elements with min diff >= mid
    static boolean isPossible(int[] arr, int k, int minDiff) {
        int count = 1;
        int lastPicked = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPicked >= minDiff) {
                count++;
                lastPicked = arr[i];
                if (count == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
