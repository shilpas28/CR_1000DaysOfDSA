//GFG
//Brackets in Matrix Chain Multiplication
//Time complexity: O(N^3)
//Space complexity: O(N^2)

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
        int arr[] = {40, 20, 30, 10, 30};
        System.out.println(matrixChainOrder(arr));
    }

    public static String matrixChainOrder(int arr[]) {
        // code here
        int n = arr.length;
        Pair[][] dp = new Pair[n - 1][n - 1];
        for (int d = 0; d < dp.length; d++) {
            for (int i = 0, j = d; j < dp.length; i++, j++) {
                if (d == 0) {
                    int val = 0;
                    String s = "" + (char) ('A' + i);
                    dp[i][j] = new Pair(val, s);
                } else if (d == 1) {
                    int val = arr[i] * arr[j] * arr[j + 1];
                    String s = "(" + (char) ('A' + i) + (char) ('A' + j) + ")";
                    dp[i][j] = new Pair(val, s);
                } else {
                    int min = Integer.MAX_VALUE;
                    String s = "";
                    for (int k = i; k < j; k++) {
                        int lc = dp[i][k].val;
                        int rc = dp[k + 1][j].val;
                        int mc = arr[i] * arr[k + 1] * arr[j + 1];
                        int tc = lc + rc + mc;

                        if (tc < min) {
                            min = tc;
                            s = "(" + dp[i][k].str + dp[k + 1][j].str + ")";
                        }
                    }
                    dp[i][j] = new Pair(min, s);
                }
            }
        }
        return dp[0][dp.length - 1].str;
    }
}
