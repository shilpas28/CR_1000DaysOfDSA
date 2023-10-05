//Leetcode - Better method
//229. Majority Element II
//Time complexity: O(N*logN), where N = size of the given array. We are using a map data structure. Insertion in the map 
//takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). If we use unordered_map 
//instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N^2).
//Space complexity: O(N) as we are using a map data structure. We are also using a list that stores a maximum of 2 elements. 
//That space used is so small that it can be considered constant.

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length; // size of the array
        List<Integer> ls = new ArrayList<>(); // list of answers
        // declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        // least occurrence of the majority element:
        int mini = (int) (n / 3) + 1;
        // storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value + 1);
            // checking if v[i] is
            // the majority element:
            if (mpp.get(nums[i]) == mini) {
                ls.add(nums[i]);
            }
            if (ls.size() == 2)
                break;
        }
        return ls;
    }

}
