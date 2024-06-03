//Leetcode
//2486. Append Characters to String to Make Subsequence
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class AppendCharactersToStringToMakeSubsequence {

    public static void main(String[] args) {
        String s = "coaching", t = "coding";
        System.out.println(appendCharacters(s, t));
    }

    public static int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j))
                j++;
            i++;
        }
        return n - j;
    }
}
