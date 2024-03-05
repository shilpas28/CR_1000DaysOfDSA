//Leetcode
//1750. Minimum Length of String After Deleting Similar Ends
//Time complexity:
//Space complexity:

package Leetcode;

public class MinimumLengthOfStringAfterDeletingSimilarEnds_2 {

    public static void main(String[] args) {
        String s = "aabccabba";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char c = s.charAt(j);
            while (i <= j && s.charAt(i) == c) {
                ++i;
            }
            while (i <= j && s.charAt(j) == c) {
                --j;
            }
        }
        return j - i + 1;
    }
}
