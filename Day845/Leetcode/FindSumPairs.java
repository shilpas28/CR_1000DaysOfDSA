//Leetcode
//1865. Finding Pairs With a Certain Sum
//Time complexity: O(n+m+q1+q2*n)
//The initialization takes O(n+m) time to store the two arrays and build the frequency map for nums2. Each add(index, val) operation 
//takes O(1) time, so q1 calls take O(q1) in total. Each getPairs(tot) operation iterates over all elements in nums1 and performs a 
//hash map lookup for each, resulting in O(n) per call. So q2 calls take O(q2*n) in total.
//Space complexity: O(n+m)
//Storing the arrays nums1 and nums2 takes O(n) and O(m) space, respectively. The hash map stores the frequency of elements in nums2, 
//which takes O(m) space. Each add operation does not allocate additional memory beyond constant space, assuming we overwrite the 
//values in-place.

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> cnt;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.cnt = new HashMap<>();
        for (int num : nums2) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        cnt.put(oldVal, cnt.get(oldVal) - 1);
        nums2[index] += val;
        cnt.put(nums2[index], cnt.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : nums1) {
            int rest = tot - num;
            ans += cnt.getOrDefault(rest, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 2, 2, 3 };
        int[] b = { 1, 4, 5, 2, 5, 4 };
        FindSumPairs findSumPairs = new FindSumPairs(a, b);
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }
}
