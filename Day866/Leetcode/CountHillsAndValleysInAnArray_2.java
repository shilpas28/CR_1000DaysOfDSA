//Leetcode
//2210. Count Hills and Valleys in an Array
//Time complexity: O(N)
//Space complexity: O(1)

public class CountHillsAndValleysInAnArray_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 1, 1, 6, 5 };
        System.out.println(countHillValley(nums));
    }

    public static int countHillValley(int[] nums) {
        int count = 0;
        int left = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if ((nums[i] > nums[left] && nums[i] > nums[i + 1]) ||
                        (nums[i] < nums[left] && nums[i] < nums[i + 1])) {
                    count++;
                }
                left = i;
            }
        }
        return count;
    }
}
