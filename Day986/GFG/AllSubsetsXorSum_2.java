//GFG
//All Subsets Xor Sum
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class AllSubsetsXorSum_2 {

    public static void main(String[] args) {
        int[] arr = {7, 2};
        System.out.println(subsetXORSum(arr));
    }

    static int subsetXORSum(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][2048];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, arr, dp);
    }

    static int f(int ind, int xor, int[] arr, int dp[][]) {
        if (ind == arr.length) {
            return xor;
        }

        if (dp[ind][xor] != -1) {
            return dp[ind][xor];
        }

        int take = f(ind + 1, xor ^ arr[ind], arr, dp);
        int notTake = f(ind + 1, xor, arr, dp);

        return dp[ind][xor] = take + notTake;
    }
}
