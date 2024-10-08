//Leetcode
//1963. Minimum Number of Swaps to Make the String Balanced - Using Stack
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public static void main(String[] args) {
        String s = "][][";
        System.out.println(minSwaps(s));
    }

    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[')
                stack.push(ch);
            else {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    stack.push(ch);
            }
        }
        int unb = stack.size() / 2; // # of open or close bracket
        return (unb + 1) / 2;
    }
}
