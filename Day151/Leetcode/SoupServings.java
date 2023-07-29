//Leetcode
//808. Soup Servings
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class SoupServings {

    public static void main(String[] args) {
        int n = 50;
        System.out.println(soupServings(n));
    }

    public static double soupServings(int n) {
        if (n > 5000) { // trick
            return 1.0;
        }
        return helper(n, n, new Double[n + 1][n + 1]);
    }

    public static double helper(int A, int B, Double[][] memo) {
        if (A <= 0 && B <= 0)
            return 0.5; // base case 1
        if (A <= 0)
            return 1.0; // base case 2
        if (B <= 0)
            return 0.0; // base case 3
        if (memo[A][B] != null) {
            return memo[A][B];
        }
        int[] serveA = { 100, 75, 50, 25 };
        int[] serveB = { 0, 25, 50, 75 };
        memo[A][B] = 0.0;
        for (int i = 0; i < 4; i++) {
            memo[A][B] += helper(A - serveA[i], B - serveB[i], memo);
        }
        return memo[A][B] *= 0.25;
    }
}
