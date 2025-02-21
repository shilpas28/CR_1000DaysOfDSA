//GFG
//Parenthesis Checker
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println(isBalanced(s));
    }

    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if (st.isEmpty())
                    return false;
                char ch = st.pop();
                if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{'))
                    continue;
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
