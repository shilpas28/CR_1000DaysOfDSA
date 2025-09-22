//Leetcode
//3005. Count Elements With Maximum Frequency - Using 2 loops
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1, 4 };
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frqs = new HashMap<>();
        for (int num : nums) {
            frqs.put(num, frqs.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0, cntMaxFreq = 0;
        for (int frq : frqs.values()) {
            if (frq == maxFreq)
                cntMaxFreq++;
            else if (frq > maxFreq) {
                maxFreq = frq;
                cntMaxFreq = 1;
            }
        }
        return maxFreq * cntMaxFreq;
    }
}
