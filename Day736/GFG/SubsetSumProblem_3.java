//GFG
//Subset Sum Problem - Space Optimization
//Time complexity: O(N*K)
//Space complexity: O(K)

public class SubsetSumProblem_3 {

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        System.out.println(isSubsetSum(arr, sum));
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        // Create an array to store the previous row of the DP table
        boolean prev[] = new boolean[sum + 1];
        // Initialize the first row of the DP table
        prev[0] = true;
        // Initialize the first column of the DP table
        if (arr[0] <= sum) {
            prev[arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store the current row of the DP table
            boolean cur[] = new boolean[sum + 1];
            // Initialize the first column of the current row
            cur[0] = true;

            for (int target = 1; target <= sum; target++) {
                // Calculate if the current target can be achieved without taking the current
                // element
                boolean notTaken = prev[target];
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }
                // Store the result in the current row of the DP table
                cur[target] = notTaken || taken;
            }
            // Update the previous row with the current row
            prev = cur;
        }
        // The final result is stored in the last cell of the previous row
        return prev[sum];
    }
}
