//Leetcode
//2485. Find the Pivot Integer - Linear Search
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class FindThePivotInteger {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        int rightSum = n * (n + 1) / 2;
        for (int i = 1, leftSum = 0; i <= n; ++i) {
            rightSum -= i;
            if (leftSum == rightSum) {
                return i;
            } else if (leftSum > rightSum) {
                return -1;
            }
            leftSum += i;
        }
        return -1;
    }
}
