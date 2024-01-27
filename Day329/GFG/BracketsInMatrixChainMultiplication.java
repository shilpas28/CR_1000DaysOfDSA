//GFG
//Brackets in Matrix Chain Multiplication
//Time complexity: O(N^3)
//Space complexity: O(N^2)

package GFG;

public class BracketsInMatrixChainMultiplication {

    static class Pair {
        int val;
        String str;

        Pair(int val, String str) {
            this.val = val;
            this.str = str;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int p[] = { 1, 2, 3, 4, 5 };
        System.out.println(matrixChainOrder(p, n));
    }

    static String matrixChainOrder(int p[], int n) {
        // code here
        Pair[][] dp = new Pair[n - 1][n - 1];
        for (int d = 0; d < dp.length; d++)
            for (int i = 0, j = d; j < dp.length; i++, j++)
                if (d == 0) {
                    int val = 0;
                    String s = "" + (char) ('A' + i);
                    dp[i][j] = new Pair(val, s);
                } else if (d == 1) {
                    int val = p[i] * p[j] * p[j + 1];
                    String s = "(" + (char) ('A' + i) + (char) ('A' + j) + ")";
                    dp[i][j] = new Pair(val, s);
                } else {
                    int min = Integer.MAX_VALUE;
                    String s = "";
                    for (int k = i; k < j; k++) {
                        int lc = dp[i][k].val;
                        int rc = dp[k + 1][j].val;
                        int mc = p[i] * p[k + 1] * p[j + 1];
                        int tc = lc + rc + mc;

                        if (tc < min) {
                            min = tc;
                            s = "(" + dp[i][k].str + dp[k + 1][j].str + ")";
                        }
                    }
                    dp[i][j] = new Pair(min, s);
                }
        return dp[0][dp.length - 1].str;
    }
}
