//GFG
//Min Add to Make Parentheses Valid
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class MinAddToMakeParenthesesValid {

    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(minParentheses(s));
    }

    public static int minParentheses(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(')');
                }
            } else {
                st.push('(');
            }
        }
        return st.size();
    }
}
