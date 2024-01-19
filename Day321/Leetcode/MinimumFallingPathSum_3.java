//Leetcode - Solution accepted after making change for cur as cur.clone() [deep copy]
//931. Minimum Falling Path Sum - Space optimization
//Time complexity: O(N*M) - There are two nested loops
//Space complexity: O(M) - We are using an external array of size 'M' to store only one row.

package Leetcode;

public class MinimumFallingPathSum_3 {

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int prev[] = new int[m];
        int cur[] = new int[m];
        // Initializing first row - base condition
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = matrix[i][j] + prev[j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0)
                    leftDiagonal += prev[j - 1];
                else
                    leftDiagonal += (int) Math.pow(10, 9);

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m)
                    rightDiagonal += prev[j + 1];
                else
                    rightDiagonal += (int) Math.pow(10, 9);

                cur[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));

            }
            prev = cur.clone();
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }
        return mini;
    }
}
