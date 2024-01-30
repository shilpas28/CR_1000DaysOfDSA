//Leetcode
//150. Evaluate Reverse Polish Notation
//Time complexity: O(N) - where N is the number of tokens in the input list tokens.
//Space complexity: O(N) - where N is the number of tokens in the input list tokens.

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        for (String s : tokens) {
            char c = s.charAt(0);
            if (c == '+') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a + b;
            } else if (c == '-' && s.length() == 1) {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a - b;
            } else if (c == '*') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a * b;
            } else if (c == '/') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a / b;
            } else
                stack[top++] = Integer.parseInt(s);
        }
        return stack[0];
    }
}
