//Leetcode
//1608. Special Array With X Elements Greater Than or Equal X - Suffix-sum with pretty logic
//Time complexity: O(n), we iterate from 1 to n which is O(n) and also every num in array to store frequency which is O(n)
//Space complexity: O(n), since we're creating array of size n + 1 (from 0 to n) which is O(n)

package Leetcode;

public class SpecialArrayWithXElementsGreaterThanOrEqualX_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 5 };
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n + 1];
        for (int num : nums) {
            frequency[Math.min(n, num)]++;
        }
        int num_greater_equal = 0;
        for (int candidate_number = n; candidate_number > 0; --candidate_number) {
            num_greater_equal += frequency[candidate_number];
            if (candidate_number == num_greater_equal) {
                return candidate_number;
            }
        }
        return -1;
    }
}
