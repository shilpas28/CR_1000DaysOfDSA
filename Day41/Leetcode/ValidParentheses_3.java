//Leetcode - same as first solution, but in a single function
//20. Valid Parentheses
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Stack;

public class ValidParentheses_3 {
    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(isBalanced(str));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty() || (st.peek() == '(' && c != ')') || (st.peek() == '{' && c != '}')
                        || (st.peek() == '[' && c != ']')) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
