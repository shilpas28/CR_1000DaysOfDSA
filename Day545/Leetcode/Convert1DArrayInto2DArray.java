//Leetcode
//2022. Convert 1D Array Into 2D Array
//Time complexity: O(M*N)
//Space complexity: O(M*N)

package Leetcode;

public class Convert1DArrayInto2DArray {

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4 };
        int m = 2, n = 2;
        int[][] res = construct2DArray(original, m, n);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int ans[][] = new int[m][n];
        if (original.length != (m * n))
            return new int[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }
}
