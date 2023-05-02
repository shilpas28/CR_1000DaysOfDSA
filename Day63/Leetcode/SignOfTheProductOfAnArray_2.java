//Leetcode 
//1822. Sign of the Product of an Array
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class SignOfTheProductOfAnArray_2 {
    public static void main(String[] args) {
        // int[] nums = { -1, -2, -3, -4, 3, 2, 1 };
        // int[] nums =
        // {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        int[] nums = { 9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24 };
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int neg = 0;
        for (int i : nums) {
            if (i == 0)
                return 0;
            if (i < 0)
                neg++;
        }
        return neg % 2 == 0 ? 1 : -1;
    }
}
