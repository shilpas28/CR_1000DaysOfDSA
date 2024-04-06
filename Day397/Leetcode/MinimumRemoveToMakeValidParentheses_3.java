//Leetcode
//1249. Minimum Remove to Make Valid Parentheses - Naive
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumRemoveToMakeValidParentheses_3 {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder R = new StringBuilder();
        int open = 0, close = 0;

        // remove invalid close parenthesis
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                R.append(ch);
            } else if (ch == '(') {
                open++;
                R.append(ch);
            } else {
                if (open > close) { // if there is an '(' to be considered for a valid pair
                    R.append(ch);
                    close++;
                } else {
                    open = open < 0 ? 0 : open--;
                }
            }
        }

        s = R.toString();
        R.setLength(0); // reset ans
        int n = s.length();
        open = close = 0;

        // remove invalid open parenthesis

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                R.insert(0, ch);
            } else if (ch == ')') {
                R.insert(0, ch);
                close++;
            } else {
                if (close > open) {
                    R.insert(0, ch);
                    open++;
                } else {
                    close = close < 0 ? 0 : close--;
                }
            }
        }
        return R.toString();
    }
}
