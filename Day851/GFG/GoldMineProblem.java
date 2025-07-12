//GFG
//Gold Mine Problem
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class GoldMineProblem {

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };
        System.out.println(maxGold(mat));
    }

    public static int maxGold(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    if (i + 1 < n) {
                        mat[i][j] += Math.max(mat[i][j + 1], mat[i + 1][j + 1]);
                    } else {
                        mat[i][j] += mat[i][j + 1];
                    }
                } else if (i == n - 1) {
                    if (i - 1 >= 0) {
                        mat[i][j] += Math.max(mat[i][j + 1], mat[i - 1][j + 1]);
                    } else {
                        mat[i][j] += mat[i][j + 1];
                    }
                } else {
                    int temp = mat[i][j + 1];
                    if (i + 1 < n) {
                        temp = Math.max(temp, mat[i + 1][j + 1]);
                    }
                    if (i - 1 >= 0) {
                        temp = Math.max(temp, mat[i - 1][j + 1]);
                    }
                    mat[i][j] += temp;
                }
                if (j == 0) {
                    ans = Math.max(mat[i][j], ans);
                }
            }
        }
        return ans;
    }
}
