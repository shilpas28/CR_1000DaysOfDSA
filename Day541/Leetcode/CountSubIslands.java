//Leetcode
//1905. Count Sub Islands - DFS
//Time complexity: O(m * n)
//Space complexity: O(m * n)

public class CountSubIslands {

    public static void main(String[] args) {
        int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 } };
        int[][] grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 } };
        System.out.println(countSubIslands(grid1, grid2));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        for (int i = 0; i < grid2.length; i++)
            for (int j = 0; j < grid2[0].length; j++)
                if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i, j))
                    result++;
        return result;
    }

    static boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        boolean result = true;
        if (i >= 0 && i < grid2.length && j >= 0 && j < grid2[0].length && grid2[i][j] == 1) {
            if (grid2[i][j] != grid1[i][j])
                result = false;
            grid2[i][j] = -1; // Mark Visited
            boolean left = isSubIsland(grid1, grid2, i, j - 1);
            boolean right = isSubIsland(grid1, grid2, i, j + 1);
            boolean top = isSubIsland(grid1, grid2, i - 1, j);
            boolean bottom = isSubIsland(grid1, grid2, i + 1, j);
            if (!left || !right || !top || !bottom)
                return false;
        }
        return result;
    }
}
