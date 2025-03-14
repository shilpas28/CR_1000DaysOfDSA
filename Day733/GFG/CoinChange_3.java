//GFG
//Coin Change (Count Ways) - Space Optimization
//Time complexity: O(N*T)
//Space complexity: O(T) 

public class CoinChange_3 {

    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(count(coins, sum));
    }

    public static int count(int coins[], int sum) {
        // code here.
        int N = coins.length;
        int[] prev = new int[sum + 1];
        // Initializing base condition
        for (int i = 0; i <= sum; i++) {
            if (i % coins[0] == 0)
                prev[i] = 1;
            // Else condition is automatically fulfilled,
            // as prev array is initialized to zero
        }
        for (int ind = 1; ind < N; ind++) {
            int cur[] = new int[sum + 1];
            for (int target = 0; target <= sum; target++) {
                int notTaken = prev[target];
                int taken = 0;
                if (coins[ind] <= target)
                    taken = cur[target - coins[ind]];
                cur[target] = notTaken + taken;
            }
            prev = cur;
        }
        return prev[sum];
    }
}
