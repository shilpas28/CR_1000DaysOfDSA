//GFG
//Find shortest safe route in a matrix - Recursive
//Time complexity: O(3^(n*m)) - Exponential
//Space complexity: O(n)

package GFG;

public class FindShortestSafeRouteInAMatrix_2 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 0 } };
        System.out.println(findShortestPath(mat));
    }

    static int max = 1000000000;

    public static int findShortestPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];

        int min = max;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, rec(i, 0, mat, vis)); // from leftmost to rightmost
        }
        return min == max ? -1 : min;
    }

    static int rec(int i, int j, int mat[][], boolean vis[][]) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j] == true || mat[i][j] == 0
                || isValid(i, j, mat) == false)
            return max;

        if (j == mat[0].length - 1)
            return 1;
        vis[i][j] = true;

        int up = 1 + rec(i - 1, j, mat, vis);
        int down = 1 + rec(i + 1, j, mat, vis);
        int right = 1 + rec(i, j + 1, mat, vis);

        vis[i][j] = false; // backtracking
        return Math.min(up, Math.min(down, right));
    }

    static boolean isValid(int i, int j, int mat[][]) {

        if (i - 1 >= 0 && mat[i - 1][j] == 0)
            return false;
        if (i + 1 < mat.length && mat[i + 1][j] == 0)
            return false;
        if (j + 1 < mat[0].length && mat[i][j + 1] == 0)
            return false;
        if (j - 1 >= 0 && mat[i][j - 1] == 0)
            return false;
        return true;
    }
}
