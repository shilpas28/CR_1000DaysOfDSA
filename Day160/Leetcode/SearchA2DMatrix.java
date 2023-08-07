//Leetcode
//74. Search a 2D Matrix
//Time complexity: O(log(R * C)
//Space complexity: O(1)

package Leetcode;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if (r == 0)
            return false;

        int c = matrix[0].length;
        int r1 = 0, r2 = r - 1, mid;
        while (r1 < r2) {
            mid = r1 + (r2 - r1) / 2;
            if (matrix[mid][c - 1] < target)
                r1 = mid + 1;
            else if (matrix[mid][0] > target)
                r2 = mid - 1;
            else {
                r1 = mid;
                break;
            }
        }

        int c1 = 0, c2 = c - 1;
        while (c1 <= c2) {
            mid = c1 + (c2 - c1) / 2;
            if (matrix[r1][mid] < target)
                c1 = mid + 1;
            else if (matrix[r1][mid] > target)
                c2 = mid - 1;
            else
                return true;
        }
        return false;
    }
}
