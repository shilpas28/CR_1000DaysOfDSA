//GFG
//Search in fully rotated sorted 2D matrix
//Time complexity: O(log(n * m))
//Space complexity: O(1)

public class SearchInFullyRotatedSorted2DMatrix_3 {

    public static void main(String[] args) {
        int x = 3;
        int mat[][] = { { 7, 8, 9, 10 },
                { 11, 12, 13, 1 },
                { 2, 3, 4, 5 } };
        System.out.println(searchMatrix(mat, x));
    }

    public static boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = n * m - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mat[mid / m][mid % m];
            if (midVal == x)
                return true;
            int leftVal = mat[left / m][left % m];
            int rightVal = mat[right / m][right % m];
            if (leftVal <= midVal) {
                if (x >= leftVal && x < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (x > midVal && x <= rightVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
