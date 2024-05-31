//Leetcode
//260. Single Number III
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

import java.util.Arrays;

public class SingleNumberIII_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {
        int xor2no = 0;
        for (int num : nums) {
            xor2no ^= num;
        }

        int lowestBit = xor2no & (-xor2no);
        int[] result = new int[2];
        for (int num : nums) {
            if ((lowestBit & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
