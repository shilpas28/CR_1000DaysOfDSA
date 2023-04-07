//Leetcode
//1020. Number of Enclaves - Using DFS
//Time complexity: O(M*N)
//Space complexity: O(M*N)


package Leetcode;

public class NumberOfEnclaves_1 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, 1, 0, -1 };
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        // traverse first row and last row
        for (int j = 0; j < n; j++) {
            // check for unvisited Os in the boundary rws
            // first row
            if (vis[0][j] == 0 && grid[0][j] == 1) {
                dfs(0, j, vis, grid, delrow, delcol);
            }

            // last row
            if (vis[m - 1][j] == 0 && grid[m - 1][j] == 1) {
                dfs(m - 1, j, vis, grid, delrow, delcol);
            }
        }

        for (int i = 0; i < m; i++) {
            // check for unvisited Os in the boundary columns
            // first column
            if (vis[i][0] == 0 && grid[i][0] == 1) {
                dfs(i, 0, vis, grid, delrow, delcol);
            }

            // last column
            if (vis[i][n - 1] == 0 && grid[i][n - 1] == 1) {
                dfs(i, n - 1, vis, grid, delrow, delcol);
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0)
                    count++;
            }
        return count;
    }

    static void dfs(int row, int col, int vis[][],
            int mat[][], int delrow[], int delcol[]) {
        vis[row][col] = 1;
        int m = mat.length;
        int n = mat[0].length;

        // check for top, right, bottom, left
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            // check for valid coordinates and unvisited Os
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }
}
