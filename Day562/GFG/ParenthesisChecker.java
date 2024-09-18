//GFG
//Parenthesis Checker
//Time complexity: O(|x|)
//Space complexity: O(|x|)

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        String x = "{([])}";
        System.out.println(ispar(x));
    }

    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // add your code here
        Map<Character, Character> mm = new HashMap<>();
        mm.put(')', '(');
        mm.put(']', '[');
        mm.put('}', '{');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                st.push(c);
            else if (st.empty())
                return false;
            else {
                if (st.peek() != mm.get(c))
                    return false;
                st.pop();
            }
        }
        return st.empty();
    }
}
