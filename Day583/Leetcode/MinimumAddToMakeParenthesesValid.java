//Leetcode
//921. Minimum Add to Make Parentheses Valid
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {
        String str = "(((";
        System.out.println(minAddToMakeValid(str));
    }

    public static int minAddToMakeValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                stk.push(c);
            else if (stk.isEmpty())
                ++count;
            else
                stk.pop();
        }
        return count + stk.size();
    }
}
