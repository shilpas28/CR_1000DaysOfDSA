//Leetcode
//1143. Longest Common Subsequence - Space Optimization
//Time complexity: O(N*M) - There are two nested loops.
//Space complexity: O(M) - We are using an external array of size 'M+1' to store only two rows.

package Leetcode;

public class LongestCommonSubsequence_3 {

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    // Function to find the length of the Longest Common Subsequence (LCS)
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Create arrays to store the LCS lengths
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];
        // Iterate through the strings and calculate LCS lengths
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS
                // length
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                // If the characters are different, choose the maximum LCS length by either
                // excluding a character in s1 or excluding a character in s2
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // Update the 'prev' array to the values of 'cur' for the next iteration
            prev = (int[]) (cur.clone());
        }
        return prev[m]; // Return the length of the Longest Common Subsequence (LCS)
    }
}
