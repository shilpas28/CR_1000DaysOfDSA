//Leetcode
//1190. Reverse Substrings Between Each Pair of Parentheses - Wormhole Teleportation
//Time complexity: O(n), since we ho through each character of s twice which is still O(n)
//Space complexity: O(n), since we use stack_start_ind of size up to n / 2 and index_pairs of size n which is O(n)

import java.util.Deque;
import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses_2 {

    public static void main(String[] args) {
        String s = "(abcd)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        int n = s.length();
        int[] index_pairs = new int[n];
        Deque<Integer> stack_start_ind = new LinkedList<>();

        for (int char_ind = 0; char_ind < n; ++char_ind) {
            char char_s = s.charAt(char_ind);
            if (char_s == '(') {
                stack_start_ind.push(char_ind);
            } else if (char_s == ')') {
                int start_ind = stack_start_ind.pop();
                index_pairs[char_ind] = start_ind;
                index_pairs[start_ind] = char_ind;
            }
        }

        StringBuilder res = new StringBuilder();
        int cur_ind = 0;
        int cur_dir = 1;

        while (cur_ind < n) {
            char char_s = s.charAt(cur_ind);
            if (char_s == '(' || char_s == ')') {
                cur_ind = index_pairs[cur_ind];
                cur_dir *= -1;
            } else {
                res.append(char_s);
            }
            cur_ind += cur_dir;
        }
        return res.toString();
    }
}
