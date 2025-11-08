//Leetcode
//1611. Minimum One Bit Operations to Make Integers Zero
//Time complexity: O(logN)
//Space complexity: O(1)

public class MinimumOneBitOperationsToMakeIntegersZero_2 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(minimumOneBitOperations(n));
    }

    public static int minimumOneBitOperations(int n) {
        int multiplier = 1;
        int res = 0;
        while (n > 0) {
            res += n ^ (n - 1) * multiplier;
            multiplier = -1 * multiplier;
            n &= n - 1;
        }
        return Math.abs(res);
    }
}
