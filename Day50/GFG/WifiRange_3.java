//GFG - Optimal solution
//Wifi Range
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class WifiRange_3 {
    public static void main(String[] args) {
        int N = 3, X = 0;
        String S = "010";
        System.out.println(wifiRange(N, S, X));
    }

    static boolean wifiRange(int N, String S, int X) {
        // code here
        int st = 0;
        while (st < N && S.charAt(st) != '1') {
            st += 1;
        }
        if (st == N || st > X) {
            return false;
        }
        int last = st;
        for (int i = st; i < N; i++) {
            if (i - last + 1 > 2 * (X + 1)) {
                // System.out.println(last + " and " + i);
                return false;
            }
            if (S.charAt(i) == '1') {
                last = i;
            }
        }
        if (N - last > X + 1) {
            return false;
        }
        return true;
    }
}
