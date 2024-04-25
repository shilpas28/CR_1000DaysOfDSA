//GFG
//Maximum sum of hour glass
//Time complexity: O(n*m)
//Space complexity: O(1)

public class MaximumSumOfHourGlass {

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(findMaxSum(n, m, mat));
    }

    static int findMaxSum(int n, int m, int mat[][]) {
        // code here
        if (n < 3 || m < 3)
            return -1;
        int ans = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            int sum = 0;
            for (int j = 1; j < m - 1; j++) {
                sum = mat[i][j - 1] + mat[i - 2][j - 1] + mat[i - 1][j] + mat[i][j] + mat[i - 2][j] + mat[i][j + 1]
                        + mat[i - 2][j + 1];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
