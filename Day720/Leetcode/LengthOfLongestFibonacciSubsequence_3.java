//Leetcode
//873. Length of Longest Fibonacci Subsequence - Optimized Dynamic Programming
//Time complexity: O(N^2)
//Space complexity: O(N^2)

public class LengthOfLongestFibonacciSubsequence_3 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // dp[prev][curr] stores length of Fibonacci sequence ending at indexes
        // prev,curr
        int[][] dp = new int[n][n];
        int maxLen = 0;
        // Find all possible pairs that sum to arr[curr]
        for (int curr = 2; curr < n; curr++) {
            // Use two pointers to find pairs that sum to arr[curr]
            int start = 0;
            int end = curr - 1;

            while (start < end) {
                int pairSum = arr[start] + arr[end];

                if (pairSum > arr[curr]) {
                    end--;
                } else if (pairSum < arr[curr]) {
                    start++;
                } else {
                    // Found a valid pair, update dp
                    dp[end][curr] = dp[start][end] + 1;
                    maxLen = Math.max(dp[end][curr], maxLen);
                    end--;
                    start++;
                }
            }
        }
        // Add 2 to include first two numbers, or return 0 if no sequence found
        return maxLen == 0 ? 0 : maxLen + 2;
    }
}
