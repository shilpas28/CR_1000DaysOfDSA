//Leetcode
//1249. Minimum Remove to Make Valid Parentheses - Using Deque
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumRemoveToMakeValidParentheses_2 {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();

        // push invalid indices in deque
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                deque.push(i);
            } else if (c == ')') {
                if (deque.isEmpty()) {
                    chars[i] = '#';
                } else {
                    deque.pop();
                }
            }
        }
        // mark invalid indices
        while (!deque.isEmpty()) {
            chars[deque.pop()] = '#';
        }

        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            if (c != '#') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
