//GFG
//Max Sum without Adjacents
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MaxSumWithoutAdjacents_2 {

    public static void main(String[] args) {
        int N = 6;
        int Arr[] = { 5, 5, 10, 100, 10, 5 };
        System.out.println(findMaxSum(Arr, N));
    }

    static int findMaxSum(int arr[], int n) {
        // code here
        int[] dp = new int[n + 1];
        dp[0] = arr[0];
        if (n == 1)
            return dp[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        return dp[n - 1];
    }
}
