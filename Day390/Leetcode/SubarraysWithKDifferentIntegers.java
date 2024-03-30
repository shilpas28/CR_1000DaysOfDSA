//Leetcode
//992. Subarrays with K Different Integers
//Time complexity: O(n), where n is the length of A.
//Space complexity: O(n)

package Leetcode;

public class SubarraysWithKDifferentIntegers {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int res = 0, sz = nums.length;
        int[] cnt = new int[sz + 1];
        for (int l = 0, m = 0, r = 0; r < sz; ++r) {
            if (++cnt[nums[r]] == 1)
                if (--k < 0) {
                    cnt[nums[m++]] = 0;
                    l = m;
                }
            if (k <= 0) {
                while (cnt[nums[m]] > 1)
                    --cnt[nums[m++]];
                res += m - l + 1;
            }
        }
        return res;
    }
}
