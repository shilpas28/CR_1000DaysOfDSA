//GFG
//Matrix Chain Multiplication - Not accepted as TLE 
//Time complexity: O(N^3)
//Space complexity: O(N^2)

import java.util.Arrays;

public class MatrixChainMultiplication_2 {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 4 };
        System.out.println(matrixMultiplication(arr));
    }

    static int matrixMultiplication(int arr[]) {
        // code here
        int N = arr.length;
        int dp[][] = new int[N][N];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        int i = 1;
        int j = N - 1;

        return f(arr, i, j, dp);
    }

    static int f(int arr[], int i, int j, int[][] dp) {
        // base condition
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;
        // partioning loop
        for (int k = i; k <= j - 1; k++) {

            int ans = f(arr, i, k, dp) + f(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];

            mini = Math.min(mini, ans);

        }
        return mini;
    }
}
