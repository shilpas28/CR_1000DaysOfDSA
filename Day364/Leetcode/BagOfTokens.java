//Leetcode
//948. Bag of Tokens
//Time complexity: O(NlogN)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class BagOfTokens {

    public static void main(String[] args) {
        int[] tokens = { 100, 200, 300, 400 };
        int power = 200;
        System.out.println(bagOfTokensScore(tokens, power));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        return helper(tokens, 0, tokens.length - 1, power, 0);
    }

    static int helper(int[] t, int i, int j, int p, int points) {
        if (i > j)
            return points;
        int max = points;
        if (t[i] <= p)
            max = Math.max(max, helper(t, i + 1, j, p - t[i], points + 1));
        else if (points >= 1)
            max = Math.max(max, helper(t, i, j - 1, p + t[j], points - 1));
        return max;
    }
}
