//Leetcode
//1647. Minimum Deletions to Make Character Frequencies Unique
//Time complexity: O(N) - note that the second loop will not have more than 26 * 26 total operations.
//Space complexity: O(1) - as we will not store more than 26 different frequencies.

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        String s = "aaabbbcc";
        System.out.println(minDeletions(s));
    }

    public static int minDeletions(String s) {
        int cnt[] = new int[26], res = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < s.length(); ++i)
            ++cnt[s.charAt(i) - 'a'];
        for (int i = 0; i < 26; ++i) {
            while (cnt[i] > 0 && !used.add(cnt[i])) {
                --cnt[i];
                ++res;
            }
        }
        return res;
    }
}
