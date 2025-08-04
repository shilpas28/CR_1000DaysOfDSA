//GFG
//Maximum sum Rectangle
//Time complexity: O(n * m^2)
//Space complexity: O(n)

package GFG;

import java.util.Arrays;

public class MaximumSumRectangle {

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
        System.out.println(maxRectSum(mat));
    }

    public static int maxRectSum(int mat[][]) {
        // code here
        int n = mat.length;
        if (n == 0)
            return 0;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        int[] temp = new int[n];

        for (int left = 0; left < m; left++) {

            Arrays.fill(temp, 0);

            for (int right = left; right < m; right++) {

                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][right];
                }

                int currMax = temp[0];
                int currSum = temp[0];
                for (int i = 1; i < n; i++) {
                    currSum = Math.max(temp[i], currSum + temp[i]);
                    currMax = Math.max(currMax, currSum);
                }

                maxSum = Math.max(maxSum, currMax);
            }
        }
        return maxSum;
    }
}
