//Leetcode
//2981. Find Longest Special Substring That Occurs Thrice I - Brute Force 
//Time complexity: O(N^2)
//Space complexity: O(N^2) 

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLongestSpecialSubstringThatOccursThriceI {

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(maximumLength(s));
    }

    public static int maximumLength(String s) {
        int n = s.length();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                StringBuilder str = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    str.append(s.charAt(k));
                }
                Set<Character> uniqueChars = new HashSet<>();
                for (int l = 0; l < str.length(); l++) {
                    uniqueChars.add(str.charAt(l));
                }
                if (uniqueChars.size() == 1) {
                    mp.put(str.toString(), mp.getOrDefault(str.toString(), 0) + 1);
                }
            }
        }
        int maxi = -1;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() >= 3) {
                maxi = Math.max(maxi, entry.getKey().length());
            }
        }
        return maxi;
    }
}
