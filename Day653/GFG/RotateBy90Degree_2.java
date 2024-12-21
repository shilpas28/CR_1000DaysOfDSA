//GFG
//Rotate by 90 degree - Modifying in the old matrix (Better method)
//Time complexity: O(N^2)
//Space complexity: O(1)

public class RotateBy90Degree_2 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotateby90(mat);
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        // code here
        int n = mat.length;
        // transpose of matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // swap mat[i][j] and mat[j][i]
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // reverse the matrix
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                // swap mat[low][i] and mat[high][i]
                int temp = mat[low][i];
                mat[low][i] = mat[high][i];
                mat[high][i] = temp;
                low++;
                high--;
            }
        }
    }
}
