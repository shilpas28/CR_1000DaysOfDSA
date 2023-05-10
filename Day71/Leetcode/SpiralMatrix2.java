//Leetcode
//59. Spiral Matrix II
//Time complexity: O(N*M)
//Space complexity: O(1)

package Leetcode;

public class SpiralMatrix2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] ans = generateMatrix(n);
        for (int arr[] : ans) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 0;
        int R = n, C = n;
        int top = 0, left = 0, bottom = R - 1, right = C - 1;

        while (top <= bottom && left <= right && count <= (n * n)) {
            for (int i = left; i <= right; i++)
                res[top][i] = ++count;

            top++;

            for (int i = top; i <= bottom; i++)
                res[i][right] = ++count;

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    res[bottom][i] = ++count;

                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    res[i][left] = ++count;

                left++;
            }
        }
        return res;
    }
}
