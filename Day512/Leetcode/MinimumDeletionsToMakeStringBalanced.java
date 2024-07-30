//Leetcode
//1653. Minimum Deletions to Make String Balanced - Use stack to cancel bad pairs
//Time complexity: O(n) where n = s.length()
//Space complexity: O(n) where n = s.length()

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDeletionsToMakeStringBalanced {

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {
        int cnt = 0;
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == 'b' && c == 'a') {
                stk.pop();
                ++cnt;
            } else {
                stk.push(c);
            }
        }
        return cnt;
    }
}
