//Leetcode - Brute force method
//169. Majority Element
//Time complexity: O(N^2), where N = size of the given array.For every element of the array 
//the inner loop runs for N times. And there are N elements in the array. So, the total time complexity is O(N^2)
//Space complexity: O(1) as we use no extra space

package Leetcode;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // size of the given array:
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }
            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return nums[i];
        }
        return -1;
    }
}
