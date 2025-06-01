//GFG
//Count pairs Sum in matrices
//Time complexity: O(N^2)
//Space complexity: O(1)

public class CountPairsSumInMatrices_2 {

    public static void main(String[] args) {
        int x = 21;
        int mat1[][] = { { 1, 5, 6 }, { 8, 10, 11 }, { 15, 16, 18 } };
        int mat2[][] = { { 2, 4, 7 }, { 9, 10, 12 }, { 13, 16, 20 } };
        System.out.println(countPairs(mat1, mat2, x));
    }

    static int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        int i = 0, j = 0, k = n - 1, l = n - 1, ans = 0;
        while (i < n && j < n && k >= 0 && l >= 0) {
            if (mat1[i][j] + mat2[k][l] == x) {
                ans++;
                if (j == n - 1) {
                    j = 0;
                    i++;
                } else
                    j++;
                if (l == 0) {
                    l = n - 1;
                    k--;
                } else
                    l--;
            } else if (mat1[i][j] + mat2[k][l] > x) {
                if (l == 0) {
                    l = n - 1;
                    k--;
                } else
                    l--;
            } else {
                if (j == n - 1) {
                    j = 0;
                    i++;
                } else
                    j++;
            }
        }
        return ans;
    }
}
