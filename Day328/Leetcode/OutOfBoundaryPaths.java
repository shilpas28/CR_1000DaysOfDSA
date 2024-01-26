//Leetcode - Not accepted as TLE
//576. Out of Boundary Paths - Brute Force
//Time complexity: O(4^N)
//Space complexity: O(4^N) 

package Leetcode;

public class OutOfBoundaryPaths {

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startRow == m || startColumn < 0 || startColumn == n)
            return 1;
        if (maxMove == 0)
            return 0;
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int tot = 0;
        for (int k = 0; k < 4; k++)
            tot = (tot + findPaths(m, n, maxMove - 1, startRow + dir[k][0], startColumn + dir[k][1])) % 1000000007;
        return tot;
    }
}
