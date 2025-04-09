//Leetcode
//3375. Minimum Operations to Make Array Values Equal to K - Using Bitset 
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.BitSet;

public class MinimumOperationsToMakeArrayValuesEqualToK_4 {

    public static void main(String[] args) {
        int nums[] = { 5, 2, 5, 4, 5 };
        int k = 2;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        int mini = Integer.MAX_VALUE;
        for (int i : nums)
            mini = Math.min(mini, i);
        if (mini < k)
            return -1;

        BitSet st = new BitSet(100001);
        for (int i : nums)
            if (i > k)
                st.set(i);

        return st.cardinality();
    }
}
