//Leetcode
//1248. Count Number of Nice Subarrays - One pass
//Time complexity: O(N)
//Space complexity: O(1)

public class CountNumberOfNiceSubarrays_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0, i = 0, count = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                k += nums[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }
}
