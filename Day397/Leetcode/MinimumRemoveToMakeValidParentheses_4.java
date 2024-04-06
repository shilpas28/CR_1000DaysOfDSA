//Leetcode
//1249. Minimum Remove to Make Valid Parentheses - Optimal
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumRemoveToMakeValidParentheses_4 {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder ans = removeInvalid(s, '(', ')');
        ans = removeInvalid(ans.reverse(), ')', '(');
        return ans.reverse().toString();
    }

    static StringBuilder removeInvalid(CharSequence s, char open_char, char close_char) {
        StringBuilder answer = new StringBuilder();
        int open = 0, close = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch))
                answer.append(ch);
            else if (ch == open_char) {
                open++;
                answer.append(ch);
            } else {
                if (open > close) {
                    open--; // found a pair
                    answer.append(ch);
                } else {
                    // we did not find a ( to pair with )
                }
            }
        }
        return answer;
    }
}
