//GFG
//Coin Change - Space Optimization
//Time complexity: O(N*T)
//Space complexity: O(T) 

package GFG;

public class CoinChange_3 {

    public static void main(String[] args) {
        int N = 3, sum = 4;
        int[] coins = { 1, 2, 3 };
        System.out.println(count(coins, N, sum));
    }

    public static long count(int coins[], int N, int sum) {
        // code here.
        long[] prev = new long[sum + 1];
        // Initializing base condition
        for (int i = 0; i <= sum; i++) {
            if (i % coins[0] == 0)
                prev[i] = 1;
            // Else condition is automatically fulfilled,
            // as prev array is initialized to zero
        }
        for (int ind = 1; ind < N; ind++) {
            long cur[] = new long[sum + 1];
            for (int target = 0; target <= sum; target++) {
                long notTaken = prev[target];
                long taken = 0;
                if (coins[ind] <= target)
                    taken = cur[target - coins[ind]];
                cur[target] = notTaken + taken;
            }
            prev = cur;
        }
        return prev[sum];
    }
}
