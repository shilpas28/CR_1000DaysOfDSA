//Leetcode
//3375. Minimum Operations to Make Array Values Equal to K - Using Set 
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashSet;

public class MinimumOperationsToMakeArrayValuesEqualToK_3 {

    public static void main(String[] args) {
        int nums[] = { 5, 2, 5, 4, 5 };
        int k = 2;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        int mini = Integer.MAX_VALUE;
        for (int num : nums)
            mini = Math.min(mini, num);
        if (mini < k)
            return -1;

        HashSet<Integer> st = new HashSet<>();
        for (int num : nums)
            st.add(num);
        return st.size() - (mini == k ? 1 : 0);
    }
}
