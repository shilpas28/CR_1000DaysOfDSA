//Leetcode
//3396. Minimum Number of Operations to Make Elements in Array Distinct - Reverse traversal
//Time complexity: O(N)
//Space complexity: O(N)

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 2, 3, 3, 5, 7 };
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }
}
