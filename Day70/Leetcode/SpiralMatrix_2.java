//Leetcode
//54. Spiral Matrix
//Time complexity: O(n*m)
//Space complexity: O(1)

package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_2 {
    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println(spiralOrder(mat));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int n = matrix.length, m = matrix[0].length;
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;
        while (res.size() < n * m) {
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);
            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
