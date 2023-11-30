//Leetcode
//1611. Minimum One Bit Operations to Make Integers Zero
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class MinimumOneBitOperationsToMakeIntegersZero_3 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(minimumOneBitOperations(n));
    }

    public static int minimumOneBitOperations(int n) {
        int res = 0;
        for (int temp = n; temp != 0; temp = temp / 2) {
            res ^= temp;
        }
        return res;
    }
}
