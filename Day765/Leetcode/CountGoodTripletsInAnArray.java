//Leetcode
//2179. Count Good Triplets in an Array - Policy Based Data Structure (Shortest) 
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CountGoodTripletsInAnArray {

    public static void main(String[] args) {
        int[] nums1 = { 2, 0, 1, 3 };
        int[] nums2 = { 0, 1, 2, 3 };
        System.out.println(goodTriplets(nums1, nums2));
    }

    public static long goodTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            mpp.put(nums1[i], i);
        int n = nums2.length;
        long total = 0;
        ArrayList<Integer> st = new ArrayList<>();
        for (int x : nums2) {
            int idx = mpp.get(x);
            int left = orderOfKey(st, idx);
            int right = (n - 1 - idx) - (st.size() - left);
            total += (long) left * right;
            int pos = Collections.binarySearch(st, idx);
            if (pos < 0)
                pos = -pos - 1;
            st.add(pos, idx);
        }
        return total;
    }

    static int orderOfKey(ArrayList<Integer> st, int key) {
        int pos = Collections.binarySearch(st, key);
        return pos < 0 ? -pos - 1 : pos;
    }
}
