//Leetcode
//201. Bitwise AND of Numbers Range
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class BitwiseANDOfNumbersRange_2 {

    public static void main(String[] args) {
        int left = 5, right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            cnt++;
        }
        return (left << cnt);
    }
}
