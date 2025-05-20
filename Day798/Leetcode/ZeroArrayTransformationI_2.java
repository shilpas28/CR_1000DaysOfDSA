//Leetcode
//3355. Zero Array Transformation I
//Time complexity: O(n+q)
//Space complexity: O(n)

public class ZeroArrayTransformationI_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1 };
        int[][] queries = { { 0, 2 } };
        System.out.println(isZeroArray(nums, queries));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]]--;
            if (q[1] + 1 < n)
                diff[q[1] + 1]++;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] > -sum)
                return false;
        }
        return true;
    }
}
