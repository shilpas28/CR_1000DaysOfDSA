//GFG
//Flood fill Algorithm
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class FloodFillAlgorithm {

    public static void main(String[] args) {
        int image[][] = { { 1, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        int sr = 1, sc = 2, newColor = 2;
        int[][] res = floodFill(image, sr, sc, newColor);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        // get initial color
        int iniColor = image[sr][sc];
        int[][] ans = image;
        // delta row and delta column for neighbours
        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, 0, -1 };
        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }

    static void dfs(int row, int col,
            int[][] ans,
            int[][] image,
            int newColor, int delRow[], int delCol[],
            int iniColor) {
        // color with new color
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        // there are exactly 4 neighbours
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            // check for valid coordinate
            // then check for same initial color and unvisited pixel
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }
}
