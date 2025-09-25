//Leetcode
//120. Triangle - Tabulation/Bottom up
//Time complexity: O(N*N) - There are two nested loops
//Space complexity: O(N*N) - We are using an external array of size N*N. The stack space will be eliminated.

import java.util.ArrayList;
import java.util.List;

public class Triangle_2 {

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

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = mat[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {

                int down = mat[i][j] + dp[i + 1][j];
                int diagonal = mat[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}
