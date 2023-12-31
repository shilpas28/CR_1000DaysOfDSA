//Leetcode
//1624. Largest Substring Between Two Equal Characters - Brute Force 
//Time complexity: O(n^2)
//Space complexity: O(1)

package Leetcode;

public class LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left + 1; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    ans = Math.max(ans, right - left - 1);
                }
            }
        }
        return ans;
    }

}
