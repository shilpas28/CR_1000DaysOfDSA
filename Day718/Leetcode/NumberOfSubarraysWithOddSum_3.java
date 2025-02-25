//Leetcode
//1524. Number of Sub-arrays With Odd Sum - Prefix Sum with Odd-Even Counting
//Time complexity: O(N)
//Space complexity: O(1) 

public class NumberOfSubarraysWithOddSum_3 {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5 };
        System.out.println(numOfSubarrays(arr));
    }

    public static int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int count = 0, prefixSum = 0;
        // evenCount starts as one since the initial sum (0) is even
        int oddCount = 0, evenCount = 1;

        for (int num : arr) {
            prefixSum += num;
            // If current prefix sum is even, add the number of odd subarrays
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                // If current prefix sum is odd, add the number of even
                // subarrays
                count += evenCount;
                oddCount++;
            }
            count %= MOD; // To handle large results
        }
        return count;
    }
}
