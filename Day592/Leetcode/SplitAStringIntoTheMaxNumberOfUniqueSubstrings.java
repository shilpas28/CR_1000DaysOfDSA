//Leetcode
//1593. Split a String Into the Max Number of Unique Substrings
//Time complexity: O(N*(2^N))
//Space complexity: O(N) 

import java.util.HashSet;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    public static void main(String[] args) {
        String s = "ababccc";
        System.out.println(maxUniqueSplit(s));
    }

    public static int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }

    static int backtrack(int start, String s, HashSet<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!seen.contains(substring)) {
                seen.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtrack(end, s, seen));
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
}
