//Leetcode
//241. Different Ways to Add Parentheses - Memoization
//Time complexity: O((n^2)*(n*(x^2))), as there are approx. n^2 states and to calculate these states 3 nested loops in 
//recursive function take O(n*(x^2)) time.
//Space complexity: O(n*x)+O((n^2)*x) for recursion stack & dp array. where, x is the number of ways to calcuate the 
//expression which is operators!

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses_2 {

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> dp = new HashMap<>();
        return getDiffWays(0, expression.length() - 1, dp, expression);
    }

    static List<Integer> getDiffWays(int i, int j, Map<String, List<Integer>> dp, String expression) {
        String key = i + "-" + j;
        // Return cached result if already calculated
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        // If length of the substring is 1 or 2
        // we encounter our base case i.e. a number found.
        int len = j - i + 1;
        if (len <= 2) {
            List<Integer> result = new ArrayList<>();
            result.add(Integer.parseInt(expression.substring(i, j + 1)));
            dp.put(key, result);
            return result;
        }
        // If it is not a number then it is an expression
        // now we try to evaluate every operator present in it
        List<Integer> res = new ArrayList<>();
        for (int ind = i; ind <= j; ind++) {
            if (isOperator(expression.charAt(ind))) {
                char op = expression.charAt(ind);
                // if char at ind is an operator
                // get all results for its left and right substring using recursion
                List<Integer> left = getDiffWays(i, ind - 1, dp, expression);
                List<Integer> right = getDiffWays(ind + 1, j, dp, expression);
                // try all options for left & right operand
                // and push all results to the answer
                for (int l : left) {
                    for (int r : right) {
                        if (op == '+') {
                            res.add(l + r);
                        } else if (op == '-') {
                            res.add(l - r);
                        } else if (op == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        dp.put(key, res);
        return res;
    }

    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*');
    }
}
