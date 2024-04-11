//Leetcode
//402. Remove K Digits
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class RemoveKDigits_2 {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        int len = num.length();
        // corner case
        if (k == len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            // whenever meet a digit which is less than the previous digit, discard the
            // previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }
        // construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        // remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
