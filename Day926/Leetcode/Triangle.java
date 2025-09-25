//Leetcode
//120. Triangle - Memoization/Top down (Not accepted as TLE)
//Time complexity: O(N*N) - At max, there will be (half of, due to triangle) N*N calls of recursion.
//Space complexity: O(N) + O(N*N) - We are using a recursion stack space: O((N), where N is the path length 
//and an external DP Array of size N*N.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        // triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> ln1 = new ArrayList<>();
        ln1.add(2);
        triangle.add(0, ln1);
        List<Integer> ln2 = new ArrayList<>();
        ln2.add(3);
        ln2.add(4);
        triangle.add(ln2);
        List<Integer> ln3 = new ArrayList<>();
        ln3.add(6);
        ln3.add(5);
        ln3.add(7);
        triangle.add(ln3);
        List<Integer> ln4 = new ArrayList<>();
        ln4.add(4);
        ln4.add(1);
        ln4.add(8);
        ln4.add(3);
        triangle.add(ln4);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                mat[i][j] = triangle.get(i).get(j);
            }
        }
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return minimumPathSumUtil(0, 0, mat, n, dp);
    }

    static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == n - 1)
            return triangle[i][j];

        int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }
}
