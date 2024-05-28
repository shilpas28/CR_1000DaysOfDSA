//Leetcode
//1208. Get Equal Substrings Within Budget - Sliding Window
//Time complexity: O(n). Each character in the string is processed at most twice, once by the right pointer and once by the 
//left pointer. Thus 2 pass solution.
//Space complexity: O(1). No additional space is used.

package Leetcode;

public class GetEqualSubstringsWithinBudget_2 {

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int l = 0, cost = 0, result = 0;

        for (int r = 0; r < s.length(); r++) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
