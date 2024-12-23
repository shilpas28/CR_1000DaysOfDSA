//GFG
//Search in a row-wise sorted matrix
//Time complexity: O(nlogm)
//Space complexity: O(1)

public class SearchInARowWiseSortedMatrix {

    public static void main(String[] args) {
        int mat[][] = { { 3, 4, 9 }, { 2, 5, 6 }, { 9, 25, 27 } };
        int x = 9;
        System.out.println(searchRowMatrix(mat, x));
    }

    // Function to search a given number in row-column sorted matrix.
    public static boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        for (int i = 0; i < mat.length; i++) {
            int lo = 0, hi = mat[0].length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (mat[i][mid] == x)
                    return true;
                if (mat[i][mid] < x) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
