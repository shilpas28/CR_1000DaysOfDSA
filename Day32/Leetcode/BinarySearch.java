//Leetcode - Iterative approach
//704. Binary Search
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                low++;
            else
                high--;
        }
        return -1;
    }
}
