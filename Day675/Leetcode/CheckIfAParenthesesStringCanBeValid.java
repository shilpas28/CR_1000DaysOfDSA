//Leetcode
//2116. Check if a Parentheses String Can Be Valid - Stack 
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class CheckIfAParenthesesStringCanBeValid {

    public static void main(String[] args) {
        String s = "))()))";
        String locked = "010100";
        System.out.println(canBeValid(s, locked));
    }

    public static boolean canBeValid(String s, String locked) {
        int length = s.length();
        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }

        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        // Iterate through the string to handle '(' and ')'
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }
        // Match remaining open brackets with unlocked characters
        while (!openBrackets.empty() &&
                !unlocked.empty() &&
                openBrackets.peek() < unlocked.peek()) {
            openBrackets.pop();
            unlocked.pop();
        }

        if (!openBrackets.empty())
            return false;
        return true;
    }
}
