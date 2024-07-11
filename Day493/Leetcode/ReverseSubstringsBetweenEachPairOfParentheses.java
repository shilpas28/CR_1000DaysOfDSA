//Leetcode
//1190. Reverse Substrings Between Each Pair of Parentheses - Stack And Brute Force Reverse
//Time complexity: O(n^2), since we iterate through whole s and every time we encounter ) we reverse substring so in worst case 
//we will have O(n) * O(n) = O(n^2)
//Space complexity: O(n), since we use array ind_stack with size up to n / 2 -> O(n)

import java.util.Deque;
import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        String s = "(abcd)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Deque<Integer> indStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for (char char_s : s.toCharArray()) {
            if (char_s == '(') {
                indStack.push(res.length());
            } else if (char_s == ')') {
                int startInd = indStack.pop();
                String reversed = new StringBuilder(res.substring(startInd)).reverse().toString();
                res.replace(startInd, res.length(), reversed);
            } else {
                res.append(char_s);
            }
        }
        return res.toString();
    }
}
