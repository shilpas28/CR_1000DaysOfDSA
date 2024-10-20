//Leetcode
//1106. Parsing A Boolean Expression - Iterative solution
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ParsingABooleanExpression_2 {

    public static void main(String[] args) {
        String expression = "&(|(f))";
        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {
        Deque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == ')') {
                Set<Character> seen = new HashSet<>();
                while (stk.peek() != '(')
                    seen.add(stk.pop());
                stk.pop();// pop out '('.
                char operator = stk.pop(); // get operator for current expression.
                if (operator == '&') {
                    stk.push(seen.contains('f') ? 'f' : 't'); // if there is any 'f', & expression results to 'f'
                } else if (operator == '|') {
                    stk.push(seen.contains('t') ? 't' : 'f'); // if there is any 't', | expression results to 't'
                } else { // ! expression.
                    stk.push(seen.contains('t') ? 'f' : 't'); // Logical NOT flips the expression.
                }
            } else if (c != ',') {
                stk.push(c);
            }
        }
        return stk.pop() == 't';
    }
}
