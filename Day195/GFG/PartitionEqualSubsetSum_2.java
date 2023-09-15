//GFG
//Partition Equal Subset Sum - Tabulation/Bottom up
//Time complexity: O(N*K) +O(N). There are two nested loops that account for O(N*K) and 
//at starting we are running a for loop to calculate totSum.
//Space complexity: O(N*K). We are using an external array of size ‘N*K’. Stack Space is eliminated. 

package GFG;

public class PartitionEqualSubsetSum_2 {

    public static void main(String[] args) {
        int N = 4;
        int[] arr = { 1, 5, 11, 5 };
        System.out.println(equalPartition(N, arr));
    }

    static int equalPartition(int N, int arr[]) {
        // code here
        boolean res = equalPartitionHelper(N, arr);
        if (res == false)
            return 0;
        else
            return 1;
    }

    static boolean equalPartitionHelper(int N, int arr[]) {
        // code here
        int totSum = 0;

        for (int i = 0; i < N; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1)
            return false;

        else {
            int k = totSum / 2;
            boolean dp[][] = new boolean[N][k + 1];

            for (int i = 0; i < N; i++) {
                dp[i][0] = true;
            }

            if (arr[0] <= k)
                dp[0][arr[0]] = true;

            for (int ind = 1; ind < N; ind++) {
                for (int target = 1; target <= k; target++) {

                    boolean notTaken = dp[ind - 1][target];

                    boolean taken = false;
                    if (arr[ind] <= target)
                        taken = dp[ind - 1][target - arr[ind]];

                    dp[ind][target] = notTaken || taken;
                }
            }
            return dp[N - 1][k];
        }
    }
}
