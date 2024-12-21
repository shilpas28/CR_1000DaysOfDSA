//GFG
//Rotate by 90 degree - Creating a new matrix
//Time complexity: O(N^2)
//Space complexity: O(N^2)

public class RotateBy90Degree {

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
        int n = mat.length; // this is valid only for n*n matrix
        int temp[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                temp[n - j - 1][i] = mat[i][j];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = temp[i][j];
    }
}
