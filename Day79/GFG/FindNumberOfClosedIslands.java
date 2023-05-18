//GFG
//Find Number Of Closed Islands - using DFS
//Time complexity: O(M*N)
//Space complexity: O(M*N)

package GFG;

public class FindNumberOfClosedIslands {

    public static void main(String[] args) {
        int N = 5, M = 8;
        int mat[][] = { { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 1, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 } };
        System.out.println(closedIslands(mat, N, M));
    }

    public static int closedIslands(int[][] matrix, int N, int M) {
        // Code here
        // traverse for each cell and if not vis call dfs - cnt++
        // //standard dfs for disconnected graphs
        boolean vis[][] = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (!vis[i][j] && matrix[i][j] == 1 && !c_c(i, j, N, M)) {

                    boolean hasCorner[] = new boolean[1];

                    dfs(matrix, vis, i, j, N, M, hasCorner);
                    if (!hasCorner[0])
                        cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int[][] mat, boolean[][] vis, int x, int y, int n, int m, boolean[] hasCorner) {
        // stopping cond - out of bound - vis and cell==0
        if (x < 0 || y < 0 || x >= n || y >= m || vis[x][y] == true || mat[x][y] == 0)
            return;
        // if has corner cell and cell==1 - mark hascorner as true;
        if (c_c(x, y, n, m) && (mat[x][y] == 1))
            hasCorner[0] = true;
        // mark curr cell vis and recur for all 4 neigbors
        vis[x][y] = true;
        dfs(mat, vis, x + 1, y, n, m, hasCorner);
        dfs(mat, vis, x, y + 1, n, m, hasCorner);
        dfs(mat, vis, x - 1, y, n, m, hasCorner);
        dfs(mat, vis, x, y - 1, n, m, hasCorner);
    }

    static boolean c_c(int i, int j, int n, int m) // check_corner
    {
        return i == 0 || j == 0 || i == n - 1 || j == m - 1;
    }
}
