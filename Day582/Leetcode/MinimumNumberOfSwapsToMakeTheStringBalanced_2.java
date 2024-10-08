//Leetcode
//1963. Minimum Number of Swaps to Make the String Balanced - Using Stack and Simulation
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced_2 {

    public static void main(String[] args) {
        String s = "][][";
        System.out.println(minSwaps(s));
    }

    public static int minSwaps(String s) {
        // remove the balanced part from the given string
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

        int n = stack.size();
        int swap = 0;
        while (n > 0) {
            swap++;
            n -= 4;
        }
        return swap;
    }
}
