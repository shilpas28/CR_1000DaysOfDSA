//Leetcode
//2311. Longest Binary Subsequence Less Than or Equal to K - One Pass
//Time complexity: O(N)
//Space complexity: O(1)

public class LongestBinarySubsequenceLessThanOrEqualToK_2 {

    public static void main(String[] args) {
        String s = "1001010";
        int k = 5;
        System.out.println(longestSubsequence(s, k));
    }

    public static int longestSubsequence(String s, int k) {
        int res = 0, cost = 1, n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '0' || cost <= k) {
                k -= cost * (s.charAt(i) - '0');
                res++;
            }
            if (cost <= k)
                cost *= 2;
        }
        return res;
    }
}
