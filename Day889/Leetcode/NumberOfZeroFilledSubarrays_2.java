//Leetcode
//2348. Number of Zero-Filled Subarrays
//Time complexity: O(N)
//Space complexity: O(1) 

public class NumberOfZeroFilledSubarrays_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 0, 0, 2, 0, 0, 4 };
        System.out.println(zeroFilledSubarray(nums));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long cnt = 0, streak = 0;
        for (int num : nums) {
            streak = (num == 0) ? streak + 1 : 0;
            cnt += streak;
        }
        return cnt;
    }
}
