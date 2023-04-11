//Leetcode
//2390. Removing Stars From a String
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Stack;

public class RemovingStarsFromAString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*')
                stack.pop();
            else
                stack.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);
        return sb.toString();
    }
}
