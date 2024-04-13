//Leetcode
//85. Maximal Rectangle - Optimal method
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.Stack;

public class MaximalRectangle_2 {

    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // Include an extra element for easier calculation
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }
            // Calculate max area using stack-based method
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}
