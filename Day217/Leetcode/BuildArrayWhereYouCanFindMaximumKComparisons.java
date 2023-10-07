//Leetcode
//1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
//Time complexity: O(n * m * k * m)
//There are total n*m*k states stored in dp, each state needs maximum m iteration loops to calculate the result.
//Space complexity: O(n * m * k)

package Leetcode;

public class BuildArrayWhereYouCanFindMaximumKComparisons {
    
    public static void main(String[] args) {
        int n = 2, m = 3, k = 1;
        System.out.println(numOfArrays(n, m, k));
    }

    public static int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
        return dfs(n, m, k, 0, 0, 0, dp);
    }

    // dfs(... i, currMax, currCost) the number of ways to build the valid array `arr[i:]`
    //     keeping in mind that current maximum element is `currMax` and current search cost is `currCost`
    static int dfs(int n, int m, int k, int i, int currMax, int currCost, Integer[][][] dp) {
        if (i == n) {
            if (k == currCost) return 1; // valid if the value search cost is equal to k
            return 0;
        }
        if (dp[i][currMax][currCost] != null) return dp[i][currMax][currCost];
        int ans = 0;
        for (int num = 1; num <= m; num++) {
            int newCost = currCost;
            int newMax = currMax;
            if (num > currMax) {
                newCost++;
                newMax = num;
            }
            if (newCost > k) break;
            ans += dfs(n, m, k, i + 1, newMax, newCost, dp);
            ans %= 1_000_000_007;
        }
        return dp[i][currMax][currCost] = ans;
    }
}
