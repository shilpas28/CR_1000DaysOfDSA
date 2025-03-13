//GFG
//0 - 1 Knapsack Problem - Tabulation 
//Time complexity: O(N*W) - There are two nested loops
//Space complexity: O(N*W) - We are using an external array of size â€˜N*Wâ€™. Stack Space is eliminated.

public class ZeroOneKnapsackProblem_2 {

    public static void main(String[] args) {
        int W = 4;
        int val[] = { 1, 2, 3 };
        int wt[] = { 4, 5, 1 };
        System.out.println(knapSack(W, val, wt));
    }

    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        // Create a 2D DP array to store the maximum value for each subproblem
        int dp[][] = new int[n][W + 1];
        // Base Condition
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = dp[ind - 1][cap];
                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];
                }
                // Store the maximum value for the current state
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        // The result is stored in the last row and last column of the DP array
        return dp[n - 1][W];
    }
}
