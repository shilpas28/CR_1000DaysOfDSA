//GFG
//Coin Change - Memoization
//Time complexity: O(N*T)
//Space complexity: O(N*T) + O(N)

package GFG;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int N = 3, sum = 4;
        int[] coins = { 1, 2, 3 };
        System.out.println(count(coins, N, sum));
    }

    public static long count(int coins[], int N, int sum) {
        // code here.
        long dp[][] = new long[N][sum + 1];
        for (long row[] : dp)
            Arrays.fill(row, -1);
        return countWaysToMakeChangeUtil(coins, N - 1, sum, dp);
    }

    static long countWaysToMakeChangeUtil(int[] arr,int ind, int T, long[][] dp){

        if(ind == 0){
            if(T%arr[0]==0)
            return 1;
            else
            return 0;
        }
        if(dp[ind][T]!=-1)
            return dp[ind][T];
        long notTaken = countWaysToMakeChangeUtil(arr,ind-1,T,dp);
        long taken = 0;
        if(arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr,ind,T-arr[ind],dp);
        return dp[ind][T] = notTaken + taken;
    }
}
