//Leetcode
//921. Minimum Add to Make Parentheses Valid
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAddToMakeParenthesesValid_2 {

    public static void main(String[] args) {
        String str = "(((";
        System.out.println(minAddToMakeValid(str));
    }

    public static int minAddToMakeValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !stk.isEmpty() && stk.peek() == '(') // pop out matched pairs.
                stk.pop();
            else // push in unmatched chars.
                stk.push(c);
        }
        return stk.size();
    }
}
