//GFG
//Grinding Geek 
//Time complexity: O(n*total)
//Space complexity: O(n*total)

package GFG;

public class GrindingGeek_2 {

    public static void main(String[] args) {
        int n = 2, total = 10;
        int[] cost = { 10, 9 };
        System.out.println(max_courses(n, total, cost));
    }

    public static int max_courses(int n, int total, int[] cost) {
        // code here
        int[][] dp = new int[n + 1][total + 1];
        for (int sum = 1; sum <= total; ++sum) {
            for (int index = n - 1; index >= 0; index--) {
                int purchase = 0, notPurchase = 0;

                if (cost[index] <= sum) {
                    purchase = 1 + dp[index + 1][sum - cost[index] + (cost[index] * 9) / 10];
                }
                notPurchase = dp[index + 1][sum];

                dp[index][sum] = Math.max(purchase, notPurchase);
            }
        }
        return dp[0][total];
    }
}
