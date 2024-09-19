//Leetcode
//241. Different Ways to Add Parentheses - Tabulation
//Time complexity: O((n^3)*(x^2)), same as memoization solution.
//Space complexity: O((n^2)*x) for dp array. where, x is the number of ways to calcuate the expression which is operators!

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@SuppressWarnings("all")
public class DifferentWaysToAddParentheses_3 {

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] dp = new ArrayList[n][n];
        // Function to check if given substring of expression
        // is a valid expression
        BiFunction<Integer, Integer, Boolean> isValidExpression = (i,
                j) -> (i == 0 || isOperator(expression.charAt(i - 1))) &&
                        (j == n - 1 || isOperator(expression.charAt(j + 1)));
        // Get answer for all single digit numbers
        for (int i = 0; i < n; i++) {
            if (isValidExpression.apply(i, i)) {
                dp[i][i] = new ArrayList<>();
                dp[i][i].add(Integer.parseInt(expression.substring(i, i + 1)));
            }
        }
        // Get answer for all 2 digit numbers
        for (int i = 0, j = 1; j < n; i++, j++) {
            if (isValidExpression.apply(i, j)) {
                dp[i][j] = new ArrayList<>();
                dp[i][j].add(Integer.parseInt(expression.substring(i, i + 2)));
            }
        }
        // Get answer for all valid expression substrings in bottom up manner
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                if (!isValidExpression.apply(i, j)) {
                    continue;
                }
                dp[i][j] = new ArrayList<>();
                // Try to evaluate every operator
                for (int ind = i; ind <= j; ind++) {
                    if (isOperator(expression.charAt(ind))) {
                        char op = expression.charAt(ind);
                        // If char at ind is operator, get all results for its left and right substrings
                        List<Integer> left = dp[i][ind - 1];
                        List<Integer> right = dp[ind + 1][j];
                        // Try all options for left & right operands and add all results to the answer
                        for (int l : left) {
                            for (int r : right) {
                                if (op == '+') {
                                    dp[i][j].add(l + r);
                                } else if (op == '-') {
                                    dp[i][j].add(l - r);
                                } else if (op == '*') {
                                    dp[i][j].add(l * r);
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*');
    }
}
