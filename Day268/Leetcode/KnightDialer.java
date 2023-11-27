//Leetcode
//935. Knight Dialer
//Time complexity: O(n * 10) where n is the given input. This is because for each digit, there are at most 10 possible next 
//moves, and the recursion is performed for each remaining move.
//Space complexity: O(n * 10) for the cache array, as it stores intermediate results for optimization. The recursion stack 
//also contributes to the space complexity.

package Leetcode;

public class KnightDialer {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(knightDialer(n));
    }

    static final int mod = (int) 1e9 + 7;
    static final int[][] MOVES = {
            /* 0 */ { 4, 6 },
            /* 1 */ { 6, 8 },
            /* 2 */ { 7, 9 },
            /* 3 */ { 4, 8 },
            /* 4 */ { 0, 3, 9 },
            /* 5 */ {},
            /* 6 */ { 0, 1, 7 },
            /* 7 */ { 2, 6 },
            /* 8 */ { 1, 3 },
            /* 9 */ { 2, 4 }
    };
    static final int[][] cache = new int[5001][10];

    public static int knightDialer(int n) {
        return knightDialer(n, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }

    static int knightDialer(int remaining, int[] nextNumbers) {
        if (remaining == 1)
            return nextNumbers.length;
        int count = 0;

        for (int nextNumber : nextNumbers) {
            int cur = cache[remaining][nextNumber];
            if (cur == 0) {
                cur = knightDialer(remaining - 1, MOVES[nextNumber]);
                cache[remaining][nextNumber] = cur;
            }
            count += cur;
            count %= mod;
        }
        return count;
    }
}
