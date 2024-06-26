//GFG
//Coverage of all Zeros in a Binary Matrix
//Time complexity: O(n*m)
//Space complexity: O(1)

package GFG;

public class CoverageOfAllZerosInABinaryMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 0 },
                { 0, 1, 1 },
                { 0, 0, 0 } };
        System.out.println(findCoverage(matrix));
    }

    public static int findCoverage(int[][] matrix) {
        // code here
        int n = matrix.length, m = matrix[0].length, ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1)
                    continue;
                // l
                if (j - 1 >= 0 && matrix[i][j - 1] == 1)
                    ans++;
                // r
                if (j + 1 < m && matrix[i][j + 1] == 1)
                    ans++;
                // u
                if (i - 1 >= 0 && matrix[i - 1][j] == 1)
                    ans++;
                // d
                if (i + 1 < n && matrix[i + 1][j] == 1)
                    ans++;
            }
        }
        return ans;
    }
}
