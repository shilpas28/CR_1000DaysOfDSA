//Leetcode
//2200. Find All K-Distant Indices in an Array - Enumerate
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 9, 1, 3, 9, 5 };
        int key = 9, k = 1;
        System.out.println(findKDistantIndices(nums, key, k));
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        // traverse number pairs
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    res.add(i);
                    break; // early termination to prevent duplicate addition
                }
            }
        }
        return res;
    }
}
