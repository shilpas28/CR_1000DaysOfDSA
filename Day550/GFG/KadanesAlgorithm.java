//GFG
//Kadane's Algorithm - Brute Force - Not accepted as TLE
//Time complexity: O(N^3)
//Space complexity: O(1) 

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, -2, 5 };
        System.out.println(maxSubarraySum(arr));
    }

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    static long maxSubarraySum(int[] arr) {
        // Your code here
        long maxi = Integer.MIN_VALUE; // maximum sum
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // subarray = arr[i.....j]
                int sum = 0;
                // add all the elements of subarray:
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
}
