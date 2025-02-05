//Leetcode
//1790. Check if One String Swap Can Make Strings Equal - Frequency Map + Check Differences
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        String s1 = "bank", s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s1FrequencyMap = new char[26];
        char[] s2FrequencyMap = new char[26];
        int numDiffs = 0;

        for (int i = 0; i < s1.length(); i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if (s1Char != s2Char) {
                numDiffs++;
                // numDiffs is more than 2, one string swap will not make two strings equal
                if (numDiffs > 2)
                    return false;
            }
            // increment frequencies
            s1FrequencyMap[s1Char - 'a']++;
            s2FrequencyMap[s2Char - 'a']++;
        }
        // check if frequencies are equal
        return Arrays.equals(s1FrequencyMap, s2FrequencyMap);
    }
}
