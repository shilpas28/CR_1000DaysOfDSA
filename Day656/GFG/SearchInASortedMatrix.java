//GFG
//Search in a sorted Matrix
//Time complexity: O(logn + logm)
//Space complexity: O(1)

public class SearchInASortedMatrix {

    public static void main(String[] args) {
        int mat[][] = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 } };
        int x = 14;
        System.out.println(searchMatrix(mat, x));
    }

    // Function to search a given number in row-column sorted matrix.
    public static boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int beg = 0, end = n * m - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            int rNo = mid / m;
            int cNo = mid % m;
            if (mat[rNo][cNo] == x)
                return true;
            if (mat[rNo][cNo] < x) {
                beg = mid + 1;
            } else
                end = mid - 1;
        }
        return false;
    }
}
