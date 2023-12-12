//Leetcode
//1464. Maximum Product of Two Elements in an Array - Second Biggest
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

public class MaximumProductOfTwoElementsInAnArray_3 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        int biggest = 0;
        int secondBiggest = 0;
        for (int num : nums) {
            if (num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest, num);
            }
        }
        return (biggest - 1) * (secondBiggest - 1);
    }
}
