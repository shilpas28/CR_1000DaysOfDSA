//GFG
//Gold Mine Problem
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class GoldMineProblem_2 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };
        System.out.println(maxGold(mat));
    }

    public static int maxGold(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int arr[][] = new int[n][m];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1)
                    arr[i][j] = mat[i][j];
                else {
                    int ud = (i - 1) >= 0 ? arr[i - 1][j + 1] : 0;
                    int r = Math.max(ud, arr[i][j + 1]);
                    int ld = (i + 1) < n ? arr[i + 1][j + 1] : 0;
                    int max = Math.max(r, ld);

                    arr[i][j] = max + mat[i][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, arr[i][0]);

        return res;
    }
}
