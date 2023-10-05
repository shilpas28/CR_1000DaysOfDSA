//Leetcode - Brute force method
//229. Majority Element II
//Time complexity: O(N^2), where N = size of the given array. For every element of the array the inner loop 
//runs for N times. And there are N elements in the array. So, the total time complexity is O(N^2).
//Space complexity: O(1) as we are using a list that stores a maximum of 2 elements. 
//The space used is so small that it can be considered constant. 

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length; // size of the array
        List<Integer> ls = new ArrayList<>(); // list of answers
        for (int i = 0; i < n; i++) {
            // selected element is v[i]:
            // Checking if v[i] is not already
            // a part of the answer:
            if (ls.size() == 0 || ls.get(0) != nums[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    // counting the frequency of v[i]
                    if (nums[j] == nums[i]) {
                        cnt++;
                    }
                }
                // check if frquency is greater than n/3:
                if (cnt > (n / 3))
                    ls.add(nums[i]);
            }
            if (ls.size() == 2)
                break;
        }
        return ls;
    }

}
