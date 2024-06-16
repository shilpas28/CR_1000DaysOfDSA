//Leetcode
//330. Patching Array
//Time complexity: O(N)
//Space complexity: O(1) 

public class PatchingArray {

    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        int n = 6;
        System.out.println(minPatches(nums, n));
    }

    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                result++;
            }
        }
        return result;
    }
}
