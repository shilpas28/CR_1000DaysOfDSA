//GFG
//Largest subsquare surrounded by X
//Time complexity: O(N^3)
//Space complexity: O(N^2)

package GFG;

public class LargestSubsquareSurroundedByX {

    public static void main(String[] args) {
        int n = 4;
        char[][] a = { { 'X', 'X', 'X', 'O' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'X', 'O' },
                { 'X', 'O', 'X', 'X' } };
        System.out.println(largestSubsquare(n, a));
    }

    static int largestSubsquare(int n, char a[][]) {
        // code here
        int left[][] = new int[n][n];
        int top[][] = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    if (i != 0) {
                        top[i][j] = top[i - 1][j] + 1;
                    } else
                        top[i][j] = 1;
                    if (j != 0) {
                        left[i][j] = left[i][j - 1] + 1;
                    } else
                        left[i][j] = 1;
                }
                int minX = Math.min(top[i][j], left[i][j]);
                while (minX != 0) {
                    int k = j - minX + 1;
                    int l = i - minX + 1;
                    if (top[i][k] >= minX && left[l][j] >= minX) {
                        ans = Math.max(ans, minX);
                        break;
                    }
                    minX--;
                }
            }
        }
        return ans;
    }
}
