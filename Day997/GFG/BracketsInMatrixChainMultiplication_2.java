//GFG
//Brackets in Matrix Chain Multiplication
//Time complexity: O(N^3)
//Space complexity: O(N^2)

import java.util.Arrays;

public class BracketsInMatrixChainMultiplication_2 {

    public static void main(String[] args) {
        int arr[] = {40, 20, 30, 10, 30};
        System.out.println(matrixChainOrder(arr));
    }

    public static String matrixChainOrder(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int temp[] : dp) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        int brackets[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                for (int k = j; k < j + i - 1; k++) {
                    int total = dp[j][k] + dp[k + 1][j + i - 1] + arr[j - 1] * arr[k] * arr[j + i - 1];
                    if (total < dp[j][j + i - 1]) {
                        dp[j][j + i - 1] = total;
                        brackets[j][j + i - 1] = k;
                    }
                }
            }
        }
        return help(1, n - 1, brackets);
    }

    static String help(int i, int j, int brackets[][]) {
        if (i == j) {
            char a = (char) ('A' + i - 1);
            String temp = "";
            temp += a;
            return temp;
        }
        return '(' + help(i, brackets[i][j], brackets) + help(brackets[i][j] + 1, j, brackets) + ')';
    }
}
