//Leetcode
//191. Number of 1 Bits
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class NumberOf1Bits {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 2) & 1;
            n = n >>> 1;
        }
        return result;
    }
}
