//Leetcode
//2900. Longest Unequal Adjacent Groups Subsequence I - Greedy 
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI_2 {

    public static void main(String[] args) {
        String[] words = { "e", "a", "b" };
        int[] groups = { 0, 0, 1 };
        System.out.println(getLongestSubsequence(words, groups));
    }

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
