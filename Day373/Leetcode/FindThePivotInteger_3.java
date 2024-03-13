//Leetcode
//2485. Find the Pivot Integer - Arithmetic Progression
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class FindThePivotInteger_3 {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        int ans = (n * n + n) / 2;
        int sq = (int) Math.sqrt(ans);
        if (sq * sq == ans)
            return sq;
        else
            return -1;
    }
}
