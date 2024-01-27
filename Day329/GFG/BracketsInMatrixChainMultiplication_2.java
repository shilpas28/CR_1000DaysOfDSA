//GFG
//Brackets in Matrix Chain Multiplication
//Time complexity: O(N^3)
//Space complexity: O(N^2)

package GFG;

import java.util.Arrays;

public class BracketsInMatrixChainMultiplication_2 {

    public static void main(String[] args) {
        int n = 5;
        int p[] = { 1, 2, 3, 4, 5 };
        System.out.println(matrixChainOrder(p, n));
    }

    static String matrixChainOrder(int p[], int n) {
        // code here
        int dp[][] = new int[n][n];
        for (int temp[] : dp)
            Arrays.fill(temp, Integer.MAX_VALUE);
        int brackets[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                for (int k = j; k < j + i - 1; k++) {
                    int total = dp[j][k] + dp[k + 1][j + i - 1] + p[j - 1] * p[k] * p[j + i - 1];
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
