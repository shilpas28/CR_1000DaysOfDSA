//GFG
//Median in a row-wise sorted Matrix
//Time complexity: O(n log m * log(maxVal – minVal))
//Space complexity: O(1)

public class MedianInARowWiseSortedMatrix_2 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 } };
        System.out.println(median(mat));
    }

    public static int median(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        // Find the minimum and maximum elements in the matrix
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int desired = (n * m + 1) / 2;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // Count how many numbers are <= mid
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerEqual(mat[i], mid);
            }

            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    // Helper function to count elements <= target in a sorted row using binary
    // search
    static int countSmallerEqual(int[] row, int target) {
        int low = 0;
        int high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
