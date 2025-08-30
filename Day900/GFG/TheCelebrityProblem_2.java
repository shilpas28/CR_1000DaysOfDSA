//GFG
//The Celebrity Problem
//Time complexity: O(N)
//Space complexity: O(1)

public class TheCelebrityProblem_2 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 1 } };
        System.out.println(celebrity(mat));
    }

    public static int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (mat[j][i] == 1)
                j--;
            else
                i++;
        }
        int c = i;
        for (int k = 0; k < n; k++) {
            if (k == c)
                continue;
            if (mat[c][k] != 0 || mat[k][c] != 1)
                return -1;
        }
        return c;
    }
}
