//Leetcode
//1208. Get Equal Substrings Within Budget - Optimised Sliding Window [1 Pass] 
//Time complexity: O(n). Each character in the string is processed at most once, once by the right pointer and left pointer 
//is constant. Thus 1 pass solution.
//Space complexity: O(1). No additional space is used.

package Leetcode;

public class GetEqualSubstringsWithinBudget_3 {

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r;
        for (r = 0; r < s.length(); r++) {
            maxCost -= Math.abs(s.charAt(r) - t.charAt(r));
            if (maxCost < 0)
                maxCost += Math.abs(s.charAt(l) - t.charAt(l++));
        }
        return r - l;
    }
}
