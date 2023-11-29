//Leetcode
//191. Number of 1 Bits
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class NumberOf1Bits_2 {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int result = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                result++;
            mask = mask << 1;
        }
        return result;
    }
}
