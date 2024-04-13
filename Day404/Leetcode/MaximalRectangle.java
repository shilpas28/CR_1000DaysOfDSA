//Leetcode
//85. Maximal Rectangle - Naive method
//Time complexity: O(N^3)
//Space complexity: O(N)

package Leetcode;

public class MaximalRectangle {

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
            // Calculate max area using histogram method
            int n = heights.length; // Number of bars in the histogram

            for (int i = 0; i < n; i++) {
                for (int j = i, minHeight = Integer.MAX_VALUE; j < n; j++) {
                    minHeight = Math.min(minHeight, heights[j]);
                    int area = minHeight * (j - i + 1);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
