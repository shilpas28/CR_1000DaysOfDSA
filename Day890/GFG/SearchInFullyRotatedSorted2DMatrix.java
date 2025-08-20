//GFG
//Search in fully rotated sorted 2D matrix
//Time complexity: O(N^2)
//Space complexity: O(1)

public class SearchInFullyRotatedSorted2DMatrix {

    public static void main(String[] args) {
        int x = 3;
        int mat[][] = { { 7, 8, 9, 10 },
                { 11, 12, 13, 1 },
                { 2, 3, 4, 5 } };
        System.out.println(searchMatrix(mat, x));
    }

    public static boolean searchMatrix(int[][] mat, int x) {
        // code here
        for (int i = 0; i < mat.length; i++) { // i row search
            for (int j = 0; j < mat[0].length; j++) { // j row search
                if (mat[i][j] == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
