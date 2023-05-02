//Leetcode - Not accepted as it doesnt pass for all cases.
//1822. Sign of the Product of an Array
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class SignOfTheProductOfAnArray {

    public static void main(String[] args) {
        //int[] nums = { -1, -2, -3, -4, 3, 2, 1 };
        //int[] nums = {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        long prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
        }
        if (prod == 0)
            return 0;
        if (prod > 0)
            return 1;
        else
            return -1;
    }
}
