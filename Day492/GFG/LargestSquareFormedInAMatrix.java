//GFG
//Largest square formed in a matrix
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class LargestSquareFormedInAMatrix {

    public static void main(String[] args) {
        int n = 6, m = 5;
        int[][] mat = { { 0, 1, 1, 0, 1 },
                { 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 } };
        System.out.println(maxSquare(n, m, mat));
    }

    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int dp[][] = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = mat[i][j];
                } else {
                    if (mat[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
