//Leetcode
//2257. Count Unguarded Cells in the Grid
//Time complexity: O(m*n)
//Space complexity: O(m*n)

public class CountUnguardedCellsInTheGrid {

    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int[][] walls = { { 0, 1 }, { 2, 2 }, { 1, 4 } };
        System.out.println(countUnguarded(m, n, guards, walls));
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Initialize grid with zeros
        int[][] g = new int[m][n];
        // Mark guards and walls as 2
        for (int[] e : guards) {
            g[e[0]][e[1]] = 2;
        }
        for (int[] e : walls) {
            g[e[0]][e[1]] = 2;
        }
        // Directions: up, right, down, left
        int[] dirs = { -1, 0, 1, 0, -1 };
        // Process each guard's line of sight
        for (int[] e : guards) {
            for (int k = 0; k < 4; ++k) {
                int x = e[0], y = e[1];
                int dx = dirs[k], dy = dirs[k + 1];

                // Check cells in current direction until hitting boundary or obstacle
                while (x + dx >= 0 && x + dx < m && y + dy >= 0 && y + dy < n && g[x + dx][y + dy] < 2) {
                    x += dx;
                    y += dy;
                    g[x][y] = 1;
                }
            }
        }
        // Count unguarded cells (cells with value 0)
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
    }
}
