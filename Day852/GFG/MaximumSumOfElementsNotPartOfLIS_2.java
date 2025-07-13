//GFG
//Maximum sum of elements not part of LIS
//Time complexity: O(NlogN)
//Space complexity: O(N) 

package GFG;

public class MaximumSumOfElementsNotPartOfLIS_2 {

    public static void main(String[] args) {
        int arr[] = { 4, 6, 1, 2, 3, 8 };
        System.out.println(nonLisMaxSum(arr));
    }

    public static int nonLisMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        // Find total sum of array
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        // Maintain a 2D array
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
            dp[1][i] = arr[i];
        }
        // Update the dp array along
        // with sum in the second row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    // In case of greater length
                    // Update the length along
                    // with sum
                    if (dp[0][i] < dp[0][j] + 1) {
                        dp[0][i] = dp[0][j] + 1;
                        dp[1][i] = dp[1][j] + arr[i];
                    }
                    // In case of equal length
                    // find length update length
                    // with minimum sum
                    else if (dp[0][i] == dp[0][j] + 1) {
                        dp[1][i] = Math.min(dp[1][i],
                                dp[1][j] + arr[i]);
                    }
                }
            }
        }
        int maxm = 0;
        int subtractSum = 0;
        // Find the sum that need to
        // be subtracted from total sum
        for (int i = 0; i < n; i++) {
            if (dp[0][i] > maxm) {
                maxm = dp[0][i];
                subtractSum = dp[1][i];
            } else if (dp[0][i] == maxm) {
                subtractSum = Math.min(subtractSum, dp[1][i]);
            }
        }
        // Return the sum
        return totalSum - subtractSum;
    }
}
