//Leetcode
//59. Spiral Matrix II
//Time complexity: O(N*M)
//Space complexity: O(1)

package Leetcode;

public class SpiralMatrix2_2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for (int arr[] : matrix) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, ct = 1;
        while (ct <= n * n) {
            for (int j = left; j <= right && ct <= n * n; j++)
                matrix[up][j] = ct++;
            for (int i = up + 1; i <= down - 1 && ct <= n * n; i++)
                matrix[i][right] = ct++;
            for (int j = right; j >= left && ct <= n * n; j--)
                matrix[down][j] = ct++;
            for (int i = down - 1; i >= up + 1 && ct <= n * n; i--)
                matrix[i][left] = ct++;
            left++;
            right--;
            up++;
            down--;
        }
        return matrix;
    }
}
