//GFG
//Number of paths in a matrix with k coins
//Time complexity: O(n*n*k)
//Space complexity: O(n*n*k)

package GFG;

public class NumberOfPathsInAMatrixWithKCoins_2 {

    public static void main(String[] args) {
        int k = 12, n = 3;
        int arr[][] = { { 1, 2, 3 },
                { 4, 6, 5 },
                { 3, 2, 1 } };
        System.out.println(numberOfPath(n, k, arr));
    }

    static long ans;

    static long numberOfPath(int n, int k, int[][] arr) {
        // code here
        ans = 0;
        dfs(0, 0, arr, k);
        return ans;
    }

    static void dfs(int i, int j, int arr[][], int k) {
        int m = arr.length, n = arr[0].length;
        if (k < 0)
            return;

        if (i >= 0 && i < m && j >= 0 && j < n) {

            if (i == m - 1 && j == n - 1 && k == arr[i][j])
                ans++;

            dfs(i + 1, j, arr, k - arr[i][j]);
            dfs(i, j + 1, arr, k - arr[i][j]);
        }
    }
}
