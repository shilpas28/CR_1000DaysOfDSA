//Leetcode
//169. Majority Element - Better method
//Time complexity: O(N*logN) + O(N), where N = size of the given array.
//We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. 
//So, it results in the first term O(N*logN). The second O(N) is for checking which element occurs more than floor(N/2) times. 
//If we use unordered_map instead,the first term will be O(N) for the best and average case and for the worst case,it will be O(N^2).
//Space complexity: O(N) as we are using a map data structure.

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // size of the given array:
        int n = nums.length;
        // declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        // storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value + 1);
        }
        // searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }
}
