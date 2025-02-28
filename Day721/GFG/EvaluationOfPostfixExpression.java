//GFG
//Evaluation of Postfix Expression
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.Stack;

public class EvaluationOfPostfixExpression {

    public static void main(String[] args) {
        String[] arr = { "2", "3", "1", "*", "+", "9", "-" };
        System.out.println(evaluate(arr));
    }

    public static int evaluate(String[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for (String ch : arr) {
            if (isOperator(ch)) {
                int b = stack.pop();
                int a = stack.pop();
                int res = apply(a, b, ch);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.pop();
    }

    static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    static int apply(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return a;
        }
    }
}
