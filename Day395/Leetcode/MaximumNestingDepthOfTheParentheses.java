//Leetcode
//1614. Maximum Nesting Depth of the Parentheses
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {

        Stack<Character> st = new Stack<>();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                depth = Math.max(depth, st.size());
                st.pop();
            }
        }
        return depth;
    }
}
