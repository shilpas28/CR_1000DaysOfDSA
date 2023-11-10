//GFG
//Number following a pattern
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class NumberFollowingAPattern {

    public static void main(String[] args) {
        String s = "D";
        System.out.println(printMinNumberForPattern(s));
    }

    static String printMinNumberForPattern(String S) {
        // code here
        int n = S.length();
        int cnt = 1;
        char[] ans = new char[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == n || S.charAt(i) == 'I') {
                // itr back for every i
                for (int j = i - 1; j >= -1; j--) {
                    ans[j + 1] = (char) ('0' + cnt);
                    cnt++;
                    if (j >= 0 && S.charAt(j) == 'I') // while itr back , break as soon as I is found.
                        break;
                }
            }
        }
        return new String(ans);
    }
}
