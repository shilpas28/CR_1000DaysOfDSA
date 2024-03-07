//GFG
//Longest repeating and non-overlapping substring
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package GFG;

public class LongestRepeatingAndNonOverlappingSubstring {

    public static void main(String[] args) {
        int n = 7;
        String s = "heheheh";
        System.out.println(longestSubstring(s, n));
    }

    static String longestSubstring(String s, int n) {
        // code here
        String str = "";
        int i = 0, j = 0;
        while (i < n && j < n) {
            String substr = s.substring(i, j + 1);
            if (s.substring(j + 1, n).indexOf(substr) != -1) {
                if (str.length() < (j - i + 1))
                    str = substr;
            } else
                i++;
            j++;
        }
        return str == "" ? "-1" : str;
    }
}
