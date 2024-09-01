//Leetcode
//2022. Convert 1D Array Into 2D Array
//Time complexity: O(N)
//Space complexity: O(M*N)

package Leetcode;

public class Convert1DArrayInto2DArray_2 {

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
        if (original.length != m * n)
            return new int[0][0];
        int ans[][] = new int[m][n];
        for (int i = 0; i < original.length; ++i) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }
}
