//GFG
//Left Rotate Matrix K times
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class LeftRotateMatrixKTimes {

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 1;
        int[][] res = rotateMatrix(k, mat);
        for (int row[] : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        int rows = mat.length, cols = mat[0].length;
        k %= cols;
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - k; j++) {
                ans[i][j] = mat[i][j + k];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = cols - k; j < cols; j++) {
                ans[i][j] = mat[i][j + k - cols];
            }
        }
        return ans;
    }
}
