//Leetcode
//54. Spiral Matrix
//Time complexity: O(n*m)
//Space complexity: O(1)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    public static void main(String[] args) {
        int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(mat));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int R = matrix.length;
        int C = matrix[0].length;
        int top = 0, left = 0, bottom = R - 1, right = C - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                list.add(matrix[top][i]);

            top++;

            for (int i = top; i <= bottom; i++)
                list.add(matrix[i][right]);

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    list.add(matrix[bottom][i]);

                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    list.add(matrix[i][left]);

                left++;
            }
        }
        return list;
    }

}
