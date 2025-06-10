//Leetcode
//3442. Maximum Difference Between Even and Odd Frequency I
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashMap;
import java.util.Map;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI_2 {

    public static void main(String[] args) {
        String s = "aaaaabbc";
        System.out.println(maxDifference(s));
    }

    public static int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count % 2 == 0) {
                minEven = Math.min(minEven, count);
            } else {
                maxOdd = Math.max(maxOdd, count);
            }
        }

        return maxOdd - minEven;
    }
}
