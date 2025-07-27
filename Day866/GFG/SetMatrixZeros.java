//GFG
//Set Matrix Zeros
//Time complexity: O(n*m)
//Space complexity: O(1)

package GFG;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] mat = { { 1, -1, 1 }, { -1, 0, 1 }, { 1, -1, 1 } };
        setMatrixZeroes(mat);
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZeroes(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {

                    mat[i][0] = 0;

                    if (j != 0)
                        mat[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != 0) {

                    if (mat[i][0] == 0 || mat[0][j] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }
        }

        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
