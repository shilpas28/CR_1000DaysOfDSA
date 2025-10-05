//GFG
//Rat in a Maze - I
//Time complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
//Space complexity: O(m*n), Maximum Depth of the recursion tree(auxiliary space).

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        System.out.println(ratInMaze(maze));
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        if (maze[0][0] == 1)
            solve(0, 0, maze, n, ans, "", vis);
        return ans;
    }

    static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move,
            int vis[][]) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
            vis[i][j] = 1;
            solve(i + 1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }
        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            vis[i][j] = 1;
            solve(i, j - 1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }
        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
            vis[i][j] = 1;
            solve(i, j + 1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }
        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            vis[i][j] = 1;
            solve(i - 1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }
}
