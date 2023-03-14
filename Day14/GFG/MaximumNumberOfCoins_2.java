//GFG - Using memoization
//Maximum Number of coins
//Time complexity: O(N^3)
//Space complexity: O(N^2)

package GFG;

import java.util.ArrayList;

public class MaximumNumberOfCoins_2 {

    public static void main(String[] args) {
        int N = 2;
        // int a[]={5, 10};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(10);
        System.out.println(maxCoins(N, a));
    }

    static Integer[][] dp;

    static int maxCoins(int N, ArrayList<Integer> arr) {
        // Write your code here
        dp = new Integer[N + 2][N + 2];
        arr.add(0, 1);
        arr.add(1);
        return solve(1, arr, N);
    }

    public static int solve(int i, ArrayList<Integer> arr, int j) {
        if (i > j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int max = Integer.MIN_VALUE;

        for (int b = i; b <= j; b++) {
            int cost = arr.get(b) * arr.get(i - 1) * arr.get(j + 1) + solve(b + 1, arr, j) + solve(i, arr, b - 1);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
}
