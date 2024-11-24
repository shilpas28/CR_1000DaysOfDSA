//GFG
//Kadane's Algorithm - Optimal Approach
//Time complexity: O(N)
//Space complexity: O(1) 

public class KadanesAlgorithm_3 {

    public static void main(String[] args) {
        int arr[] = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println(maxSubarraySum(arr));
    }

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    static int maxSubarraySum(int[] arr) {

        // Your code here
        long maxi = Long.MIN_VALUE; // maximum sum
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {

            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
            }
            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        // To consider the sum of the empty subarray
        // uncomment the following check:
        // if (maxi < 0) maxi = 0;
        return (int) maxi;
    }
}
