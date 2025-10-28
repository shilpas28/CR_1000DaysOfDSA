//Leetcode
//3354. Make Array Elements Equal to Zero - With Extra Space 
//Time complexity: O(N)
//Space complexity: O(N)

public class MakeArrayElementsEqualToZero {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 0, 3 };
        System.out.println(countValidSelections(nums));
    }

    public static int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
            right[n - i - 1] = right[n - i] + nums[n - i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                continue;
            if (left[i] == right[i])
                count += 2;
            else if (Math.abs(left[i] - right[i]) == 1)
                count += 1;
        }

        return count;
    }
}
