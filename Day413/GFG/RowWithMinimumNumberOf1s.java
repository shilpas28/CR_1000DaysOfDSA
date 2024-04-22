//GFG
//Row with minimum number of 1's
//Time complexity: O(N*M)
//Space complexity: O(1)

package GFG;

public class RowWithMinimumNumberOf1s {

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] a = { { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 },
                { 1, 1, 1, 1 } };
        System.out.println(minRow(n, m, a));
    }

    static int minRow(int n, int m, int a[][]) {
        // code here
        int ans = -1, mn = Integer.MAX_VALUE, one = 0;
        for (int i = 0; i < n; i++) {
            one = 0;
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1)
                    one++;
            }
            if (one < mn) {
                mn = one;
                ans = i + 1;
            }
        }
        return ans;
    }
}
