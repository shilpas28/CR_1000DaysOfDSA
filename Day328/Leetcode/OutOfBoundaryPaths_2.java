//Leetcode
//576. Out of Boundary Paths - Memoization 
//Time complexity: O(Nmn)
//Space complexity: O(Nmn)

package Leetcode;

public class OutOfBoundaryPaths_2 {

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] mem = new int[maxMove + 1][m][n];
        for (int x = 0; x <= maxMove; x++)
            for (int y = 0; y < m; y++)
                for (int z = 0; z < n; z++)
                    mem[x][y][z] = -1;
        return findPaths(maxMove, startRow, startColumn, mem);
    }

    static int findPaths(int N, int i, int j, int[][][] mem) {
        if (i < 0 || i == mem[0].length || j < 0 || j == mem[0][0].length)
            return 1;
        if (N == 0)
            return 0;
        if (mem[N][i][j] >= 0)
            return mem[N][i][j];
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int tot = 0;
        for (int k = 0; k < 4; k++)
            tot = (tot + findPaths(N - 1, i + dir[k][0], j + dir[k][1], mem)) % 1000000007;
        return mem[N][i][j] = tot;
    }
}
