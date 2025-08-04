//GFG
//Maximum sum Rectangle - Kadane Algorithm
//Time complexity: O(n * m^2)
//Space complexity: O(n)

package GFG;

public class MaximumSumRectangle_2 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
        System.out.println(maxRectSum(mat));
    }

    public static int maxRectSum(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < m; left++) {
            // Temp array to store row sums
            int[] temp = new int[n];

            for (int right = left; right < m; right++) {
                // Add current column to each row
                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][right];
                }
                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        return maxSum;
    }

    static int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
