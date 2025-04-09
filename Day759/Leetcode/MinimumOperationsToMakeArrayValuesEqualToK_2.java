//Leetcode
//3375. Minimum Operations to Make Array Values Equal to K - Using Hashmap
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class MinimumOperationsToMakeArrayValuesEqualToK_2 {

    public static void main(String[] args) {
        int nums[] = { 5, 2, 5, 4, 5 };
        int k = 2;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i : nums)
            if (i < k)
                return -1;
            else if (i > k)
                mpp.put(i, mpp.getOrDefault(i, 0) + 1);
        return mpp.size();
    }
}
