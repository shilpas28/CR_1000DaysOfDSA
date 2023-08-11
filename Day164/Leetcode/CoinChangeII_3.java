//Leetcode
//518. Coin Change II - Space Optimization 
//Time complexity: O(N*T)
//Space complexity: O(T)

public class CoinChangeII_3 {

    public static void main(String[] args) {
        int amount = 5, coins[] = { 1, 2, 5 };
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {

        int n = coins.length;
        long[] prev = new long[amount + 1];
        // Initializing base condition
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = 1;
            // Else condition is automatically fulfilled,
            // as prev array is initialized to zero
        }
        for (int ind = 1; ind < n; ind++) {
            long cur[] = new long[amount + 1];
            for (int target = 0; target <= amount; target++) {
                long notTaken = prev[target];
                long taken = 0;
                if (coins[ind] <= target)
                    taken = cur[target - coins[ind]];
                cur[target] = notTaken + taken;
            }
            prev = cur;
        }
        return (int) prev[amount];
    }
}
