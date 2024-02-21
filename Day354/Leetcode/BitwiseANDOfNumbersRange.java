//Leetcode
//201. Bitwise AND of Numbers Range
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class BitwiseANDOfNumbersRange {

    public static void main(String[] args) {
        int left = 5, right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        while (right > left)
            right &= right - 1;
        return right;
    }
}
