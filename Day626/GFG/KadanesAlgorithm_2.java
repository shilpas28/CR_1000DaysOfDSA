//GFG
//Kadane's Algorithm - Better Method - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class KadanesAlgorithm_2 {

    public static void main(String[] args) {
        int arr[] = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println(maxSubarraySum(arr));
    }

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    static int maxSubarraySum(int[] arr) {

        // Your code here
        long maxi = Integer.MIN_VALUE; // maximum sum
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i.....j]
                // add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];
                maxi = Math.max(maxi, sum); // getting the maximum
            }
        }
        return (int) maxi;
    }
}
