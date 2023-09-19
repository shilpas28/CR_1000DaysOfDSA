//Leetcode - Better method
//287. Find the Duplicate Number - using Frequency array
//Time complexity: O(N), as we are traversing through the array only once.
//Space complexity: O(N), as we are using extra space for frequency array.

package Leetcode;

public class FindTheDuplicateNumber_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[nums[i]] == 0) {
                freq[nums[i]] += 1;
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}
