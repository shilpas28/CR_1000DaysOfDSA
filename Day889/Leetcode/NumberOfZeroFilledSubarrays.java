//Leetcode
//2348. Number of Zero-Filled Subarrays
//Time complexity: O(N)
//Space complexity: O(1)

public class NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 0, 0, 2, 0, 0, 4 };
        System.out.println(zeroFilledSubarray(nums));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long counter = 0;
        
        for (Integer ele : nums) {
            if (ele == 0) {
                counter++;
            } else {
                res += (counter * (counter + 1)) / 2;
                counter = 0;
            }
        }

        if (counter != 0) {
            res += (counter * (counter + 1)) / 2;
            counter = 0;
        }
        return res;
    }
}
