//GFG
//Boolean Parenthesization - Not accepted as TLE
//Time complexity: O(N!)
//Space complexity: O(N^2)

public class BooleanParenthesization {

    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(countWays(s));
    }

    static int countWays(String s) {
        // code here
        return solve(s, 0, s.length() - 1, 1) % 1003;
    }

    static int solve(String str, int i, int j, int isTrue) {
        if (i > j)
            return 0; // empty string
        if (i == j)
            return (str.charAt(i) == (isTrue == 1 ? 'T' : 'F')) ? 1 : 0;
        // only one ch - return True if true else false

        int temp_ans = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            int lt = solve(str, i, k - 1, 1);
            int lf = solve(str, i, k - 1, 0);
            int rt = solve(str, k + 1, j, 1);
            int rf = solve(str, k + 1, j, 0);

            if (str.charAt(k) == '&') {
                temp_ans += (isTrue == 1) ? (lt * rt) : (lt * rf + lf * rt + lf * rf);
            } else if (str.charAt(k) == '|') {
                temp_ans += (isTrue == 1) ? (lt * rt + lt * rf + lf * rt) : (lf * rf);
            } else if (str.charAt(k) == '^') {
                temp_ans += (isTrue == 1) ? (lt * rf + lf * rt) : (lt * rt + lf * rf);
            }
        }

        return temp_ans % 1003;
    }
}
