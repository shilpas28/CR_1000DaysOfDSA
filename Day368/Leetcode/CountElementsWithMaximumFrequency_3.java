//Leetcode
//3005. Count Elements With Maximum Frequency - Using a single loop
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1, 4 };
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frqs = new HashMap<>();
        int maxFreq = 0, cntMaxFreq = 0;
        for (int num : nums) {
            int frq = frqs.getOrDefault(num, 0) + 1;
            if (frq == maxFreq)
                cntMaxFreq++;
            else if (frq > maxFreq) {
                maxFreq = frq;
                cntMaxFreq = 1;
            }
            frqs.put(num, frq);
        }
        return maxFreq * cntMaxFreq;
    }
}
