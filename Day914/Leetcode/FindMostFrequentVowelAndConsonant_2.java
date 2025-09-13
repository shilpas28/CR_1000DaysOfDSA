//Leetcode
//3541. Find Most Frequent Vowel and Consonant - Map 
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.HashMap;
import java.util.Map;

public class FindMostFrequentVowelAndConsonant_2 {

    public static void main(String[] args) {
        String s = "successes";
        System.out.println(maxFreqSum(s));
    }

    public static int maxFreqSum(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int con = 0, vow = 0;
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if ("aeiou".indexOf(ch) >= 0)
                vow = Math.max(vow, count);
            else
                con = Math.max(con, count);
        }
        return con + vow;
    }
}
