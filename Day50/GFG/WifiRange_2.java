//GFG - Better solution
//Wifi Range
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class WifiRange_2 {
    public static void main(String[] args) {
        int N = 3, X = 0;
        String S = "010";
        System.out.println(wifiRange(N, S, X));
    }

    static boolean wifiRange(int N, String S, int X) {
        // code here
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '1') {
                int start = Math.max(i - X, 0);
                int end = i + X;
                visited[start] += 1;
                if (end + 1 < N) {
                    visited[end + 1] += -1;
                }
            }
        }
        for (int i = 1; i < N; i++)
            visited[i] += visited[i - 1];
        for (int val : visited) {
            if (val == 0) {
                return false;
            }
        }
        return true;
    }
}
