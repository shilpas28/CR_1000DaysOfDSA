//Leetcode
//150. Evaluate Reverse Polish Notation
//Time complexity: O(N) - where N is the number of tokens in the input list tokens.
//Space complexity: O(N) - where N is the number of tokens in the input list tokens.

import java.util.Stack;

public class EvaluateReversePolishNotation_2 {

    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
                long integer2 = stack.pop();
                long integer1 = stack.pop();
                char operator = tokens[i].charAt(0);
                long resolvedAns = resolves(integer1, integer2, operator);
                stack.push(resolvedAns);
            } else {
                stack.push(Long.parseLong(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }

    static long resolves(long a, long b, char Operator) {
        if (Operator == '+')
            return a + b;
        else if (Operator == '-')
            return a - b;
        else if (Operator == '*')
            return a * b;
        return a / b;
    }
}
