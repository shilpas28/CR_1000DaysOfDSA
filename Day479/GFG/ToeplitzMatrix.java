//GFG
//Toeplitz Matrix
//Time complexity: O(n*m)
//Space complexity: O(1) 

public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] mat = { { 6, 7, 8 },
                { 4, 6, 7 },
                { 1, 4, 6 } };
        System.out.println(isToepliz(mat));
    }

    /* You are required to complete this method */
    static boolean isToepliz(int mat[][]) {
        // Your code here
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int val = mat[i][0];
            int rowPtr = i, colPtr = 0;
            while (rowPtr < n && colPtr < m) {
                if (mat[rowPtr][colPtr] != val)
                    return false;
                rowPtr++;
                colPtr++;
            }
        }
        for (int i = 1; i < m; i++) {
            int val = mat[0][i];
            int rowPtr = 0, colPtr = i;
            while (rowPtr < n && colPtr < m) {
                if (mat[rowPtr][colPtr] != val)
                    return false;
                rowPtr++;
                colPtr++;
            }
        }
        return true;
    }
}
