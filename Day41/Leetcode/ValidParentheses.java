//Leetcode
//20. Valid Parentheses
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(isBalanced(str));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else {
                if (st.empty() == true)
                    return false;
                else if (matching(st.peek(), s.charAt(i)) == false)
                    return false;
                else
                    st.pop();
            }
        }
        return (st.empty() == true);
    }

    public static boolean matching(char a, char b) {
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }

}
