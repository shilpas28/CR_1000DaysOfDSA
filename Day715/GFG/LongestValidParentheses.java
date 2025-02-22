//GFG
//Longest valid Parentheses
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "((()";
        System.out.println(maxLength(s));
    }

    static int maxLength(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && st.size() > 1 && s.charAt(st.peek()) == '(') {
                st.pop();
            } else {
                st.push(i);
            }
        }
        int lim = s.length(), ans = 0;
        while (!st.isEmpty()) {
            int p = st.pop();
            ans = Math.max(ans, lim - p - 1);
            lim = p;
        }
        return ans;
    }
}
