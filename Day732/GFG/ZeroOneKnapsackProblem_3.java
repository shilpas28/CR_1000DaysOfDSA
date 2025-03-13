//GFG
//0 - 1 Knapsack Problem - Space Optimization
//Time complexity:
//Space complexity:

public class ZeroOneKnapsackProblem_3 {

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
