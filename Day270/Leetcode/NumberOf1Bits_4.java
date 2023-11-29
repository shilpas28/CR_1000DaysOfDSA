//Leetcode
//191. Number of 1 Bits
//Time complexity: O(N)
//Space complexity: O(N) for recursive stack

package Leetcode;

public class NumberOf1Bits_4 {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return hammingWeight(n & (n - 1)) + 1;
    }
}
