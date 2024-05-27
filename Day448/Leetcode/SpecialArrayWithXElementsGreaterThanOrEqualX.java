//Leetcode
//1608. Special Array With X Elements Greater Than or Equal X - Brute force with binary search
//Time complexity: O(n*log n), we use sorting (nlogn) and also for every num in range [1, n] we call binary search which is 
//also O(nlogn)
//Space complexity: O(1) no extra space is used

package Leetcode;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static void main(String[] args) {
        int[] nums = { 3, 5 };
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int candidateNumber = 1; candidateNumber <= n; ++candidateNumber) {
            if (candidateNumber == findNumberOfNums(nums, n, candidateNumber)) {
                return candidateNumber;
            }
        }
        return -1;
    }

    static int findNumberOfNums(int[] nums, int n, int curNum) {
        int left = 0, right = n - 1;
        int firstIndex = n;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= curNum) {
                firstIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - firstIndex;
    }
}
