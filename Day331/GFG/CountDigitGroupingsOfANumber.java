//GFG
//Count digit groupings of a number
//Time complexity: O(N^3) where N is the length of the string
//Space complexity: O(N^2)

package GFG;

import java.util.Arrays;

public class CountDigitGroupingsOfANumber {

    public static void main(String[] args) {
        String str = "1119";
        System.out.println(TotalCount(str));
    }

    public static int TotalCount(String str) {
        // Code here
        int n = str.length();
        int dp[][] = new int[n][901];
        for (int temp[] : dp)
            Arrays.fill(temp, -1);
        return help(str, 0, 0, dp);
    }

    static int help(String str, int index, int preSum, int dp[][]) {
        if (index == str.length())
            return 1;
        if (dp[index][preSum] != -1)
            return dp[index][preSum];
        int curSum = 0, ans = 0;
        for (int i = index; i < str.length(); i++) {
            curSum += str.charAt(i) - '0';
            if (curSum >= preSum) {
                ans += help(str, i + 1, curSum, dp);
            }
        }
        return dp[index][preSum] = ans;
    }
}
