//GFG
//0 - 1 Knapsack Problem - Space Optimization
//Time complexity: O(N*W) - There are two nested loops.
//Space complexity: O(W) - We are using an external array of size ‘W+1’ to store only one row.

public class ZeroOneKnapsackProblem_3 {

    public static void main(String[] args) {
        int W = 4;
        int val[] = { 1, 2, 3 }, wt[] = { 4, 5, 1 };
        System.out.println(knapSack(W, wt, val));
    }

    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        // Create an array to store the maximum value for each capacity (previous row)
        int prev[] = new int[W + 1];
        // Base Condition: Initialize the first row of the array
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }
        // Iterate through each item and capacity
        for (int ind = 1; ind < n; ind++) {
            for (int cap = W; cap >= 0; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];
                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }
                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }
        // The result is stored in the last element of the array
        return prev[W];
    }
}
