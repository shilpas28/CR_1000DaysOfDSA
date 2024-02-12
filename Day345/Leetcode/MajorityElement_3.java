//Leetcode
//169. Majority Element - Optimal method
//Time complexity: O(N) + O(N), where N = size of the given array.
//The first O(N) is to calculate the count and find the expected majority element. The second one is to check 
//if the expected element is the majority one or not.
//Space complexity: O(1) as we are not using any extra space.

package Leetcode;

public class MajorityElement_3 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // size of the given array:
        int n = nums.length;
        int cnt = 0; // count
        int el = 0; // Element
        // applying the algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i])
                cnt++;
            else
                cnt--;
        }
        // checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el)
                cnt1++;
        }
        if (cnt1 > (n / 2))
            return el;
        return -1;
    }
}
