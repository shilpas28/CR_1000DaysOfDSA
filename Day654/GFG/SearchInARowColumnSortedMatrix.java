//GFG
//Search in a Row-Column sorted matrix
//Time complexity: O(n+m)
//Space complexity: O(1)

package GFG;

public class SearchInARowColumnSortedMatrix {

    public static void main(String[] args) {
        int mat[][] = { { 3, 30, 38 }, { 20, 52, 54 }, { 35, 60, 69 } };
        int x = 62;
        System.out.println(matSearch(mat, x));
    }

    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int i = 0, j = mat[0].length - 1;
        while (i < mat.length && j >= 0) {
            if (mat[i][j] == x)
                return true;
            if (mat[i][j] > x) {
                j--;
            } else
                i++;
        }
        return false;
    }
}
