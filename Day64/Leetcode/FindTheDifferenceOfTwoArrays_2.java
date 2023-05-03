//Leetcode - using frequency arrays 
//2215. Find the Difference of Two Arrays
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindTheDifferenceOfTwoArrays_2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] freq1 = new int[2001];
		for(int el: nums1){
			freq1[el + 1000]++;
		}

		int[] freq2 = new int[2001];
		for(int el: nums2){
			freq2[el + 1000]++;
		}

		List<Integer> firstEl = new ArrayList<>();
		for(int el: nums1){
			if(freq2[el+1000] == 0) {
				if(!firstEl.contains(el)) {
					firstEl.add(el);
				}
			}
		}

		List<Integer> secondEl = new ArrayList<>();
		for(int el: nums2){
			if(freq1[el+1000] == 0){
				if(!secondEl.contains(el)) {
					secondEl.add(el);
				}
			}
		}

		List<List<Integer>> ans = new ArrayList<>();
		ans.add(firstEl);
		ans.add(secondEl);

		return ans;
    }
}
