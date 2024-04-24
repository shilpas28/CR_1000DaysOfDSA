//Leetcode
//1137. N-th Tribonacci Number - Dynamic Programming (Memoization)
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber_2 {

    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }

    static int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);
        }

        memo.put(n, result);
        return result;
    }
}
