//Leetcode
//1750. Minimum Length of String After Deleting Similar Ends
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        String s = "aabccabba";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right;) {
            if (chars[left] == chars[right]) {
                char c = chars[left];
                while (left < right && chars[left] == c) {
                    left++;
                    length--;
                }
                while (right >= left && chars[right] == c) {
                    right--;
                    length--;
                }
            } else
                break;
        }
        return length;
    }
}
