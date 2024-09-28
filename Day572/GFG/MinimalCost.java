//GFG
//Minimal Cost
//Time complexity: O(n*k)
//Space complexity: O(n)

import java.util.Arrays;

public class MinimalCost {

    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 10, 30, 40, 50, 20 };
        System.out.println(minimizeCost(k, arr));
    }

    public static int minimizeCost(int k, int arr[]) {
        // code here
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return help(0, k, arr, dp);
    }

    static int help(int i, int k, int arr[], int dp[]) {
        if (i == arr.length - 1)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + k && j < arr.length; j++) {
            int cost = Math.abs(arr[i] - arr[j]) + help(j, k, arr, dp);
            ans = Math.min(ans, cost);
        }
        return dp[i] = ans;
    }
}
