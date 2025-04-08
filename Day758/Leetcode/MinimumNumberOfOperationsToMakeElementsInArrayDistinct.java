//Leetcode
//3396. Minimum Number of Operations to Make Elements in Array Distinct - Simulation 
//Time complexity: O(N^2)
//Space complexity: O(N) 

import java.util.HashSet;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 2, 3, 3, 5, 7 };
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i += 3, ans++) {
            if (checkUnique(nums, i)) {
                return ans;
            }
        }
        return ans;
    }

    static boolean checkUnique(int[] nums, int start) {
        HashSet<Integer> cnt = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (cnt.contains(nums[i])) {
                return false;
            }
            cnt.add(nums[i]);
        }
        return true;
    }
}
