//Leetcode
//3397. Maximum Number of Distinct Elements After Operations
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfDistinctElementsAfterOperations {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 3, 4 };
        int k = 2;
        System.out.println(maxDistinctElements(nums, k));
    }

    public static int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> uniqueValues = new HashSet<>();
        int last = Integer.MIN_VALUE;

        for (int value : nums) {
            int newPos = Math.max(last + 1, value - k);
            if (newPos <= value + k) {
                uniqueValues.add(newPos);
                last = newPos;
            }
        }

        return uniqueValues.size();
    }
}
