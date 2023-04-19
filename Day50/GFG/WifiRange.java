//GFG - Brute force method
//Wifi Range
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;

public class WifiRange {

    public static void main(String[] args) {
        int N = 3, X = 0;
        String S = "010";
        System.out.println(wifiRange(N, S, X));
    }

    static boolean wifiRange(int N, String S, int X) {
        // code here
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '1') {
                for (int j = Math.max(0, i - X); j <= Math.min(i + X, N - 1); j++) {
                    visited[j] = true;
                }
            }
        }
        for (boolean val : visited) {
            if (val == false) {
                return false;
            }
        }
        return true;
    }
}
